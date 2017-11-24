package com.wan.dataM.admin.modular.system.service.impl;

import com.wan.dataM.admin.common.persistence.dao.DmAlertInfoMapper;
import com.wan.dataM.admin.common.persistence.dao.DmMonitorInfoMapper;
import com.wan.dataM.admin.common.persistence.model.DmAlertInfo;
import com.wan.dataM.admin.common.persistence.model.DmMonitorInfo;
import com.wan.dataM.admin.core.util.HttpUtils;
import com.wan.dataM.admin.modular.system.controller.AlertController;
import com.wan.dataM.admin.modular.system.dao.AmbariautorecoverDao;
import com.wan.dataM.admin.modular.system.service.IAmbariautorecoverService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * ambari自动恢复Service
 *
 */
@Service
public class AmbariautorecoverServiceImpl implements IAmbariautorecoverService {

    ScheduledExecutorService service;

    @Resource
    AmbariautorecoverDao ambariautorecoverDao;

    @Resource
    DmAlertInfoMapper dmalertinfoMapper;

    @Resource
    DmMonitorInfoMapper dmMonitorInfoMapper;

    @Override
    public void startAutoRecover() {

        if(service!=null)
            stopAutoRecover();

        service= Executors.newScheduledThreadPool(1);

        ScheduledFuture sf =service.scheduleWithFixedDelay(new RecoverRunner(),1,60, TimeUnit.SECONDS);

    }

    @Override
    public void stopAutoRecover() {
        if(service!=null){
            service.shutdown();
            int i=0;
            while(!service.isTerminated()&&i<10){
                i++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            service.shutdownNow();
            service=null;
            System.out.println("停止自动恢复");
        }
    }

    private class RecoverRunner implements Runnable{

        @Override
        public void run() {

            disposeCriticals();

            disposeOks();

            disposeRecovers();

        }

        private void disposeCriticals(){
            List<Map<String,Object>> criticals_alert_history = AmbariautorecoverServiceImpl.this.ambariautorecoverDao.selectCriticals();

            List<DmAlertInfo> criticals_dais = convertMaps2Dmalertinfo(criticals_alert_history);

            for(DmAlertInfo dai:criticals_dais) {

                DmAlertInfo criticals_dai = AmbariautorecoverServiceImpl.this.dmalertinfoMapper.selectOne(dai);
                if(criticals_dai==null){
                    AmbariautorecoverServiceImpl.this.dmalertinfoMapper.insert(dai);
                }

                DmAlertInfo criticals_dai_afterinsert = AmbariautorecoverServiceImpl.this.dmalertinfoMapper.selectOne(dai);
                //此处调用告警api
                if(criticals_dai_afterinsert.getAlertType()==1)
                    AlertController.exeAlert(criticals_dai_afterinsert.getId(),"1");

            }
        }

        private void disposeOks(){
            List<Map<String,Object>> oks_alert_history = AmbariautorecoverServiceImpl.this.ambariautorecoverDao.selectOks();

            List<DmAlertInfo> oks_dais = convertMaps2Dmalertinfo(oks_alert_history);

            for(DmAlertInfo dai:oks_dais) {
                Integer alert_id = dai.getAlertId();
                Date alert_time = dai.getAlertTime();

                DmAlertInfo oks_dai = AmbariautorecoverServiceImpl.this.ambariautorecoverDao.selectLastAlert(dai.getMonitorId().toString(),dai.getDefinitionId().toString(),
                        dai.getServiceName(),dai.getComponentName(),dai.getHostName());
                if(oks_dai!=null){
                    oks_dai.setRecoverTime(alert_time);
                    oks_dai.setAlertRecoverId(alert_id);
                    AmbariautorecoverServiceImpl.this.dmalertinfoMapper.updateById(oks_dai);

                    //此处调用恢复api
                    if(oks_dai.getAlertType()==1)
                        AlertController.exeAlert(oks_dai.getId(),"0");
                }
            }
        }

        private void disposeRecovers(){
            List<Map<String,Object>> recovers_alert_history = AmbariautorecoverServiceImpl.this.ambariautorecoverDao.selectAutoRecovers();

            for(Map<String,Object> dai:recovers_alert_history){

                DmMonitorInfo dmi = AmbariautorecoverServiceImpl.this.dmMonitorInfoMapper.selectById(Integer.parseInt(dai.get("monitor_id").toString()));

                String auto_recover_api = dmi.getAutoRecoverApi();

                boolean status = HttpUtils.checkState(dai,auto_recover_api,2);
                if(status == false){

                    DmAlertInfo daiObject = AmbariautorecoverServiceImpl.this.dmalertinfoMapper.selectOne(convertMap2Dmalertinfo(dai));

                    Integer old_retry_count = daiObject.getAutoRecoverRetryCount();

                    daiObject.setAutoRecoverRetryCount(old_retry_count+1);

                    daiObject.setAutoRecoverLastTime(new Date((System.currentTimeMillis()/1000)*1000));

                    HttpUtils.putAutoRecover(dai,auto_recover_api,2);

                    AmbariautorecoverServiceImpl.this.dmalertinfoMapper.updateAllColumnById(daiObject);
                }
            }

        }

        private List<DmAlertInfo> convertMaps2Dmalertinfo(List<Map<String,Object>> maps){
            List<DmAlertInfo> ret = new ArrayList<>();
            for(Map<String,Object> map : maps){
                ret.add(convertMap2Dmalertinfo(map));
            }
            return ret;
        }

        private DmAlertInfo convertMap2Dmalertinfo(Map<String,Object> map){
            DmAlertInfo dmalertinfo = new DmAlertInfo();
            dmalertinfo.setMonitorId(map.get("monitor_id")==null?null:Integer.parseInt(map.get("monitor_id").toString()));
            dmalertinfo.setDefinitionId(map.get("definition_id")==null?null:Integer.parseInt(map.get("definition_id").toString()));
            dmalertinfo.setServiceName(map.get("service_name")==null?null:map.get("service_name").toString());
            dmalertinfo.setComponentName(map.get("component_name")==null?null:map.get("component_name").toString());
            dmalertinfo.setHostName(map.get("host_name")==null?null:map.get("host_name").toString());
            dmalertinfo.setAlertId(map.get("alert_id")==null?null:Integer.parseInt(map.get("alert_id").toString()));
            dmalertinfo.setAlertType(map.get("alert_type")==null?null:Integer.parseInt(map.get("alert_type").toString()));
            dmalertinfo.setAlertTime(map.get("alert_time")==null?null:new Date((Long.parseLong(map.get("alert_time").toString())/1000)*1000));
            dmalertinfo.setAlertRecoverId(map.get("alert_recover_id")==null?null:Integer.parseInt(map.get("alert_recover_id").toString()));
            dmalertinfo.setAutoRecoverRetryCount(map.get("auto_recover_retry_count")==null?null:Integer.parseInt(map.get("auto_recover_retry_count").toString()));
            dmalertinfo.setAutoRecoverLastTime(map.get("auto_recover_last_time")==null?null:new Date((Long.parseLong(map.get("auto_recover_last_time").toString())/1000)*1000));
            dmalertinfo.setRecoverTime(map.get("recover_time")==null?null:new Date((Long.parseLong(map.get("recover_time").toString())/1000)*1000));
            return dmalertinfo;
        }

    }
}

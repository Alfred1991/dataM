package com.wan.dataM.admin.modular.system.controller;

import com.wan.dataM.admin.modular.system.dao.AlertMgrDao;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Map;

/**
 * Created by Administrator on 2017/11/22.
 */
public class AlertController {

    @Resource
    private AlertMgrDao alertMgrDao;


    public  void exeAlert(int id,String status) {
        System.out.println("id = " + id);
       Map<String, Object> DM_monitor_info = alertMgrDao.selectDM_alert_info(id);

            if((Integer)DM_monitor_info.get("alert_send_count") == 0){
                wechatAlert((String)DM_monitor_info.get("alert_content"));
                alertMgrDao.updateDM_alert_info(id);
            }else{
                SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String last = (String)DM_monitor_info.get("alert_send_last_time");
                String now = simpleFormat.format(new Date());
                System.out.println(last);
                System.out.println(now);
                long from = 0;
                long to = 0;
                try {
                     from = simpleFormat.parse(last).getTime();
                     to = simpleFormat.parse(now).getTime();
                }catch(Exception e ){
                    System.out.println("convert time fail!");
                    e.printStackTrace();
                }
                int minutes = (int) ((to - from)/(1000 * 60));
                if(minutes >= (Integer)DM_monitor_info.get("schedule_interval")){
                    wechatAlert((String)DM_monitor_info.get("alert_content"));
                    alertMgrDao.updateDM_alert_info(id);
                }else{
                    System.out.println("don't need to alert!");
                }
            }




    }

    public void wechatAlert(String content){
        System.out.println("WeChat Alert!");
    }
    public static void main(String[] args){
        AlertController a = new AlertController();
//        a.exeMonitor();
    }

}

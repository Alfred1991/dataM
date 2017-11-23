package com.wan.dataM.admin.modular.system.controller;

import com.wan.dataM.admin.modular.system.dao.AlertMgrDao;
import com.wan.dataM.core.util.SpringContextHolder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/22.
 */
public class AlertController {




    public  static void exeAlert(int id,String status) {

        AlertMgrDao alertMgrDao = (AlertMgrDao) SpringContextHolder.getBean("alertMgrDao");
        Map<String, Object> DM_monitor_info = alertMgrDao.selectDM_alert_info(id);

        if(Integer.valueOf(status) == 0){
            wechatAlert("Success recovery! The alert_content is : " + (String)DM_monitor_info.get("alert_content"));
        }else {
            //判断alert_send_count是否为0，若是，则发送报警
            if ((Integer) DM_monitor_info.get("alert_send_count") == 0) {
                wechatAlert((String) DM_monitor_info.get("alert_content"));
                alertMgrDao.updateDM_alert_info(id);
            } else {
                //判断上一次报警时间是否大于schedule_interval的十倍，若是，则发送报警
                SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String last = DM_monitor_info.get("alert_send_last_time").toString();
                String now = simpleFormat.format(new Date());
                long from = 0;
                long to = 0;
                try {
                    from = simpleFormat.parse(last).getTime();
                    to = simpleFormat.parse(now).getTime();
                } catch (Exception e) {
                    System.out.println("convert time fail!");
                    e.printStackTrace();
                }
                int minutes = (int) ((to - from) / (1000 * 60));
                System.out.println("minuties = " + minutes);
                if (minutes >= ((Integer) DM_monitor_info.get("schedule_interval") * 10)) {
                    wechatAlert((String) DM_monitor_info.get("alert_content"));
                    alertMgrDao.updateDM_alert_info(id);
                } else {
                    System.out.println("don't need to alert!");
                }
            }
        }



    }

    /**
     *
     * @param content =  报警内容
     * @return boolean结果
     */
    public static boolean wechatAlert(String content){
        boolean flag=false;
        System.out.println("exe wechat alert!");
        String api_sn = "21a490efa7604554";
        String u="http://api.monitor.37wan.com/api/return_value.php?api_sn="+api_sn+"&auth=FBDC0B5CEAEAE1A149975F082B43D";
        System.out.println(u);
        BufferedReader in=null;
        try {
            URL url=new URL(u);
            HttpURLConnection con=(HttpURLConnection)url.openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setUseCaches(false);
            con.setRequestMethod("POST");
            con.setInstanceFollowRedirects(true);
            con.setRequestProperty("content-type", "application/x-www-form-urlencoded;charset=UTF-8");
            con.connect();
            //发送信息

//        	String message = " test alert by Robust";
            String key = "status";
            String value = "0";
            Date now = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
            String currentTime = dateFormat.format( now );
            String msg=currentTime+" "+ content;
            String postMsg="result[" + key +
                    "]=" + value +
                    "&msg=" + msg;
            System.out.println(postMsg);
            PrintWriter out = new PrintWriter(new OutputStreamWriter(con.getOutputStream(),"utf-8"));
            out.println(postMsg);
            out.flush();
            out.close();

            //获取返回的结果
            in=new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
            String line;
            StringBuffer stringBuffer = new StringBuffer();
            while((line=in.readLine())!= null){
                line = new String(line.getBytes(), "utf-8");
                stringBuffer.append(line);
            }
            line = stringBuffer.toString().substring(stringBuffer.toString().indexOf("{"),stringBuffer.toString().indexOf("}")+1);
//            JSONObject jb = JSONObject.fromObject(line);
//            int ret= jb.getInt("ret");
            System.out.println(line);
//            if(ret==0){
//                flag=true;
//            }else{
//                flag=false;
//            }
            in.close();
            con.disconnect();
        } catch (IOException e) {
            // TODO Auto-generated catch block

        }finally{
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return flag;
    }


}

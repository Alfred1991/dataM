package com.wan.dataM.admin.modular.system.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/22.
 */
public class Test {
    public static void main(String[] args) throws Exception{
        Map<String, Object> DM_monitor_info = new HashMap<String, Object>();
        DM_monitor_info.put("alert_send_last_time","2017-11-22 16:20:03");

        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String last = (String)DM_monitor_info.get("alert_send_last_time");
        String now = simpleFormat.format(new Date());
        System.out.println(last);
        System.out.println(now);
        long from = simpleFormat.parse(last).getTime();
        long to = simpleFormat.parse(now).getTime();
        int minutes = (int) ((to - from)/(1000 * 60));
        System.out.println(minutes);
    }
}

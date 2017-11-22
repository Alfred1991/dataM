package com.wan.dataM.admin.core.util;

import com.wan.dataM.admin.modular.system.controller.AlertController;

/**
 * Created by Administrator on 2017/11/22.
 */
public class Alert {
    public static void receiveAlert(int dm_alert_info_id,String status)  {
        new AlertController().exeAlert(dm_alert_info_id,status);
    }
}

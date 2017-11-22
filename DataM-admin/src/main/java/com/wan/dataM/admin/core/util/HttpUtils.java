package com.wan.dataM.admin.core.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * Created by lh on 2017/11/21.
 */
public class HttpUtils {

    private static boolean try2PutAutoRecover(String url,String bodyString) throws Exception{
        boolean ret = false;

        CloseableHttpClient httpclient = HttpClients.createDefault();

        CloseableHttpResponse response = null;

        HttpPut httpput = new HttpPut(url);

        httpput.setHeader("X-Requested-By","ambari");

        httpput.setHeader("Authorization","Basic YWRtaW46YWRtaW4=");

        StringEntity se = new StringEntity(bodyString);

        httpput.setEntity(se);

        try {
            response = httpclient.execute(httpput);

            if(response.getStatusLine().getStatusCode()==202){

                InputStreamReader isr = new InputStreamReader(response.getEntity().getContent());

                BufferedReader bis = new BufferedReader(isr);

                StringBuilder body = new StringBuilder();

                String line;

                while((line=bis.readLine())!=null){
                    body.append(line);
                    body.append("\r\n");
                }

                JSONObject jo = JSON.parseObject(body.toString());

                String status = jo.getJSONObject("Requests").getString("status");


                if(status.equalsIgnoreCase("Accepted")){
                    ret=true;
                }

            }else{
                throw new Exception(response.getStatusLine().getStatusCode()+"-"+response.getStatusLine().getReasonPhrase());
            }

        }finally{

            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return ret;
    }


    private static boolean try2CheckState(String url) throws Exception{
        boolean ret = true;

        CloseableHttpClient httpclient = HttpClients.createDefault();

        CloseableHttpResponse response = null;

        HttpGet httpget = new HttpGet(url);

        httpget.setHeader("X-Requested-By","ambari");

        httpget.setHeader("Authorization","Basic YWRtaW46YWRtaW4=");

        try {
                response = httpclient.execute(httpget);

            if(response.getStatusLine().getStatusCode()==200){

                InputStreamReader isr = new InputStreamReader(response.getEntity().getContent());

                BufferedReader bis = new BufferedReader(isr);

                StringBuilder body = new StringBuilder();

                String line;

                while((line=bis.readLine())!=null){
                    body.append(line);
                    body.append("\r\n");
                }

                JSONObject jo = JSON.parseObject(body.toString());

                String desired_status = jo.getJSONObject("HostRoles").getString("desired_state");

                String maintenance = jo.getJSONObject("HostRoles").getString("maintenance_state");

                if(!desired_status.equalsIgnoreCase("STARTED")&&maintenance.equalsIgnoreCase("OFF")){
                    ret=false;
                }

            }else{
                throw new Exception(response.getStatusLine().getStatusCode()+"-"+response.getStatusLine().getReasonPhrase());
            }

        }finally{

            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    public static boolean putAutoRecover(Map<String,Object> map,String api,int retrytimes) {
        boolean ret=true;

        String[] urlandbody = replacedollar(map,api).split(" \\| ");

        for(int i=0;i<retrytimes;i++){
            try {
                ret = try2PutAutoRecover(urlandbody[1],urlandbody[0]);
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return ret;
    }

    public static boolean checkState(Map<String,Object> map, String api, int retrytimes) {
        boolean ret=true;

        String[] urlandbody = replacedollar(map,api).split(" \\| ");

        for(int i=0;i<retrytimes;i++){
            try {
                ret = try2CheckState(urlandbody[1]);
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return ret;
    }

    private static String replacedollar(Map<String,Object> map,String api){
        String ret=api;
        for(Map.Entry<String,Object> entry:map.entrySet()) {
            String key = "${"+entry.getKey()+"}";
            String value = entry.getValue().toString();
            ret = ret.replace(key,value);
        }
        return ret;
    }

}

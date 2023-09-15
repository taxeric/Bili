package com.lanier.bili.utils;


import android.util.Log;
import android.webkit.CookieManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bob
 * Date : 21-9-1
 * Describe :
 */
public class CookieUtils {

    private static final String TAG = "CookieUtils";

    public static final String VMID = "DedeUserID";
    public static final String SESSDATA = "SESSDATA";

    public static String getVmid(){
        return SpUtils.mSharedPreferences.getString(VMID, "");
    }

    public static String getSessdata(){
        return SpUtils.mSharedPreferences.getString(SESSDATA, "");
    }

    public static void saveCookie(String url){
        CookieManager cookieManager = CookieManager.getInstance();
        String cookieStr = cookieManager.getCookie(url);
        Log.i("Cookies","Cookies = "+ cookieStr);
        Map<String,String> cookieMap = cookieToMap(cookieStr);

        SpUtils.INSTANCE.saveMap(cookieMap);
    }

    public static Map<String,String> cookieToMap(String value){
        Map<String,String> map = new HashMap<>();
        value = value.replace(" ","");
        if (value.contains(";")){
            String values[] = value.split(";");
            for(String val : values){
                String vals[] = val.split("=");
                map.put(vals[0],vals[1]);
            }
        }else {
            String values[] = value.split("=");
            map.put(values[0],values[1]);
        }
        return map;
    }
}

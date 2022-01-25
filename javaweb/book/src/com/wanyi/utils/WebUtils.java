package com.wanyi.utils;

import com.wanyi.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public class WebUtils {
    public static <T> T copyParam2Bean(T object, Map<String, String[]> map) {
        try {
            BeanUtils.populate(object, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    public static int parseInt(String strInt, int defValue) {
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defValue;
    }

}

package com.adouer.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class JsonUtils {
    public static String getJson(Object ob , String str) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        //不用时间戳
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS , false);
        //
        DateFormat df = new SimpleDateFormat(str);
        mapper.setDateFormat(df);
        String s = mapper.writeValueAsString(ob);
        return s;
    }

    public static String getJson(Object ob) throws JsonProcessingException {
        return getJson(ob,"yyyy-MM-dd HH:mm:ss");
    }
}

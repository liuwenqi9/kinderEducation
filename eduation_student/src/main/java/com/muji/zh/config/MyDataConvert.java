package com.muji.zh.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MyDataConvert implements Converter<String, Date> {

    private String [] pattern = {"yyyy-MM-dd HH:mm:ss","yyyy年MM月dd日"};
    @Override
    public Date convert(String s) {
        System.out.println("convert");
        for (int i=0;i<pattern.length;i++){
            try {
                return  new SimpleDateFormat(pattern[i]).parse(s);
            } catch (ParseException e) {
                continue;
            }
        }
        return null;
    }
}
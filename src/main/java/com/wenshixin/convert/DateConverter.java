package com.wenshixin.convert;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: wzw
 * Date: 2018/9/19
 * Time: 22:33
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class DateConverter implements Converter<String, Date> {
    // 定义日期格式
    private String dataPattern = "yyyy-MM-dd HH:mm:ss";

    @Override
    public Date convert(String s) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dataPattern);
        try {
            return simpleDateFormat.parse(s);
        } catch (ParseException e) {
            throw new IllegalArgumentException("无效的日期格式，请使用" + dataPattern + "格式的日期");
        }
    }
}

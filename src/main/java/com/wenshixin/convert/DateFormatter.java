package com.wenshixin.convert;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: wzw
 * Date: 2018/9/19
 * Time: 22:40
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class DateFormatter implements Formatter<Date> {
    // 定义日期格式
    private String dataPattern = "yyyy-MM-dd HH:mm:ss";

    @Override
    public Date parse(String s, Locale locale) throws ParseException {
        return new SimpleDateFormat(dataPattern).parse(s);
    }

    @Override
    public String print(Date date, Locale locale) {
        return new SimpleDateFormat().format(date);
    }
}

package com.java.homeworkmanagement.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description 时间转换工具类
 * @Author
 * @Date
 */
public class DateUtil {
    public static String dateToStr(Date dateDate, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(dateDate);
    }

}

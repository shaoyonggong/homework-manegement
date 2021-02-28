package com.java.homeworkmanagement.utils;

/**
 * @Description 字符util
 * @Author
 * @Date
 */
public class StringUtil {

    /**
     * 拼接字符
     *
     * @param values values
     * @return String
     */
    public static String stringJoint(String... values) {
        StringBuffer buffer = new StringBuffer();
        if (values.length == 0) {
            return "";
        }
        for (String value : values) {
            if (jodd.util.StringUtil.isNotBlank(value))
                buffer.append(value);
        }
        return buffer.toString();
    }
}

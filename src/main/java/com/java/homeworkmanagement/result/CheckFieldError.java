package com.java.homeworkmanagement.result;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Description 检查字段属性错误
 * @Author
 * @Date
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CheckFieldError {

    public CheckFieldError() {
    }

    public CheckFieldError(String fieldName, String errorMessage, Object errorValue) {
        this.fieldName = fieldName;
        this.errorMessage = errorMessage;
        this.errorValue = errorValue;
    }

    public CheckFieldError(String fieldName, String errorMessage, Object errorValue, Integer index) {
        this.fieldName = fieldName;
        this.errorMessage = errorMessage;
        this.errorValue = errorValue;
        this.index = index;
    }

    /**
     * 下标
     */
    private Integer index;

    /**
     * 对象名
     */
    private String fieldName;

    /**
     * 错误信息
     */
    private String errorMessage;

    /**
     * 验证不通过的原始值
     */
    private Object errorValue = null;

    private List<CheckErrorInfo> checkErrorInfoList;
}


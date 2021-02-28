package com.java.homeworkmanagement.result;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Description 检查级别的错误
 * @Author
 * @Date
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CheckErrorInfo {

    public CheckErrorInfo() {
    }

    public CheckErrorInfo(String code, String message) {
        super();
        this.errorCode = code;
        this.message = message;
    }

    public CheckErrorInfo(String code, String message, String errorStack) {
        this.errorCode = code;
        this.errorStack = errorStack;
        this.message = message;
    }

    public CheckErrorInfo(String code, String message, List<String> messageStacks) {
        super();
        this.errorCode = code;
        this.message = message;
        if (messageStacks != null) {
            this.messageStacks = messageStacks;
        }
        this.messageStacks.add(0, message);
    }

    /**
     * 异常编码
     */
    private String errorCode;

    /**
     * 未知错误
     */
    private String message = null;

    /**
     * 异常堆栈
     */
    private String errorStack = null;

    /**
     * 跟踪异常信息
     */
    private List<String> messageStacks = null;
}

package com.java.homeworkmanagement.result;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 统一返回对象
 * @Author
 * @Dae
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RestResult<D> implements Serializable {

    public RestResult() {
    }

    public RestResult(D body, int totalCount) {
        this.body = body;
        this.totalCount = totalCount;
    }

    public void merge(RestResult<D> restResult) {
        this.status = restResult.status;
        this.code = restResult.code;
        this.body = restResult.body;
        this.checkFieldErrorList.addAll(restResult.checkFieldErrorList);
        this.exception = restResult.exception;
        this.totalCount = restResult.totalCount;
    }

    /**
     * 状态码
     */
    private Integer code = StatusEnum.SUCCESS_CODE.getCode();

    /**
     * 状态
     */
    private String status = StatusEnum.SUCCESS_CODE.getDescription();

    /**
     * 提示信息
     */
    private String message = "";

    /**
     * 异常
     */
    private CheckErrorInfo exception = null;

    /**
     * 主体
     */
    private D body;

    /**
     * 验证错误
     */
    private List<CheckFieldError> checkFieldErrorList = new ArrayList<>();

    /**
     * 总数
     */
    private long totalCount;

    /**
     * 原始参数
     */
    private Object originalParam;

    /**
     * 标记服务拒绝处理(由于验证失败等原因.)
     */
    public void markSuccess() {
        this.code = StatusEnum.SUCCESS_CODE.getCode();
        this.status = StatusEnum.SUCCESS_CODE.getDescription();
    }

    /**
     * 标记服务拒绝处理(由于验证失败等原因.)
     */
    public void markRefused() {
        this.code = StatusEnum.REFUSE_CODE.getCode();
        this.status = StatusEnum.REFUSE_CODE.getDescription();
    }

    /**
     * 标记服务的处理结果发生了异常.
     */
    public void markFailed() {
        this.code = StatusEnum.FAIL_CODE.getCode();
        this.status = StatusEnum.FAIL_CODE.getDescription();

    }

}

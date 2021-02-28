package com.java.homeworkmanagement.controller;

import com.java.homeworkmanagement.service.IOperationLogService;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {

    public enum OperationResultEnum {
        SUCCESS,
        REFUSED,
        FAILED
    }

    @Autowired
    protected IOperationLogService operationLogService;

    public void addSuccessLog(String account, String operationType, String describe) {
        addLog(account, operationType, describe, OperationResultEnum.SUCCESS.toString());
    }

    public void addFailedLog(String account, String operationType, String describe) {
        addLog(account, operationType, describe, OperationResultEnum.FAILED.toString());
    }

    public void addRefusedLog(String account, String operationType, String describe) {
        addLog(account, operationType, describe, OperationResultEnum.REFUSED.toString());
    }

    private void addLog(String account, String operationType, String describe, String status) {
        operationLogService.addLog(account, operationType, describe, status);
    }

}

package com.java.homeworkmanagement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.java.homeworkmanagement.dto.OperationLogDTO;
import com.java.homeworkmanagement.pojo.OperationLogPO;

/**
 * <p>
 * 服务类
 * </p>
 */
public interface IOperationLogService extends IService<OperationLogPO> {

    void addLog(String account, String operationType, String describe, String status);

    IPage<OperationLogPO> queryByCondition(OperationLogDTO dto);
}

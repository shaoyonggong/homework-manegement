package com.java.homeworkmanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.homeworkmanagement.dao.ManagementLogMapper;
import com.java.homeworkmanagement.dto.OperationLogDTO;
import com.java.homeworkmanagement.pojo.OperationLogPO;
import com.java.homeworkmanagement.service.IOperationLogService;
import jodd.util.StringUtil;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 */
@Primary
@Service
public class OperationLogServiceImpl extends ServiceImpl<ManagementLogMapper, OperationLogPO> implements IOperationLogService {

    @Override
    public void addLog(String account, String operationType, String describe, String status) {
        baseMapper.insert(new OperationLogPO()
                .setOperationType(operationType)
                .setOperationDescribe(describe)
                .setOperationResult(status));
    }

    @Override
    public IPage<OperationLogPO> queryByCondition(OperationLogDTO dto) {
        QueryWrapper<OperationLogPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(StringUtil.isNotBlank(dto.getAccount()), "account", dto.getAccount());
        queryWrapper.eq(StringUtil.isNotBlank(dto.getOperationType()), "operation_type", dto.getOperationType());
        queryWrapper.eq(StringUtil.isNotBlank(dto.getOperationResult()), "operation_result", dto.getOperationResult());
        queryWrapper.eq(StringUtil.isNotBlank(dto.getOperationDescribe()), "operation_describe", dto.getOperationDescribe());
        queryWrapper.between(dto.getOperationTimeStart() != null && dto.getOperationTimeEnd() != null, "operation_time", dto.getOperationTimeStart(), dto.getOperationTimeEnd());
        String searchKey = dto.getSearchKey();
        if (StringUtil.isNotBlank(searchKey)) {
            queryWrapper.and(wrapper -> wrapper.like("operation_type", searchKey)
                    .or().like("operation_result", searchKey)
                    .or().like("operation_describe", searchKey));
        }
        return baseMapper.selectPage(new Page<>(dto.getPageNum(), dto.getPageSize()), queryWrapper);
    }
}

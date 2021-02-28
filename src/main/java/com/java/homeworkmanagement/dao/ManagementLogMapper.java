package com.java.homeworkmanagement.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.java.homeworkmanagement.pojo.OperationLogPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 */
@Mapper
public interface ManagementLogMapper extends BaseMapper<OperationLogPO> {

}
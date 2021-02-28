package com.java.homeworkmanagement.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "OperationLog对象", description = "")
@TableName("operation_log")
public class OperationLogDTO extends PageDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "操作人员")
    private String account;

    @ApiModelProperty(value = "操作人员")
    private String accountName;

    @ApiModelProperty(value = "操作类型")
    private String operationType;

    @ApiModelProperty(value = "操作结果")
    private String operationResult;

    @ApiModelProperty(value = "日志描述")
    private String operationDescribe;

    @ApiModelProperty(value = "日志开始时间")
    private LocalDateTime operationTimeStart;

    @ApiModelProperty(value = "日志结束描述")
    private LocalDateTime operationTimeEnd;

    @ApiModelProperty(value = "查询关键字")
    private String searchKey;

}

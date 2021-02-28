package com.java.homeworkmanagement.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.java.homeworkmanagement.dto.OperationLogDTO;
import com.java.homeworkmanagement.utils.CoverTo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
public class OperationLogPO implements Serializable, CoverTo<OperationLogDTO> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "操作人员")
    private String account;

    @ApiModelProperty(value = "操作类型")
    private String operationType;

    @ApiModelProperty(value = "操作结果")
    private String operationResult;

    @ApiModelProperty(value = "日志描述")
    private String operationDescribe;

    @Override
    public OperationLogDTO coverTo() {
        return new OperationLogDTO()
                .setId(this.id)
                .setAccount(this.account)
                .setAccountName("")
                .setOperationType(this.operationType)
                .setOperationResult(this.operationResult)
                .setOperationDescribe(this.operationDescribe)
                .setSearchKey("");
    }
}

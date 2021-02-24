package com.java.homeworkmanagement.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
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
 *
 * @author shaoyonggong
 * @since 2021-02-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "ManagementLog对象", description = "")
@TableName("management_log")
public class ManagementLogPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "操作类型")
    private String account;

    @ApiModelProperty(value = "操作状态")
    private String status;

    @ApiModelProperty(value = "日志描述")
    private String logDescribe;

}

package com.java.homeworkmanagement.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 分页dto
 */
@Data
public class PageDTO {
    @ApiModelProperty(value = "页码")
    private int pageNum;

    @ApiModelProperty(value = "每页条数")
    private int pageSize;
}

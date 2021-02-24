package com.java.homeworkmanagement.pojo;

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
 *
 * @author shaoyonggong
 * @since 2021-02-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "ChatContent对象", description = "")
@TableName("chat_content")
public class ChatContentPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "聊天内容id")
    private Integer id;

    @ApiModelProperty(value = "教师id")
    private Integer teacherId;

    @ApiModelProperty(value = "学生id")
    private Integer studentId;

    @ApiModelProperty(value = "聊天内容")
    private String chatContent;

    @ApiModelProperty(value = "时间")
    private LocalDateTime createTime;

}

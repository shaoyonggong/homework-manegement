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
@ApiModel(value = "TaskInfo对象", description = "")
@TableName("task_info")
public class TaskInfoPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "作业表id")
    private Integer id;

    @ApiModelProperty(value = "课程")
    private String subject;

    @ApiModelProperty(value = "教师id")
    private Integer teacherId;

    @ApiModelProperty(value = "年级")
    private String grade;

    @ApiModelProperty(value = "班级")
    private String studentClass;

    @ApiModelProperty(value = "作业标题")
    private String taskTitle;

    @ApiModelProperty(value = "单选作业")
    private String singleChoiceTask;

    @ApiModelProperty(value = "单选作业答案")
    private String singleChoiceAnswer;

    @ApiModelProperty(value = "多选作业")
    private String multipleChoiceTask;

    @ApiModelProperty(value = "多选作业答案")
    private String multipleChoiceAnswer;

    @ApiModelProperty(value = "填空作业")
    private String blanksTask;

    @ApiModelProperty(value = "填空作业答案")
    private String blanksTaskAnswer;

    @ApiModelProperty(value = "复合作业内容")
    private String taskContent;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "布置时间")
    private LocalDateTime assignTime;

    @ApiModelProperty(value = "截止时间")
    private String deadlineTime;

}

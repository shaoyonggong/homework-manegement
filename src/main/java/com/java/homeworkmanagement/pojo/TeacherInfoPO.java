package com.java.homeworkmanagement.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value = "TeacherInfo对象", description = "")
@TableName("teacher_info")
public class TeacherInfoPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "教师id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "账号")
    private Integer account;

    @ApiModelProperty(value = "教师姓名")
    private String teacherName;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "性别")
    private String gender;

    @ApiModelProperty(value = "授课科目")
    private String teachingSubject;

    @ApiModelProperty(value = "授课班级")
    private String teachingClass;

    @ApiModelProperty(value = "注册时间")
    private LocalDateTime registerTime;

}

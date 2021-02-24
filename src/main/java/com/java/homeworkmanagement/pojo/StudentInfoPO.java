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
@ApiModel(value = "StudentInfo对象", description = "")
@TableName("student_info")
public class StudentInfoPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "学生id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "账号")
    private Integer account;

    @ApiModelProperty(value = "学生姓名")
    private String studentName;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "性别")
    private String gender;

    @ApiModelProperty(value = "班级")
    private String studentClass;

    @ApiModelProperty(value = "年级")
    private String grade;

    @ApiModelProperty(value = "注册时间")
    private LocalDateTime registerTime;

}

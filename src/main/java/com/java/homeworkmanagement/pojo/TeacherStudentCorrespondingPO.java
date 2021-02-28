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

/**
 * <p>
 *
 * </p>
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "TeacherStudentCorresponding对象", description = "")
@TableName("teacher_student_corresponding")
public class TeacherStudentCorrespondingPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "教师学生对应表")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "教师id")
    private Integer teacherId;

    @ApiModelProperty(value = "年级")
    private String grade;

    @ApiModelProperty(value = "班级")
    private String studentClass;

    @ApiModelProperty(value = "学生id")
    private Integer studentId;

}

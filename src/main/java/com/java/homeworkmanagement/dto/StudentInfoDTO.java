package com.java.homeworkmanagement.dto;

import com.java.homeworkmanagement.pojo.StudentInfoPO;
import com.java.homeworkmanagement.utils.CoverTo;
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
@ApiModel(value = "StudentInfo对象", description = "")
public class StudentInfoDTO implements Serializable, CoverTo<StudentInfoPO> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "学生id")
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

    @Override
    public StudentInfoPO coverTo() {
        return new StudentInfoPO()
                .setId(this.getId())
                .setAccount(this.getAccount())
                .setStudentName(this.getStudentName())
                .setAge(this.getAge())
                .setGender(this.getGender())
                .setStudentClass(this.getStudentClass())
                .setGrade(this.getGrade())
                .setRegisterTime(this.getRegisterTime());
    }
}

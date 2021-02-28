package com.java.homeworkmanagement.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.java.homeworkmanagement.dto.StudentTaskAnswerDTO;
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
@ApiModel(value = "StudentTaskAnswer对象", description = "")
@TableName("student_task_answer")
public class StudentTaskAnswerPO implements Serializable, CoverTo<StudentTaskAnswerDTO> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "作业表id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "课程")
    private String subject;

    @ApiModelProperty(value = "作业id")
    private Integer taskId;

    @ApiModelProperty(value = "教师id")
    private Integer studentId;

    @ApiModelProperty(value = "作业标题")
    private String taskTitle;

    @ApiModelProperty(value = "单选作业")
    private String singleChoiceTask;

    @ApiModelProperty(value = "学生单选作业答案")
    private String singleChoiceAnswer;

    @ApiModelProperty(value = "多选作业")
    private String multipleChoiceTask;

    @ApiModelProperty(value = "学生多选作业答案")
    private String multipleChoiceAnswer;

    @ApiModelProperty(value = "判断题作业")
    private String judgmentTask;

    @ApiModelProperty(value = "判断题答案")
    private String judgmentAnswer;

    @ApiModelProperty(value = "填空作业")
    private String blanksTask;

    @ApiModelProperty(value = "学生填空作业答案")
    private String blanksTaskAnswer;

    @ApiModelProperty(value = "复合作业内容")
    private String taskContent;

    @ApiModelProperty(value = "成绩")
    private Double score;

    @ApiModelProperty(value = "提交时间")
    private LocalDateTime submitTime;

    @Override
    public StudentTaskAnswerDTO coverTo() {
        return new StudentTaskAnswerDTO()
                .setId(this.id)
                .setSubject(this.subject)
                .setTaskId(this.taskId)
                .setStudentId(this.studentId)
                .setTaskTitle(this.taskTitle)
                .setSingleChoiceTask(this.singleChoiceTask)
                .setSingleChoiceAnswer(this.singleChoiceAnswer)
                .setMultipleChoiceTask(this.multipleChoiceTask)
                .setMultipleChoiceAnswer(this.multipleChoiceAnswer)
                .setJudgmentTask(this.judgmentTask)
                .setJudgmentAnswer(this.judgmentAnswer)
                .setBlanksTask(this.blanksTask)
                .setBlanksTaskAnswer(this.blanksTaskAnswer)
                .setTaskContent(this.taskContent)
                .setScore(this.score)
                .setSubmitTime(this.submitTime);
    }
}

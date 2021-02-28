package com.java.homeworkmanagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.java.homeworkmanagement.dto.StudentTaskAnswerDTO;
import com.java.homeworkmanagement.pojo.StudentTaskAnswerPO;

/**
 * <p>
 * 服务类
 * </p>
 */
public interface IStudentTaskAnswerService extends IService<StudentTaskAnswerPO> {

    StudentTaskAnswerDTO queryById(int studentId);

    void insert(StudentTaskAnswerDTO dto);

    boolean judgeAnswerExist(StudentTaskAnswerDTO dto);
}

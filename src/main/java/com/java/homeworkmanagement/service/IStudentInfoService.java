package com.java.homeworkmanagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.java.homeworkmanagement.dto.StudentInfoDTO;
import com.java.homeworkmanagement.pojo.StudentInfoPO;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 */
public interface IStudentInfoService extends IService<StudentInfoPO> {

    List<StudentInfoDTO> queryList();

    StudentInfoDTO queryById(int studentId);

    void update(StudentInfoDTO dto);

    void delete(String studentIds);

    void insert(StudentInfoDTO dto);

    int selectMaxStudentId();

    boolean judgeStudentExist(StudentInfoDTO dto);
}

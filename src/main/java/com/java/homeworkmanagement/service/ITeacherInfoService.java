package com.java.homeworkmanagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.java.homeworkmanagement.dto.TeacherInfoDTO;
import com.java.homeworkmanagement.pojo.TeacherInfoPO;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 */
public interface ITeacherInfoService extends IService<TeacherInfoPO> {

    List<TeacherInfoDTO> queryList();

    TeacherInfoDTO queryById(int teacherId);

    void update(TeacherInfoDTO dto);

    void delete(int teacherId);

    void insert(TeacherInfoDTO dto);

    Integer selectMaxTeacherId();

    boolean judgeTeacherExist(TeacherInfoDTO dto);
}

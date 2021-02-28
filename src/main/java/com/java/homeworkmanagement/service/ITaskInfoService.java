package com.java.homeworkmanagement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.java.homeworkmanagement.dto.TaskInfoDTO;
import com.java.homeworkmanagement.dto.TaskInfoSearchDTO;
import com.java.homeworkmanagement.pojo.TaskInfoPO;

/**
 * <p>
 * 服务类
 * </p>
 */
public interface ITaskInfoService extends IService<TaskInfoPO> {

    IPage<TaskInfoPO> queryTaskByCondition(TaskInfoSearchDTO dto);

    void update(TaskInfoDTO dto);

    TaskInfoDTO queryById(int taskId);

    void delete(String taskIds);

    void insert(TaskInfoDTO dto);

    boolean judgeTaskExist(TaskInfoDTO dto);
}

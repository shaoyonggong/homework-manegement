package com.java.homeworkmanagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.homeworkmanagement.mapper.TaskInfoMapper;
import com.java.homeworkmanagement.pojo.TaskInfoPO;
import com.java.homeworkmanagement.service.ITaskInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shaoyonggong
 * @since 2021-02-24
 */
@Service
public class TaskInfoServiceImpl extends ServiceImpl<TaskInfoMapper, TaskInfoPO> implements ITaskInfoService {

}

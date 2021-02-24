package com.java.homeworkmanagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.java.homeworkmanagement.pojo.StudentInfoPO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shaoyonggong
 * @since 2021-02-24
 */
public interface IStudentInfoService extends IService<StudentInfoPO> {

    List<StudentInfoPO> queryList();
}

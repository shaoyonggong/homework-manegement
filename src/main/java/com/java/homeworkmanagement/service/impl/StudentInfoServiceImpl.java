package com.java.homeworkmanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.homeworkmanagement.mapper.StudentInfoMapper;
import com.java.homeworkmanagement.pojo.StudentInfoPO;
import com.java.homeworkmanagement.service.IStudentInfoService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author shaoyonggong
 * @since 2021-02-24
 */
@Primary
@Service
public class StudentInfoServiceImpl extends ServiceImpl<StudentInfoMapper, StudentInfoPO> implements IStudentInfoService {

    @Override
    public List<StudentInfoPO> queryList() {
        return baseMapper.selectList(new QueryWrapper<>());
    }
}

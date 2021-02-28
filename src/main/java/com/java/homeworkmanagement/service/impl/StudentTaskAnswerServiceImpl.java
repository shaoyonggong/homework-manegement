package com.java.homeworkmanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.homeworkmanagement.dao.StudentTaskAnswerMapper;
import com.java.homeworkmanagement.dto.StudentTaskAnswerDTO;
import com.java.homeworkmanagement.pojo.StudentTaskAnswerPO;
import com.java.homeworkmanagement.service.IStudentTaskAnswerService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 */
@Service
public class StudentTaskAnswerServiceImpl extends ServiceImpl<StudentTaskAnswerMapper, StudentTaskAnswerPO> implements IStudentTaskAnswerService {

    @Override
    public StudentTaskAnswerDTO queryById(int studentId) {
        return baseMapper.selectById(studentId).coverTo();
    }

    @Override
    public void insert(StudentTaskAnswerDTO dto) {
        baseMapper.insert(dto.coverTo());
    }

    @Override
    public boolean judgeAnswerExist(StudentTaskAnswerDTO dto) {
        QueryWrapper<StudentTaskAnswerPO> queryWrapper = new QueryWrapper<StudentTaskAnswerPO>()
                .eq("subject", dto.getSubject())
                .eq("task_id", dto.getTaskId())
                .eq("student_id", dto.getStudentId());
        Integer count = baseMapper.selectCount(queryWrapper);
        return count > 0 ? Boolean.TRUE : Boolean.FALSE;
    }
}

package com.java.homeworkmanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.homeworkmanagement.dao.StudentInfoMapper;
import com.java.homeworkmanagement.dto.StudentInfoDTO;
import com.java.homeworkmanagement.pojo.StudentInfoPO;
import com.java.homeworkmanagement.service.IStudentInfoService;
import com.java.homeworkmanagement.utils.Constant;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 */
@Primary
@Service
public class StudentInfoServiceImpl extends ServiceImpl<StudentInfoMapper, StudentInfoPO> implements IStudentInfoService {

    @Override
    public List<StudentInfoDTO> queryList() {
        return baseMapper.selectList(new QueryWrapper<>()).stream().map(StudentInfoPO::coverTo).collect(Collectors.toList());
    }

    @Override
    public StudentInfoDTO queryById(int studentId) {
        return baseMapper.selectById(studentId).coverTo();
    }

    @Override
    public void update(StudentInfoDTO dto) {
        baseMapper.updateById(dto.coverTo());
    }

    @Override
    public void delete(String studentIds) {
        baseMapper.deleteBatchIds(Arrays.asList(studentIds.split(Constant.SYMBOL_COMMA).clone()));
    }

    @Override
    public void insert(StudentInfoDTO dto) {
        baseMapper.insert(dto.coverTo());
    }

    @Override
    @Transactional
    public int selectMaxStudentId() {
        Integer maxStudentId = baseMapper.selectMaxStudentId();
        return maxStudentId == null ? 100000 : maxStudentId;
    }

    @Override
    public boolean judgeStudentExist(StudentInfoDTO dto) {
        QueryWrapper<StudentInfoPO> queryWrapper = new QueryWrapper<StudentInfoPO>()
                .eq("student_name", dto.getStudentName())
                .eq("grade", dto.getGrade())
                .eq("student_class", dto.getStudentClass());
        Integer count = baseMapper.selectCount(queryWrapper);
        return count > 0 ? Boolean.TRUE : Boolean.FALSE;
    }

}

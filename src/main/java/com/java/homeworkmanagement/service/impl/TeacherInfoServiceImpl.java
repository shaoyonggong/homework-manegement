package com.java.homeworkmanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.homeworkmanagement.dao.TeacherInfoMapper;
import com.java.homeworkmanagement.dto.TeacherInfoDTO;
import com.java.homeworkmanagement.pojo.TeacherInfoPO;
import com.java.homeworkmanagement.service.ITeacherInfoService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 */
@Primary
@Service
public class TeacherInfoServiceImpl extends ServiceImpl<TeacherInfoMapper, TeacherInfoPO> implements ITeacherInfoService {

    @Override
    public List<TeacherInfoDTO> queryList() {
        return baseMapper.selectList(new QueryWrapper<>()).stream().map(TeacherInfoPO::coverTo).collect(Collectors.toList());
    }

    @Override
    public TeacherInfoDTO queryById(int teacherId) {
        return baseMapper.selectById(teacherId).coverTo();
    }

    @Override
    public void update(TeacherInfoDTO dto) {
        baseMapper.updateById(dto.coverTo());
    }

    @Override
    public void delete(int teacherId) {
        baseMapper.deleteById(teacherId);
    }

    @Override
    public void insert(TeacherInfoDTO dto) {
        baseMapper.insert(dto.coverTo());
    }

    @Override
    public Integer selectMaxTeacherId() {
        Integer maxTeacherId = baseMapper.selectMaxTeacherId();
        return maxTeacherId == null ? 200000 : maxTeacherId;
    }

    @Override
    public boolean judgeTeacherExist(TeacherInfoDTO dto) {
        QueryWrapper<TeacherInfoPO> queryWrapper = new QueryWrapper<TeacherInfoPO>()
                .eq("teaching_subject", dto.getTeachingSubject())
                .eq("teaching_class", dto.getTeachingClass())
                .eq("account", dto.getAccount());
        Integer count = baseMapper.selectCount(queryWrapper);
        return count > 0 ? Boolean.TRUE : Boolean.FALSE;
    }
}

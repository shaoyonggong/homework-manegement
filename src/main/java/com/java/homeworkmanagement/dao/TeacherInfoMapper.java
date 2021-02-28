package com.java.homeworkmanagement.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.java.homeworkmanagement.pojo.TeacherInfoPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 */
@Mapper
public interface TeacherInfoMapper extends BaseMapper<TeacherInfoPO> {

    Integer selectMaxTeacherId();
}

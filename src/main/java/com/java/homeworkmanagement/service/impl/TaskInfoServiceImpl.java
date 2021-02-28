package com.java.homeworkmanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.homeworkmanagement.dao.TaskInfoMapper;
import com.java.homeworkmanagement.dto.TaskInfoDTO;
import com.java.homeworkmanagement.dto.TaskInfoSearchDTO;
import com.java.homeworkmanagement.pojo.TaskInfoPO;
import com.java.homeworkmanagement.service.ITaskInfoService;
import com.java.homeworkmanagement.utils.Constant;
import jodd.util.StringUtil;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * <p>
 * 服务实现类
 * </p>
 */
@Service
public class TaskInfoServiceImpl extends ServiceImpl<TaskInfoMapper, TaskInfoPO> implements ITaskInfoService {

    @Override
    public IPage<TaskInfoPO> queryTaskByCondition(TaskInfoSearchDTO dto) {
        QueryWrapper<TaskInfoPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(dto.getId() != null, "id", dto.getId());
        queryWrapper.eq(StringUtil.isNotBlank(dto.getSubject()), "subject", dto.getSubject());
        queryWrapper.eq(dto.getTeacherId() != null, "teacher_id", dto.getTeacherId());
        queryWrapper.eq(StringUtil.isNotBlank(dto.getGrade()), "grade", dto.getGrade());
        queryWrapper.eq(StringUtil.isNotBlank(dto.getStudentClass()), "student_class", dto.getStudentClass());
        queryWrapper.like(StringUtil.isNotBlank(dto.getTaskTitle()), "task_title", dto.getTaskTitle());
        queryWrapper.like(StringUtil.isNotBlank(dto.getSingleChoiceTask()), "single_choice_task", dto.getSingleChoiceTask());
        queryWrapper.like(StringUtil.isNotBlank(dto.getSingleChoiceAnswer()), "single_choice_answer", dto.getSingleChoiceAnswer());
        queryWrapper.like(StringUtil.isNotBlank(dto.getMultipleChoiceTask()), "multiple_choice_task", dto.getMultipleChoiceTask());
        queryWrapper.like(StringUtil.isNotBlank(dto.getMultipleChoiceAnswer()), "multiple_choice_answer", dto.getMultipleChoiceAnswer());
        queryWrapper.like(StringUtil.isNotBlank(dto.getJudgmentTask()), "judgment_task", dto.getJudgmentTask());
        queryWrapper.like(StringUtil.isNotBlank(dto.getJudgmentAnswer()), "judgement_answer", dto.getJudgmentAnswer());
        queryWrapper.like(StringUtil.isNotBlank(dto.getBlanksTask()), "blanks_task", dto.getBlanksTask());
        queryWrapper.like(StringUtil.isNotBlank(dto.getBlanksTaskAnswer()), "blanks_task_answer", dto.getBlanksTaskAnswer());
        queryWrapper.like(StringUtil.isNotBlank(dto.getTaskContent()), "task_content", dto.getTaskContent());
        queryWrapper.between(dto.getAssignTimeStart() != null && dto.getAssignTimeEnd() != null,
                "assign_time", dto.getAssignTimeStart(), dto.getAssignTimeEnd());
        queryWrapper.gt(StringUtil.isNotBlank(dto.getDeadlineTime()), "deadline_time", dto.getDeadlineTime());
        return baseMapper.selectPage(new Page<>(dto.getPageNum(), dto.getPageSize()), queryWrapper);
    }

    @Override
    public void update(TaskInfoDTO dto) {
        baseMapper.updateById(dto.coverTo());
    }

    @Override
    public TaskInfoDTO queryById(int taskId) {
        return baseMapper.selectById(taskId).coverTo();
    }

    @Override
    public void delete(String taskIds) {
        baseMapper.deleteBatchIds(Arrays.asList(taskIds.split(Constant.SYMBOL_COMMA).clone()));
    }

    @Override
    public void insert(TaskInfoDTO dto) {
        baseMapper.insert(dto.coverTo());
    }

    @Override
    public boolean judgeTaskExist(TaskInfoDTO dto) {
        QueryWrapper<TaskInfoPO> queryWrapper = new QueryWrapper<TaskInfoPO>()
                .eq("subject", dto.getSubject())
                .eq("grade", dto.getGrade())
                .eq("student_class", dto.getStudentClass())
                .eq("task_title", dto.getTaskTitle());
        Integer count = baseMapper.selectCount(queryWrapper);
        return count > 0 ? Boolean.TRUE : Boolean.FALSE;
    }

}

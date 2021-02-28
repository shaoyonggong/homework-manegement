package com.java.homeworkmanagement.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.java.homeworkmanagement.dto.TaskInfoDTO;
import com.java.homeworkmanagement.dto.TaskInfoSearchDTO;
import com.java.homeworkmanagement.pojo.TaskInfoPO;
import com.java.homeworkmanagement.result.RestResult;
import com.java.homeworkmanagement.service.ITaskInfoService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 */
@RestController
@RequestMapping("/taskInfo")
@Slf4j
@Api(tags = {"作业信息相关接口"})
public class TaskInfoController extends BaseController {

    private final static AtomicInteger atomicNum = new AtomicInteger(0);

    @Autowired
    ITaskInfoService taskInfoService;

    @PostMapping("searchByCondition")
    public RestResult<List<TaskInfoDTO>> queryTaskByCondition(@RequestBody TaskInfoSearchDTO dto) {
        RestResult<List<TaskInfoDTO>> result = new RestResult<>();
        try {
            IPage<TaskInfoPO> pageResult = taskInfoService.queryTaskByCondition(dto);
            result.setBody(pageResult.getRecords().stream().map(TaskInfoPO::coverTo).collect(Collectors.toList()));
            result.setTotalCount(pageResult.getTotal());
            result.markSuccess();
            addSuccessLog("admin", "taskInfo searchByCondition", "taskInfo searchByCondition success");
            log.info("taskInfo searchByCondition success");
        } catch (Exception e) {
            result.markFailed();
            addFailedLog("1111", "taskInfo searchByCondition", "taskInfo searchByCondition failed");
            log.error("taskInfo searchByCondition error", e);
        }
        return result;
    }

    @PostMapping("update")
    public RestResult update(@RequestParam TaskInfoDTO dto) {
        RestResult result = new RestResult();
        try {
            taskInfoService.update(dto);
            result.markSuccess();
            addSuccessLog("admin", "update task", "update task success");
            log.info("taskInfo.update success");
        } catch (Exception e) {
            result.markFailed();
            addFailedLog("admin", "update task", "update task failed");
            log.error("taskInfo.update failed", e);
        }
        return result;
    }

    @PostMapping("queryById")
    public RestResult<TaskInfoDTO> queryById(@RequestParam int taskId) {
        RestResult<TaskInfoDTO> result = new RestResult<>();
        try {
            result.setBody(taskInfoService.queryById(taskId));
            result.setTotalCount(1);
            result.markSuccess();
            addSuccessLog("1111", "query task", "query task success");
            log.info("taskInfo.queryById success");
        } catch (Exception e) {
            result.markFailed();
            addFailedLog("1111", "query task", "query task failed");
            log.error("taskInfo.queryById failed", e);
        }
        return result;
    }

    @PostMapping("delete")
    public RestResult delete(@RequestParam String taskIds) {
        RestResult result = new RestResult();
        try {
            taskInfoService.delete(taskIds);
            result.markSuccess();
            addSuccessLog("1111", "delete task", "delete task success");
            log.info("taskInfo.delete success");
        } catch (Exception e) {
            result.markFailed();
            addFailedLog("1111", "delete task", "delete task failed");
            log.error("taskInfo.update failed", e);
        }
        return result;
    }

    @PostMapping("insert")
    public RestResult insert(@RequestParam TaskInfoDTO dto) {
        RestResult result = new RestResult();
        try {
            if (taskInfoService.judgeTaskExist(dto)) {
                result.markRefused();
                result.setMessage("当前课程[" + dto.getSubject() + "]年级[" + dto.getGrade() + "]班级[" + dto.getStudentClass()
                        + "]的作业[" + dto.getTaskTitle() + "]已存在！");
                addRefusedLog("1111", "insert task", "insert task refused");
                return result;
            }
            dto.setTaskId(getTaskId());
            taskInfoService.insert(dto);
            result.markSuccess();
            addSuccessLog("1111", "insert task", "add task success");
            log.info("teacherInfo.insert success");
        } catch (Exception e) {
            result.markFailed();
            addFailedLog("1111", "insert task", "add task failed");
            log.error("teacherInfo.insert failed", e);
        }
        return result;
    }

    private String getTaskId() {
        return String.format("TASK%05d", atomicNum.incrementAndGet());
    }

}
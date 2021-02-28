package com.java.homeworkmanagement.controller;

import com.java.homeworkmanagement.dto.TeacherInfoDTO;
import com.java.homeworkmanagement.result.RestResult;
import com.java.homeworkmanagement.service.ITeacherInfoService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 */
@RestController
@RequestMapping("/teacherInfo")
@Api(tags = {"教师信息相关接口"})
@Slf4j
public class TeacherInfoController extends BaseController {

    @Autowired
    ITeacherInfoService teacherInfoService;

    @GetMapping("queryAll")
    public RestResult<List<TeacherInfoDTO>> queryAllStudent() {
        RestResult<List<TeacherInfoDTO>> result = new RestResult<>();
        try {
            List<TeacherInfoDTO> list = teacherInfoService.queryList();
            result.setBody(list);
            result.setTotalCount(list.size());
            result.markSuccess();
            addSuccessLog("admin", "query teacher", "add teacher success");
            log.info("teacherInfo.queryAll success");
        } catch (Exception e) {
            result.markFailed();
            addFailedLog("admin", "query teacher", "add teacher failed");
            log.error("teacherInfo.queryAll failed", e);
        }

        return result;
    }

    @PostMapping("queryById")
    public RestResult<TeacherInfoDTO> queryById(@RequestParam int teacherId) {
        RestResult<TeacherInfoDTO> result = new RestResult<>();
        try {
            result.setBody(teacherInfoService.queryById(teacherId));
            result.setTotalCount(1);
            result.markSuccess();
            addSuccessLog("admin", "query teacher", "add teacher success");
            log.info("teacherInfo.queryById success");
        } catch (Exception e) {
            result.markFailed();
            addFailedLog("admin", "query teacher", "add teacher failed");
            log.error("teacherInfo.queryById failed", e);
        }
        return result;
    }

    @PostMapping("update")
    public RestResult update(@RequestParam TeacherInfoDTO dto) {
        RestResult result = new RestResult();
        try {
            teacherInfoService.update(dto);
            result.markSuccess();
            addSuccessLog("admin", "update teacher", "update teacher success");
            log.info("teacherInfo.update success");
        } catch (Exception e) {
            result.markFailed();
            addFailedLog("admin", "update teacher", "update teacher failed");
            log.error("teacherInfo.update failed", e);
        }
        return result;
    }

    @PostMapping("delete")
    public RestResult delete(@RequestParam int teacherId) {
        RestResult result = new RestResult();
        try {
            teacherInfoService.delete(teacherId);
            result.markSuccess();
            addSuccessLog("admin", "delete teacher", "delete teacher success");
            log.info("teacherInfo.delete success");
        } catch (Exception e) {
            result.markFailed();
            addFailedLog("admin", "delete teacher", "delete teacher failed");
            log.error("teacherInfo.update failed", e);
        }
        return result;
    }

    @PostMapping("insert")
    public RestResult insert(@RequestParam TeacherInfoDTO dto) {
        RestResult result = new RestResult();
        try {
            if (teacherInfoService.judgeTeacherExist(dto)) {
                result.markRefused();
                result.setMessage("当前科目[" + dto.getTeachingSubject() + "]班级[" + dto.getTeachingClass() + "]的教师[" + dto.getTeacherName() + "]已存在！");
                addRefusedLog("1111", "insert teacher", "insert teacher refused");
                return result;
            }
            dto.setAccount(teacherInfoService.selectMaxTeacherId() + 1);
            teacherInfoService.insert(dto);
            result.markSuccess();
            addSuccessLog("admin", "insert teacher", "add teacher success");
            log.info("teacherInfo.insert success");
        } catch (Exception e) {
            result.markFailed();
            addFailedLog("admin", "insert teacher", "add teacher failed");
            log.error("teacherInfo.update failed", e);
        }
        return result;
    }

}


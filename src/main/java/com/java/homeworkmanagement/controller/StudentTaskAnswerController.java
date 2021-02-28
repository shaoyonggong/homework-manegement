package com.java.homeworkmanagement.controller;

import com.java.homeworkmanagement.dto.StudentTaskAnswerDTO;
import com.java.homeworkmanagement.result.RestResult;
import com.java.homeworkmanagement.service.IStudentTaskAnswerService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 */
@RestController
@RequestMapping("/studentTaskAnswer")
@Slf4j
@Api(tags = {"学生作业答案相关接口"})
public class StudentTaskAnswerController extends BaseController {

    @Autowired
    IStudentTaskAnswerService studentTaskAnswerService;

    @PostMapping("queryById")
    public RestResult<StudentTaskAnswerDTO> queryById(@RequestParam int studentId) {
        RestResult<StudentTaskAnswerDTO> result = new RestResult<>();
        try {
            result.setBody(studentTaskAnswerService.queryById(studentId));
            result.setTotalCount(1);
            result.markSuccess();
        } catch (Exception e) {
            result.markFailed();
        }
        return result;
    }

    @PostMapping("submit")
    public RestResult submit(@RequestBody StudentTaskAnswerDTO dto) {
        RestResult result = new RestResult();
        try {
            //判断答案是否已经提交，提交之后拒绝重复提交
            if (studentTaskAnswerService.judgeAnswerExist(dto)) {
                result.markRefused();
                result.setMessage("当前课程[" + dto.getSubject() + "]作业[" + dto.getTaskTitle() + "]已提交，请勿重复提交！");
                addRefusedLog("admin", "submit student answer", "submit student answer refused");
                log.info("submit student answer refused");
                return result;
            }
            studentTaskAnswerService.insert(dto);
            result.markSuccess();
            addSuccessLog("admin", "submit student answer", "submit student answer refused");
            log.info("submit student answer success");
        } catch (Exception e) {
            result.markFailed();
            addFailedLog("admin", "submit student answer", "submit student answer failed");
            log.error("submit student answer failed", e);
        }
        return result;
    }
}


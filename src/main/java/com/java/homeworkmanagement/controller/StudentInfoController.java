package com.java.homeworkmanagement.controller;

import com.alibaba.fastjson.JSONObject;
import com.java.homeworkmanagement.dto.StudentInfoDTO;
import com.java.homeworkmanagement.result.RestResult;
import com.java.homeworkmanagement.service.IStudentInfoService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 */
@RestController
@RequestMapping("/studentInfo")
@Api(tags = {"学生信息相关接口"})
@Slf4j
public class StudentInfoController extends BaseController {

    @Autowired
    IStudentInfoService studentInfoService;

    @GetMapping("queryAll")
    public RestResult<List<StudentInfoDTO>> queryAllStudent(HttpServletRequest request) {
        RestResult<List<StudentInfoDTO>> result = new RestResult<>();
        try {
            List<StudentInfoDTO> list = studentInfoService.queryList();
            result.setBody(list);
            result.setTotalCount(list.size());
            result.markSuccess();
            addSuccessLog("admin", "query student", "add student success");
            log.info("add student success");
        } catch (Exception e) {
            result.markFailed();
            addFailedLog("admin", "query student", "add student failed");
            log.error("add student failed", e);
        }

        return result;
    }

    @PostMapping("queryById")
    public RestResult<StudentInfoDTO> queryById(@RequestParam int studentId) {
        RestResult<StudentInfoDTO> result = new RestResult<>();
        try {
            result.setBody(studentInfoService.queryById(studentId));
            result.setTotalCount(1);
            result.markSuccess();
            addSuccessLog("admin", "student queryById", "student queryById success");
            log.info("student queryById success");
        } catch (Exception e) {
            result.markFailed();
            addFailedLog("admin", "student queryById", "student queryById failed");
            log.info("student queryById failed", e);
        }
        return result;
    }

    @PostMapping("update")
    public RestResult update(@RequestBody StudentInfoDTO dto) {
        RestResult result = new RestResult();
        try {
            log.info("update student info params = {}", JSONObject.toJSONString(dto));
            studentInfoService.update(dto);
            result.markSuccess();
            addSuccessLog("admin", "student update", "student update success");
            log.info("student update success");
        } catch (Exception e) {
            result.markFailed();
            addFailedLog("admin", "student update", "student update failed");
            log.info("student update failed", e);
        }
        return result;
    }

    @PostMapping("delete")
    public RestResult delete(@RequestParam String studentIds) {
        RestResult result = new RestResult();
        try {
            studentInfoService.delete(studentIds);
            result.markSuccess();
            addSuccessLog("admin", "student delete", "student delete success");
            log.info("student delete success");
        } catch (Exception e) {
            result.markFailed();
            addFailedLog("admin", "student delete", "student delete failed");
            log.info("student delete failed", e);
        }
        return result;
    }

    @PostMapping("insert")
    public RestResult insert(@RequestBody StudentInfoDTO dto) {
        RestResult result = new RestResult();
        try {
            log.info("insert student info params = {}", JSONObject.toJSONString(dto));
            if (studentInfoService.judgeStudentExist(dto)) {
                result.markRefused();
                result.setMessage("当前年级[" + dto.getGrade() + "]班级[" + dto.getStudentClass() + "]的学生[" + dto.getStudentName() + "]已存在！");
                addSuccessLog("1111", "insert student", "insert student refused");
                log.info("insert student info refused:{}", result.getMessage());
                return result;
            }
            dto.setAccount(studentInfoService.selectMaxStudentId() + 1);
            studentInfoService.insert(dto);
            result.markSuccess();
            addSuccessLog("1111", "insert student", "insert student success");
            log.info("insert student success");
        } catch (Exception e) {
            result.markFailed();
            e.printStackTrace();
            addFailedLog("1111", "insert student", "insert student failed");
            log.error("insert student info error:", e);
        }
        return result;
    }

}


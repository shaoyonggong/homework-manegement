package com.java.homeworkmanagement.controller;

import com.java.homeworkmanagement.pojo.StudentInfoPO;
import com.java.homeworkmanagement.result.RestResult;
import com.java.homeworkmanagement.service.IStudentInfoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author shaoyonggong
 * @since 2021-02-24
 */
@RestController
@RequestMapping("/student-info")
@Api(tags = {"学生信息", "学生：查询"})
public class StudentInfoController {

    @Autowired
    IStudentInfoService studentInfoService;

    @PostMapping("queryAll")

    public RestResult<List<StudentInfoPO>> queryAllStudent(@RequestParam String param) {
        List<StudentInfoPO> list = studentInfoService.queryList();
        return new RestResult<>(list, list.size());
    }
}


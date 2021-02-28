package com.java.homeworkmanagement.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.java.homeworkmanagement.dto.OperationLogDTO;
import com.java.homeworkmanagement.pojo.OperationLogPO;
import com.java.homeworkmanagement.result.RestResult;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 前端控制器
 * </p>
 */
@RestController
@RequestMapping("/managementLog")
@Api(tags = {"操作日志相关接口"})
@Slf4j
public class OperationLogController extends BaseController {

    @PostMapping("searchByCondition")
    public RestResult<List<OperationLogDTO>> queryTaskByCondition(@RequestBody OperationLogDTO dto) {
        RestResult<List<OperationLogDTO>> result = new RestResult<>();
        try {
            IPage<OperationLogPO> pageResult = operationLogService.queryByCondition(dto);
            result.setBody(pageResult.getRecords().stream().map(bean -> {
                        OperationLogDTO logDTO = bean.coverTo();
                        logDTO.setSearchKey(dto.getSearchKey());
                        return logDTO;
                    }
            ).collect(Collectors.toList()));
            result.setTotalCount(pageResult.getTotal());
            result.markSuccess();
            addSuccessLog("admin", "managementLog searchByCondition", "managementLog searchByCondition success");
            log.info("managementLog searchByCondition success");
        } catch (Exception e) {
            result.markFailed();
            addFailedLog("admin", "managementLog searchByCondition", "managementLog searchByCondition failed");
            log.error("managementLog searchByCondition error", e);
        }
        return result;
    }
}


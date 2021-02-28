package com.java.homeworkmanagement.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.java.homeworkmanagement.dto.NoticeDTO;
import com.java.homeworkmanagement.pojo.NoticePO;
import com.java.homeworkmanagement.result.RestResult;
import com.java.homeworkmanagement.service.INoticeService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/notice")
@Api(tags = {"公告信息相关接口"})
@Slf4j
public class NoticeController extends BaseController {
    @Autowired
    INoticeService noticeService;

    @PostMapping("searchByCondition")
    public RestResult<List<NoticeDTO>> queryTaskByCondition(@RequestBody NoticeDTO dto) {
        RestResult<List<NoticeDTO>> result = new RestResult<>();
        try {
            IPage<NoticePO> pageResult = noticeService.queryByCondition(dto);
            result.setBody(pageResult.getRecords().stream().map(NoticePO::coverTo).collect(Collectors.toList()));
            result.setTotalCount(pageResult.getTotal());
            result.markSuccess();
            addSuccessLog("admin", "notice searchByCondition", "notice searchByCondition success");
            log.info("notice searchByCondition success");
        } catch (Exception e) {
            result.markFailed();
            addFailedLog("admin", "notice searchByCondition", "notice searchByCondition failed");
            log.error("notice searchByCondition error", e);
        }
        return result;
    }

    @PostMapping("update")
    public RestResult update(@RequestBody NoticeDTO dto) {
        RestResult result = new RestResult();
        try {
            noticeService.update(dto);
            result.markSuccess();
            addSuccessLog("admin", "notice update", "notice update success");
            log.info("notice searchByCondition success");
        } catch (Exception e) {
            result.markFailed();
            addFailedLog("admin", "notice update", "notice update failed");
            log.error("notice update failed", e);
        }
        return result;
    }

    @PostMapping("insert")
    public RestResult insert(@RequestBody NoticeDTO dto) {
        RestResult result = new RestResult();
        try {
            noticeService.insert(dto);
            result.markSuccess();
            addSuccessLog("admin", "insert notice", "insert notice success");
            log.info("insert notice success");
        } catch (Exception e) {
            result.markFailed();
            e.printStackTrace();
            addFailedLog("admin", "insert notice", "insert notice failed");
            log.error("error", e);
        }
        return result;
    }

}


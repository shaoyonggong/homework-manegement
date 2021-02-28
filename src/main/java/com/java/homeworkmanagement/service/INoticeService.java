package com.java.homeworkmanagement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.java.homeworkmanagement.dto.NoticeDTO;
import com.java.homeworkmanagement.pojo.NoticePO;

/**
 * <p>
 * 服务类
 * </p>
 */
public interface INoticeService extends IService<NoticePO> {

    IPage<NoticePO> queryByCondition(NoticeDTO dto);

    void update(NoticeDTO dto);

    void insert(NoticeDTO dto);
}

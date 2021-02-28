package com.java.homeworkmanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.homeworkmanagement.dao.NoticeMapper;
import com.java.homeworkmanagement.dto.NoticeDTO;
import com.java.homeworkmanagement.pojo.NoticePO;
import com.java.homeworkmanagement.service.INoticeService;
import jodd.util.StringUtil;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, NoticePO> implements INoticeService {

    @Override
    public IPage<NoticePO> queryByCondition(NoticeDTO dto) {
        QueryWrapper<NoticePO> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtil.isNotBlank(dto.getTitle()), "title", dto.getTitle());
        queryWrapper.like(StringUtil.isNotBlank(dto.getNoticeContent()), "notice_content", dto.getNoticeContent());
        queryWrapper.between(dto.getStartTime() != null && dto.getEndTime() != null, "title", dto.getEndTime(), dto.getStartTime());
        return baseMapper.selectPage(new Page<>(dto.getPageNum(), dto.getPageSize()), queryWrapper);
    }

    @Override
    public void update(NoticeDTO dto) {
        baseMapper.updateById(dto.coverTo());
    }

    @Override
    public void insert(NoticeDTO dto) {
        baseMapper.insert(dto.coverTo());
    }
}

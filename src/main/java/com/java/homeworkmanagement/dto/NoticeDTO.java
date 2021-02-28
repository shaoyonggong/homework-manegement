package com.java.homeworkmanagement.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.java.homeworkmanagement.pojo.NoticePO;
import com.java.homeworkmanagement.utils.CoverTo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "Notice对象", description = "")
@TableName("notice")
public class NoticeDTO extends PageDTO implements Serializable, CoverTo<NoticePO> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "公告id")
    private Integer id;

    @ApiModelProperty(value = "公告标题")
    private String title;

    @ApiModelProperty(value = "公告内容")
    private String noticeContent;

    @ApiModelProperty(value = "开始时间")
    private LocalDateTime startTime;

    @ApiModelProperty(value = "结束时间")
    private LocalDateTime endTime;

    @Override
    public NoticePO coverTo() {
        return new NoticePO()
                .setId(this.id)
                .setTitle(this.title)
                .setNoticeContent(this.noticeContent)
                .setStartTime(this.startTime)
                .setEndTime(this.endTime);
    }
}

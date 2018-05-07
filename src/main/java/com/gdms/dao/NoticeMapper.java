package com.gdms.dao;

import com.gdms.model.Admin;
import com.gdms.model.Notice;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface NoticeMapper extends Mapper<Notice> {
    int deleteByPrimaryKey(Integer id);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);

    int insertNotice(Notice notice);

    int updateNotice(Notice notice);

    List<Notice> queryAllNotice();

    int deleteNoticeByid(@Param("id") int id);
}
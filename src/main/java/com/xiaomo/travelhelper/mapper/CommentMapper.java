package com.xiaomo.travelhelper.mapper;

import com.xiaomo.travelhelper.pojo.Comment;
import com.xiaomo.travelhelper.pojo.dto.CommentInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface CommentMapper {
    int insert(Comment record);

    int insertSelective(Comment record);

    List<CommentInfo> listByShareId(Integer shareId);


    int countOfComment();

    List<Map<String,Object>> listCommentDataGroupByMonth();
}
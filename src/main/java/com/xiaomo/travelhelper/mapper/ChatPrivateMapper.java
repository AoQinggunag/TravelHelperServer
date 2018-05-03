package com.xiaomo.travelhelper.mapper;

import com.xiaomo.travelhelper.pojo.ChatPrivate;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ChatPrivateMapper {
    int insert(ChatPrivate record);

    int insertSelective(ChatPrivate record);

    List<ChatPrivate> listByTargetAccount(String targetAccount);

    int deleteByTargetAccount(String targetAccount);



}
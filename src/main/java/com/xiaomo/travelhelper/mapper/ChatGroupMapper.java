package com.xiaomo.travelhelper.mapper;

import com.xiaomo.travelhelper.pojo.ChatGroup;

public interface ChatGroupMapper {
    int insert(ChatGroup record);

    int insertSelective(ChatGroup record);
}
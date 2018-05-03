package com.xiaomo.travelhelper.mapper;

import com.xiaomo.travelhelper.pojo.ChatPublic;

public interface ChatPublicMapper {
    int insert(ChatPublic record);

    int insertSelective(ChatPublic record);
}
package com.xiaomo.travelhelper.mapper;

import com.xiaomo.travelhelper.pojo.MsgQueue;
import com.xiaomo.travelhelper.pojo.dto.FriendInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MsgQueueMapper {
    int insert(MsgQueue record);

    int insertSelective(MsgQueue record);

    List<FriendInfo> getMsgFriendByAccount(@Param("account") String account, @Param("type")Integer type);

    int deleteByMsgFriend(@Param("account") String account,@Param("val") String val);

}
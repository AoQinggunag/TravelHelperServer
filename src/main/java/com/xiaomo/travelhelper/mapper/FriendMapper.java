package com.xiaomo.travelhelper.mapper;

import com.xiaomo.travelhelper.pojo.Friend;
import com.xiaomo.travelhelper.pojo.dto.FriendInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FriendMapper {
    int insert(Friend record);

    int insertSelective(Friend record);

    List<FriendInfo> listFriends(String account);

    List<FriendInfo> likeByAccountOrUsername(@Param("account") String account, @Param("username") String username);

    int checkPK(@Param("account1")String account1,@Param("account2")String account2);

}
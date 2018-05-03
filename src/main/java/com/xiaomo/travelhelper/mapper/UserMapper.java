package com.xiaomo.travelhelper.mapper;

import com.xiaomo.travelhelper.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

    int updateByIdSelective(User record);

    int updateByAccountSelective(User record);

    User findById(Integer id);

    User findByAccount(String account);

    int checkImg(String img);

    int checkEmail(String email);

    int checkAccount(String account);

    User checkLogin(@Param("account") String account,@Param("password") String password);

    int countOfUser();

    List<Map<String,Object>> listUserDataGroupByMonth();

    String getUsernameByAccount(String account);

    String getImgByAccount(String account);

}
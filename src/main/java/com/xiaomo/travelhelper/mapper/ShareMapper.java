package com.xiaomo.travelhelper.mapper;

import com.xiaomo.travelhelper.pojo.Share;
import com.xiaomo.travelhelper.pojo.dto.ShareInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ShareMapper {
    int insert(Share record);

    int insertSelective(Share record);


    List<ShareInfo> listShares();

    List<ShareInfo> listSharesByPage(@Param("startSize") Integer startSize, @Param("pageSize") Integer pageSize);

    int countOfShare();

    List<Map<String,Object>> listShareDataGroupMonth();
}
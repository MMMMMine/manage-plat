package com.xiuqi.cms.persistance;

import com.xiuqi.cms.persistance.po.AppQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AppQueryMapper {

    int insertAppQuery(AppQuery record);

    int deleteAppQueryById(Integer id);

    int updateAppQueryById(AppQuery record);

    AppQuery selectAppQueryById(@Param("id") Integer id);

    List<AppQuery> selectAppQueryList();
}
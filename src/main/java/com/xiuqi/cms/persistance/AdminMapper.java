package com.xiuqi.cms.persistance;

import com.xiuqi.cms.persistance.po.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface AdminMapper {

    int insertAdmin(Admin record);

    int deleteAdminById(Integer adminId);

    int updateAdminById(Admin record);

    Admin selectAdminById(@Param("adminId") Integer adminId);

    Admin selectAdminByAccount(@Param("account") String account);

}
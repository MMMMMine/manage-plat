package com.xiuqi.cms.dto;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by frank on 2017/6/6.
 */
public class AppQueryReq {

    public interface AddOrUp{}

    public interface Del{}

    @NotEmpty(message = "id不能为空", groups = Del.class)
    private Integer id;

    @NotEmpty(message = "查询名称不能为空", groups = AddOrUp.class)
    private String queryName;//查询名称

    @NotEmpty(message = "英文名不能为空", groups = AddOrUp.class)
    private String queryNameEn;//查询名称(英文)

    @NotEmpty(message = "查询描述不能为空", groups = AddOrUp.class)
    private String queryDesc;//查询描述

    @NotEmpty(message = "查询sql不能为空", groups = AddOrUp.class)
    private String querySql;//查询sql

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQueryName() {
        return queryName;
    }

    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }

    public String getQueryNameEn() {
        return queryNameEn;
    }

    public void setQueryNameEn(String queryNameEn) {
        this.queryNameEn = queryNameEn;
    }

    public String getQueryDesc() {
        return queryDesc;
    }

    public void setQueryDesc(String queryDesc) {
        this.queryDesc = queryDesc;
    }

    public String getQuerySql() {
        return querySql;
    }

    public void setQuerySql(String querySql) {
        this.querySql = querySql;
    }
}

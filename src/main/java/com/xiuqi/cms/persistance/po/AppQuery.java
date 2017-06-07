package com.xiuqi.cms.persistance.po;

import java.util.Date;

public class AppQuery {

    private Integer id;

    private String queryName;//查询名称

    private String queryNameEn;//查询名称(英文)

    private String queryDesc;//查询描述

    private String querySql;//查询sql

    private Date createTime;

    private Date updateTime;


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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
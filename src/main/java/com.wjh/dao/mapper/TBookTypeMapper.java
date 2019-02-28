package com.wjh.dao.mapper;

import com.wjh.bean.TBookTypeKey;

public interface TBookTypeMapper {
    int deleteByPrimaryKey(TBookTypeKey key);

    int insert(TBookTypeKey record);

    int insertSelective(TBookTypeKey record);
}
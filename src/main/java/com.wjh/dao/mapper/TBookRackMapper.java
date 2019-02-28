package com.wjh.dao.mapper;

import com.wjh.bean.TBookRack;

public interface TBookRackMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(TBookRack record);

    int insertSelective(TBookRack record);

    TBookRack selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(TBookRack record);

    int updateByPrimaryKey(TBookRack record);
}
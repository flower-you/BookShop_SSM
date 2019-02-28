package com.wjh.dao.mapper;

import com.wjh.bean.TrecentBrowse;

public interface TrecentBrowseMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(TrecentBrowse record);

    int insertSelective(TrecentBrowse record);

    TrecentBrowse selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(TrecentBrowse record);

    int updateByPrimaryKey(TrecentBrowse record);
}
package com.wjh.dao.mapper;

import java.util.List;

import com.wjh.bean.TBook;

public interface TBookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TBook record);

    int insertSelective(TBook record);

    TBook selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TBook record);

    int updateByPrimaryKeyWithBLOBs(TBook record);

    int updateByPrimaryKey(TBook record);
   
    /**
     * 根据最近上线的时间降序排列，order by onlinetime desc
     * @return 所有的的图书集合，按最近上线时间降序排列
     */
    List<TBook> selectRecent();
}
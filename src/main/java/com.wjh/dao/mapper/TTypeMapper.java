package com.wjh.dao.mapper;

import java.util.List;

import com.wjh.bean.TType;

public interface TTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TType record);

    int insertSelective(TType record);

    TType selectByPrimaryKey(Integer id);

    List<TType> selectAll();

    int updateByPrimaryKeySelective(TType record);

    int updateByPrimaryKey(TType record);
    ///////////////////////////////////////
    List<String>  selectNameById(Integer id);
    
}
package com.wjh.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.wjh.bean.TUser;
@Mapper
public interface TUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Integer id);

    TUser selectByUserName(String username);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);
    
    TUser selectSelective(TUser record);
}
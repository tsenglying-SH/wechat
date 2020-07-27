package com.jiuting.mapper;

import com.jiuting.pojo.TUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface TUserMapper {

    int deleteByPrimaryKey(String id);

    int insert(TUser record);

    TUser selectByPrimaryKey(String id);

    List<TUser> selectAll();

    int updateByPrimaryKey(TUser record);

    TUser selectOne(TUser user);

    TUser queryExist(TUser user);
}
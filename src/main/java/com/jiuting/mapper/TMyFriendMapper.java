package com.jiuting.mapper;

import com.jiuting.pojo.TMyFriend;
import java.util.List;

public interface TMyFriendMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_my_friend
     *
     * @mbggenerated Sat Jul 25 20:16:10 CST 2020
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_my_friend
     *
     * @mbggenerated Sat Jul 25 20:16:10 CST 2020
     */
    int insert(TMyFriend record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_my_friend
     *
     * @mbggenerated Sat Jul 25 20:16:10 CST 2020
     */
    TMyFriend selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_my_friend
     *
     * @mbggenerated Sat Jul 25 20:16:10 CST 2020
     */
    List<TMyFriend> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_my_friend
     *
     * @mbggenerated Sat Jul 25 20:16:10 CST 2020
     */
    int updateByPrimaryKey(TMyFriend record);
}
package com.ztx.qa.models.test;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by s016374 on 15/7/3.
 */
public interface UserMapper {
    @Select("SELECT * FROM USER")
    List<User> selectUserAllByID();

    @Select("select * from user where id = #{id}")
    User selectUserByID(int id);

    @Insert("INSERT INTO user (userName, userAge, userAddress) VALUES (#{userName}, #{userAge}, #{userAddress})")
    int insertUser(User user);

    @Delete("DELETE FROM USER WHERE id = #{id}")
    int deleteUserByID(int id);

    @Update("UPDATE USER SET userName=#{userName}, userAge=#{userAge}, userAddress=#{userAddress} WHERE id=#{id}")
    int updateUserByID(User user);
}

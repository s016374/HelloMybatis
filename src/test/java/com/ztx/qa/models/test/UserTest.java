package com.ztx.qa.models.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * Created by s016374 on 15/7/3.
 */
public class UserTest {
    String resource = "Configuration.xml";
    InputStream inputStream;
    SqlSessionFactory sqlSessionFactory;
    SqlSession sqlSession;

    UserMapper userMapper;

    @Before
    public void makeSession() {
        inputStream = UserTest.class.getClassLoader().getResourceAsStream(resource);

        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession(true);

        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void selectUser() {
        String statement = "com.ztx.qa.models.userMapper.selectUserByID";
        User user = sqlSession.selectOne(statement, 5);
        System.out.println(user);
    }

    @Test
    public void insertUser() {
        String statement = "com.ztx.qa.models.userMapper.insertUser";
        int result = sqlSession.insert(statement, new User("Mary", "20", "NewYork"));
        System.out.println(result);
//        sqlSession.commit();
    }

    @Test
    public void updateUser() {
        String statement = "com.ztx.qa.models.userMapper.updateUserByID";
        int result = sqlSession.update(statement, new User(6, "Mike", "11", "Beijing"));
        System.out.println(result);
    }

    @Test
    public void deleteUser() {
        String statement = "com.ztx.qa.models.userMapper.deleteUserByID";
        int result = sqlSession.delete(statement, 1);
        System.out.println(result);
    }

    @Test
    public void selectUserAll() {
        String statement = "com.ztx.qa.models.userMapper.selectUserAllByID";
        List<User> result = sqlSession.selectList(statement);
        System.out.println(result);
    }

    @Test
    public void selectUserAll_AT() {
        List<User> result = userMapper.selectUserAllByID();
        System.out.println(result);
    }

    @Test
    public void selectUserByID_AT() {
        User result = userMapper.selectUserByID(5);
        System.out.println(result);
    }

    @Test
    public void insertUser_AT() {
        int result = userMapper.insertUser(new User("Tim", "40", "London"));
        System.out.println(result);
    }

    @Test
    public void deleteUserByID_AT() {
        int result = userMapper.deleteUserByID(4);
        System.out.println(result);
    }

    @Test
    public void updateUserByID_AT() {
        int result = userMapper.updateUserByID(new User(5, "Gay", "54", "London"));
        System.out.println(result);
    }

    @After
    public void closeSession() {
        sqlSession.close();
    }
}
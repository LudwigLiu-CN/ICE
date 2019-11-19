package com.example.demo.dao;

import com.example.demo.entity.Users;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@Component(value="UsersMapper")
public interface UsersMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKeyWithBLOBs(Users record);

    int updateByPrimaryKey(Users record);

    //新建用户
    boolean addUser(Users users);
    //用户修改个人信息
    boolean updateUserInfo(Users users);

    boolean updateUserAvatar(Users users);

    boolean logOut(String userName);

    boolean checkPassword(String userName,String password);

    boolean ifAdd(Users users);

    boolean deleteUser(Integer userId);

    List<Users> getAllUser();

    List<Users> commentUser(Integer userId);

    List<Users> userLists(String userName);
}
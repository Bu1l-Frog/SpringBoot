package com.example.service;

import com.example.pojo.User;

import java.util.List;

public interface UserService {

    public void saveUser(User user) throws Exception;

    public void updateUser(User user);

    public void deletUser(String userId);

    public User queryUserById(String userId);

    public List<User> queryUserList(User user, Integer page, Integer pageSize);

    public List<User> queryUserByIdCustom(String id);
}

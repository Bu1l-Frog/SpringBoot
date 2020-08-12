package com.example.service.impl;

import com.example.mapper.UserMapper;
import com.example.mapper.UserMapperCustom;
import com.example.pojo.User;
import com.example.service.UserService;
import com.github.pagehelper.PageHelper;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserMapperCustom userMapperCustom;

    @Override
    //事务持久化
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveUser(User user) throws Exception {
        userMapper.insert(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void deletUser(String userId) {
        userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public User queryUserById(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<User> queryUserList(User user, Integer page, Integer pageSize) {
        //开始分页
        PageHelper.startPage(page, pageSize);
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();

        if(!StringUtils.isEmptyOrWhitespaceOnly(user.getName())){
            criteria.andLike("name", "%" + user.getName() + "%");
        }
        example.orderBy("registTime").desc();
        List<User> userList = userMapper.selectByExample(example);
        return userList;
    }

    @Override
    public List<User> queryUserByIdCustom(String id){

        List<User> userList = userMapperCustom.queryUserSimplyInfoById(id);

        if (userList != null && !userList.isEmpty()){
            return userList;
        }
        return null;
    }
}

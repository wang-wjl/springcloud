package com.wjl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wjl.mapper.UserMapper;
import com.wjl.pojo.User;
@Service
public class UserService {
	@Autowired
	private UserMapper mapper;
	
	//添加事务
	@Transactional
	public User getUserById(Long id)
	{
		return mapper.selectByPrimaryKey(id);
	}
}

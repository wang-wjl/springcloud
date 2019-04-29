package com.wjl.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wjl.pojo.User;
import com.wjl.service.UserService;

@RestController
@RequestMapping("user")
public class MapperController {
	
	@Autowired
	private UserService service;
	@RequestMapping("/query")
	public User queryUser()
	{
		User user = service.getUserById(1l);
		return user;
	}
	
	@RequestMapping("{id}")
	public User queryUserById(@PathVariable("id") Long id)
	{
		User user = service.getUserById(id);
		return user;
	}
	
}

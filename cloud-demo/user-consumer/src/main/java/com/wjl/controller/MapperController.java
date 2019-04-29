package com.wjl.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.wjl.pojo.User;

@RestController
@RequestMapping("user")
public class MapperController {
	
	@Autowired
	private DiscoveryClient  discoveryClient;
	
	
	@Autowired
	private RestTemplate  restTemplate;
	@RequestMapping("{id}")
	public User queryUserById(@PathVariable("id") Long id)
	{
		String url="http://localhost:8088/user/"+id;
		User user=restTemplate.getForObject(url, User.class);
		return user;
	}
	/**
	 * 使用zureka
	 * @param id
	 * @return
	 */
	@RequestMapping("z/{id}")
	public User queryUserByIdZurela(@PathVariable("id") Long id)
	{
		ServiceInstance service = discoveryClient.getInstances("user-service").get(0);
		String host = service.getHost();
		int port = service.getPort();
		String url="http://"+host+":"+port+"/user/"+id;
		User user = restTemplate.getForObject(url, User.class);
		return user;
	}
	
	
	
	
	
}

/*
 * Copyright (C) 2013 BEIJING UNION VOOLE TECHNOLOGY CO., LTD
 */
package com.github.wowcinder.examples.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.wowcinder.examples.entity.User;

/**
 * @author XuehuiHe
 * @date 2013年9月6日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-service.xml" })
public class UserServiceTest {
	@Autowired
	private UserService service;

//	@Test
	public void test() {
		User u = new User();
		u.setName("test1");
		u.setPassword("pppp");
		service.save(u);

		System.out.println(u.getPassword());
	}

	@Test
	public void test2() {
		User u = new User();
		u.setName("test1");
		u.setPassword("kkk");
		service.save(u);

		u.setPassword(null);

		service.update(u);
	}
}

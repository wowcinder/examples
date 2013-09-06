/*
 * Copyright (C) 2013 BEIJING UNION VOOLE TECHNOLOGY CO., LTD
 */
package com.github.wowcinder.examples.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.wowcinder.examples.entity.DynamicUpdateEntity;

/**
 * @author XuehuiHe
 * @date 2013年9月6日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-service.xml" })
public class DynamicUpdateTest {
	@Autowired
	private DynamicUpdate service;

	@Test
	public void test1() {
		DynamicUpdateEntity entity = new DynamicUpdateEntity();
		entity.setName1("name1");
		entity.setName2("name2");
		entity.setName3("name3");

		service.save(entity);

		service.update(entity.getId());
	}

}

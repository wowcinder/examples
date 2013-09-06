/*
 * Copyright (C) 2013 BEIJING UNION VOOLE TECHNOLOGY CO., LTD
 */
package com.github.wowcinder.examples.service;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.wowcinder.examples.entity.DynamicUpdateEntity;

/**
 * @author XuehuiHe
 * @date 2013年9月6日
 */
@Service
public class DynamicUpdateImpl implements DynamicUpdate {
	@Resource(name = "sessionFactory1")
	private SessionFactory sf;

	@Override
	@Transactional
	public void save(DynamicUpdateEntity entity) {
		getSession().save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public DynamicUpdateEntity get(Integer id) {
		return (DynamicUpdateEntity) getSession().get(
				DynamicUpdateEntity.class, id);
	}

	@Override
	@Transactional
	public void update(Integer id) {
		DynamicUpdateEntity entity = get(id);
		entity.setName1("name1");
		entity.setName2("name2_test");
		getSession().update(entity);
	}

	Session getSession() {
		return sf.getCurrentSession();
	}

}

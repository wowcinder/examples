/*
 * Copyright (C) 2013 BEIJING UNION VOOLE TECHNOLOGY CO., LTD
 */
package com.github.wowcinder.examples.service;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.wowcinder.examples.entity.User;

/**
 * @author XuehuiHe
 * @date 2013年9月6日
 */
@Service
public class UserServiceImpl implements UserService {
	@Resource(name = "sessionFactory2")
	private SessionFactory sf;

	@Override
	@Transactional
	public void save(User user) {
		getSession().save(user);
	}

	@Override
	@Transactional
	public void update(User user) {
		getSession().update(user);
	}

	Session getSession() {
		return sf.getCurrentSession();
	}

}

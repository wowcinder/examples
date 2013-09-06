/*
 * Copyright (C) 2013 BEIJING UNION VOOLE TECHNOLOGY CO., LTD
 */
package com.github.wowcinder.examples.entity;

/**
 * @author XuehuiHe
 * @date 2013年9月6日
 */
public interface PasswordPersistence {
	String getPassword();

	void setPassword(String password);

	String getPasswordPropertyName();
}

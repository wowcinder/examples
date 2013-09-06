/*
 * Copyright (C) 2013 BEIJING UNION VOOLE TECHNOLOGY CO., LTD
 */
package com.github.wowcinder.examples.service;

import com.github.wowcinder.examples.entity.DynamicUpdateEntity;

/**
 * @author XuehuiHe
 * @date 2013年9月6日
 */
public interface DynamicUpdate {
	void save(DynamicUpdateEntity entity);

	DynamicUpdateEntity get(Integer id);

	void update(Integer id);
}

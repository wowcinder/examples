/*
 * Copyright (C) 2013 BEIJING UNION VOOLE TECHNOLOGY CO., LTD
 */
package com.github.wowcinder.examples.entity;

import java.util.Date;

/**
 * @author XuehuiHe
 * @date 2013幄1�7�1�7�1�7
 */
public interface EntityHasTimeStamp {
	Date getLastUpdateTimeStamp();

	Date getCreateTime();

	void setCreateTime(Date createTime);

	void setLastUpdateTimeStamp(Date lastUpdateTimeStamp);

	String getCreateTimePropertyName();
}

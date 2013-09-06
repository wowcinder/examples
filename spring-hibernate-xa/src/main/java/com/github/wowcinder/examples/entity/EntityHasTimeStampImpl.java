/*
 * Copyright (C) 2013 BEIJING UNION VOOLE TECHNOLOGY CO., LTD
 */
package com.github.wowcinder.examples.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.AccessType;

/**
 * @author XuehuiHe
 * @date 2013幄1�7�1�7�1�7
 */
@MappedSuperclass
public class EntityHasTimeStampImpl implements EntityHasTimeStamp {
	private Date createTime;
	private Date lastUpdateTimeStamp;

	public EntityHasTimeStampImpl() {
	}

	@Override
	@Temporal(TemporalType.TIMESTAMP)
	@AccessType("property")
	@Column(name = "ts", nullable = false, insertable = false, updatable = false, columnDefinition = "timestamp")
	public Date getLastUpdateTimeStamp() {
		return lastUpdateTimeStamp;
	}

	@Override
	@Temporal(TemporalType.TIMESTAMP)
	@AccessType("property")
	@Column(name = "create_time", nullable = false, updatable = false)
	public Date getCreateTime() {
		return createTime;
	}

	@Override
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public void setLastUpdateTimeStamp(Date lastUpdateTimeStamp) {
		this.lastUpdateTimeStamp = lastUpdateTimeStamp;
	}

	@Override
	@Transient
	public String getCreateTimePropertyName() {
		return "createTime";
	}

}

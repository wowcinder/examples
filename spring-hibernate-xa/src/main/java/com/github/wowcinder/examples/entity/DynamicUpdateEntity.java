/*
 * Copyright (C) 2013 BEIJING UNION VOOLE TECHNOLOGY CO., LTD
 */
package com.github.wowcinder.examples.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author XuehuiHe
 * @date 2013年9月6日
 */
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class DynamicUpdateEntity extends EntityHasTimeStampImpl {

	private static final long serialVersionUID = 6614060963070300025L;

	private Integer id;
	private String name1;
	private String name2;
	private String name3;

	public DynamicUpdateEntity() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(nullable = false, length = 20)
	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}
	@Column(nullable = true, length = 20)
	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	@Column(nullable = true, length = 20)
	public String getName3() {
		return name3;
	}

	public void setName3(String name3) {
		this.name3 = name3;
	}

}

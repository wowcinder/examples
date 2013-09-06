/*
 * Copyright (C) 2013 BEIJING UNION VOOLE TECHNOLOGY CO., LTD
 */
package com.github.wowcinder.examples.entity.listener;

import org.hibernate.event.PostInsertEvent;
import org.hibernate.event.PostInsertEventListener;
import org.hibernate.event.PostUpdateEvent;
import org.hibernate.event.PostUpdateEventListener;
import org.hibernate.event.PreInsertEvent;
import org.hibernate.event.PreInsertEventListener;
import org.hibernate.event.PreUpdateEvent;
import org.hibernate.event.PreUpdateEventListener;
import org.springframework.stereotype.Component;

import com.github.wowcinder.examples.entity.PasswordPersistence;

/**
 * @author XuehuiHe
 * @date 2013年9月6日
 */
public class PasswordPersistenceListener {
	@Component(value = "passwordPersistencePreInsertListener")
	public static class PasswordPersistencePreInsertListener implements
			PreInsertEventListener {
		private static final long serialVersionUID = 7706646439560261088L;

		@Override
		public boolean onPreInsert(PreInsertEvent event) {
			Object o = event.getEntity();
			if (o instanceof PasswordPersistence) {
				PasswordPersistence p = (PasswordPersistence) o;
				if (p.getPassword() != null) {
					String password = p.getPassword() + "_123";
					p.setPassword(password);

					String[] propertyNames = event.getPersister()
							.getEntityMetamodel().getPropertyNames();
					Object[] state = event.getState();
					String propertyToSet = p.getPasswordPropertyName();
					int index = 0;
					for (int i = 0; i < propertyNames.length; i++) {
						if (propertyToSet.equals(propertyNames[i])) {
							index = i;
							break;
						}
					}
					if (index >= 0) {
						state[index] = password;
					}
				}
			}
			return false;
		}
	}

	@Component(value = "passwordPersistencePreUpdateListener")
	public static class PasswordPersistencePreUpdateListener implements
			PreUpdateEventListener {

		private static final long serialVersionUID = -4360626376855747564L;

		@Override
		public boolean onPreUpdate(PreUpdateEvent event) {
			Object o = event.getEntity();
			if (o instanceof PasswordPersistence) {
				PasswordPersistence p = (PasswordPersistence) o;
				String password = null;
				if (p.getPassword() != null) {
					password = p.getPassword() + "_123";
				} else {
					PasswordPersistence old = (PasswordPersistence) event
							.getPersister().getFactory().openSession()
							.get(event.getEntity().getClass(), event.getId());
					password = old.getPassword();
				}
				String[] propertyNames = event.getPersister()
						.getEntityMetamodel().getPropertyNames();
				Object[] state = event.getState();
				String propertyToSet = p.getPasswordPropertyName();
				int index = 0;
				for (int i = 0; i < propertyNames.length; i++) {
					if (propertyToSet.equals(propertyNames[i])) {
						index = i;
						break;
					}
				}
				if (index >= 0) {
					state[index] = password;
				}
			}
			return false;
		}
	}

	@Component(value = "passwordPersistencePostInsertOrUpdate")
	public static class PasswordPersistencePostInsertOrUpdate implements
			PostInsertEventListener, PostUpdateEventListener {
		private static final long serialVersionUID = 1L;

		@Override
		public void onPostUpdate(PostUpdateEvent event) {
			Object o = event.getEntity();
			if (o instanceof PasswordPersistence) {
				PasswordPersistence p = (PasswordPersistence) o;
				p.setPassword(null);
				String password = null;
				String[] propertyNames = event.getPersister()
						.getEntityMetamodel().getPropertyNames();
				Object[] state = event.getState();
				String propertyToSet = p.getPasswordPropertyName();
				int index = 0;
				for (int i = 0; i < propertyNames.length; i++) {
					if (propertyToSet.equals(propertyNames[i])) {
						index = i;
						break;
					}
				}
				if (index >= 0) {
					state[index] = password;
				}
			}
		}

		@Override
		public void onPostInsert(PostInsertEvent event) {
			Object o = event.getEntity();
			if (o instanceof PasswordPersistence) {
				PasswordPersistence p = (PasswordPersistence) o;
				p.setPassword(null);
				String password = null;
				String[] propertyNames = event.getPersister()
						.getEntityMetamodel().getPropertyNames();
				Object[] state = event.getState();
				String propertyToSet = p.getPasswordPropertyName();
				int index = 0;
				for (int i = 0; i < propertyNames.length; i++) {
					if (propertyToSet.equals(propertyNames[i])) {
						index = i;
						break;
					}
				}
				if (index >= 0) {
					state[index] = password;
				}
			}
		}
	}
}

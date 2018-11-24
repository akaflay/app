package code.better.com.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDao<T> {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<T> find(Class<?> cl) {
		return sessionFactory.getCurrentSession().createQuery(String.format("from %s", cl.getSimpleName())).list();
	}

	@SuppressWarnings("unchecked")
	public T findById(Class<?> cl, String id) {
		return (T) sessionFactory.getCurrentSession().get(cl, id);
	}

	public void delete(Class<?> cl, String id) {
		T obj = findById(cl, id);
		sessionFactory.getCurrentSession().delete(obj);
	}

	public void add(T object) {
		sessionFactory.getCurrentSession().save(object);
	}

}

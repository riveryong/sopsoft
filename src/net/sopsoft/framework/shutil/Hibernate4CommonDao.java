package net.sopsoft.framework.shutil;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Hibernate4CommonDao {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession() {
		// 事务必须是开启的(Required)，否则获取不到
		return sessionFactory.getCurrentSession();
	}
	
	// 查
	public List Search(String hql) {
		return getSession().createQuery(hql).list();
	}

	// 增
	public void add(Object o) {
		getSession().save(o);

	}

	// 删
	public void delete(Object o) {
		getSession().delete(o);

	}
	// 按id加载
	public Object load(Class clz, Serializable id) {

		return getSession().get(clz, id);
	}

	// 改
	public void update(Object o) {
		getSession().update(o);

	}

	public List SearchByCriteria(
			PaginationDetachedCriteria paginationDetachedCriteria) {
		DetachedCriteria dc = paginationDetachedCriteria.getDetachedCriteria();
		Criteria criteria = dc.getExecutableCriteria(getSession());
		criteria.setFirstResult(paginationDetachedCriteria.getFirstResult());
		criteria.setMaxResults(paginationDetachedCriteria.getMaxResults());
		return criteria.list();
	}

	public List SearchByCriteria(DetachedCriteria detachedCriteria) {
		Criteria criteria = detachedCriteria.getExecutableCriteria(getSession());
		return criteria.list();
	}
}

package net.sopsoft.utils.shutil;

import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


class Dao extends HibernateDaoSupport{
	
	// 查
	public List Search(String hql) {
		return getHibernateTemplate().find(hql);
	}

	// 增
	public void add(Object o) {
		getHibernateTemplate().save(o);

	}

	// 删
	public void delete(Object o) {
		getHibernateTemplate().delete(o);

	}
	// 按id加载
	public Object load(Class clz, Serializable id) {

		return getHibernateTemplate().get(clz, id);
	}

	// 改
	public void update(Object o) {
		getHibernateTemplate().update(o);

	}

	public List SearchByCriteria(
			PaginationDetachedCriteria paginationDetachedCriteria) {

		return getHibernateTemplate().findByCriteria(
				paginationDetachedCriteria.getDetachedCriteria(),
				paginationDetachedCriteria.getFirstResult(),
				paginationDetachedCriteria.getMaxResults());
	}

	public List SearchByCriteria(DetachedCriteria DetachedCriteria) {
		
		return getHibernateTemplate().findByCriteria(DetachedCriteria);
	}
}

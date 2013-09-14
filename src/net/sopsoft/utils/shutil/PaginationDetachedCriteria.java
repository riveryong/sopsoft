package net.sopsoft.utils.shutil;

import org.hibernate.criterion.DetachedCriteria;

class PaginationDetachedCriteria {

//	protected PaginationDetachedCriteria(String entityName, String alias) {
//		super(entityName, alias);
//		// TODO Auto-generated constructor stub
//	}
//
//	protected PaginationDetachedCriteria(String entityName) {
//		super(entityName);
//		// TODO Auto-generated constructor stub
//	}
//
//	protected PaginationDetachedCriteria(CriteriaImpl impl, Criteria criteria) {
//		super(impl, criteria);
//		// TODO Auto-generated constructor stub
//	}
	private DetachedCriteria detachedCriteria;
	private int firstResult;  //当前页数  
	private int maxResults;    //每页记录条数	
	
	public PaginationDetachedCriteria(Class clz){
		detachedCriteria = DetachedCriteria.forClass(clz);		
	}
	
	public PaginationDetachedCriteria(Class clz,int firstResult,int maxResults){
		detachedCriteria = DetachedCriteria.forClass(clz);
		this.firstResult = firstResult;
		this.maxResults = maxResults;
	}

	public DetachedCriteria getDetachedCriteria() {
		return detachedCriteria;
	}

	public int getFirstResult() {
		return firstResult;
	}

	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}

	public int getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}
	
}

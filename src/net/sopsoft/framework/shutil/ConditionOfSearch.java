package net.sopsoft.framework.shutil;

import org.hibernate.Criteria;


public interface ConditionOfSearch {
	
	public void addConditionToCriteria(Criteria criteria);
	
	public void addConditionToPaginationDetachedCriteria(PaginationDetachedCriteria paginationDetachedCriteria);
	

}

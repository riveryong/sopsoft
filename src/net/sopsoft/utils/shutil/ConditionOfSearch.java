package net.sopsoft.utils.shutil;

import org.hibernate.Criteria;


public interface ConditionOfSearch {
	
	public void addConditionToCriteria(Criteria criteria);
	
	public void addConditionToPaginationDetachedCriteria(PaginationDetachedCriteria paginationDetachedCriteria);
	

}

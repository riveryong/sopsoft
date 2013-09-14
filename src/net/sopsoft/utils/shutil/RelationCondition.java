package net.sopsoft.utils.shutil;

import org.hibernate.criterion.DetachedCriteria;

public interface RelationCondition extends ConditionOfSearch {

	public void addConditionToDetachedCriteria(DetachedCriteria detachedCriteria);
}

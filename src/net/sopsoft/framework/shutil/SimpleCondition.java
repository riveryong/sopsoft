package net.sopsoft.framework.shutil;

import org.hibernate.criterion.Criterion;

public interface SimpleCondition extends RelationCondition {
	Criterion toComplexCondition();
}

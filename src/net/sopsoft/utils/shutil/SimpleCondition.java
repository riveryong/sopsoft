package net.sopsoft.utils.shutil;

import org.hibernate.criterion.Criterion;

public interface SimpleCondition extends RelationCondition {
	Criterion toComplexCondition();
}

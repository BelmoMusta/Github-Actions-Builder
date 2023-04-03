package org.example.yy.support;

import org.example.collections.Branches;
import org.example.yy.WorkflowEvent;

public interface BranchesSupport extends ElementsSupport {
	
	default <E extends WorkflowEvent> E addBranches(E event, String... branches) {
		return addElements(event, Branches::new, Branches.class, branches);
	}
}

package org.example.yy.support;

import org.example.collections.BranchesIgnore;
import org.example.yy.WorkflowEvent;

public interface BranchesIgnoreSupport extends ElementsSupport {

    default <E extends WorkflowEvent> E addBranchesIgnore(E event, String... branches) {
        return addElements(event, BranchesIgnore::new, BranchesIgnore.class, branches);
    }
}

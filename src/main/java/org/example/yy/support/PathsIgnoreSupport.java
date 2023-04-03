package org.example.yy.support;

import org.example.collections.PathsIgnore;
import org.example.yy.WorkflowEvent;

public interface PathsIgnoreSupport extends ElementsSupport {
	
	 default <E extends WorkflowEvent> E addPathsIgnore(E event, String... paths) {
		 return addElements(event, PathsIgnore::new, PathsIgnore.class, paths);
	 }
}

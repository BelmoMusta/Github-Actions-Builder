package org.example.yy.support;

import org.example.collections.TagsIgnore;
import org.example.yy.WorkflowEvent;

public interface TagsIgnoreSupport extends ElementsSupport {
	
	default <E extends WorkflowEvent> E addTagsIgnore(E event, String... tags) {
		return addElements(event, TagsIgnore::new, TagsIgnore.class, tags);
	}
}

package org.example.yy.support;

import org.example.collections.Tags;
import org.example.yy.WorkflowEvent;

public interface TagsSupport extends ElementsSupport {

    default <E extends WorkflowEvent> E addTags(E event, String... tags) {
        return addElements(event, Tags::new, Tags.class, tags);
    }
}

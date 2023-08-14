package org.example.yy;

import org.example.collections.Paths;
import org.example.yy.support.ElementsSupport;

public interface PathsSupport extends ElementsSupport {

    default <E extends WorkflowEvent> E addPaths(E event, String... paths) {
        return addElements(event, Paths::new, Paths.class, paths);
    }
}

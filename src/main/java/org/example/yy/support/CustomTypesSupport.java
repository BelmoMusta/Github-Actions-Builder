package org.example.yy.support;

import org.example.collections.Nodes;
import org.example.collections.Types;
import org.example.wrappers.leaves.DashSingleElement;
import org.example.yy.WorkflowEvent;

public interface CustomTypesSupport extends ElementsSupport {

    default <E extends WorkflowEvent> E addTypes(E event, String... types) {
        return addElements(event, Types::new, Types.class, types);
    }

    @Override
    default void addElements(Nodes nodes, String[] elements) {
        addGenericElements(nodes, elements, DashSingleElement.class, DashSingleElement::new);

    }
}

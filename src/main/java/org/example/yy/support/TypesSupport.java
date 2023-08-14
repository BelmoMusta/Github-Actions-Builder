package org.example.yy.support;

import org.example.collections.Nodes;
import org.example.collections.Types;
import org.example.wrappers.leaves.DashSingleElement;
import org.example.yy.WorkflowEvent;

import java.util.function.Supplier;

public interface TypesSupport extends ElementsSupport {

    private static void addElements(Nodes nodes, TypeI[] types) {
        for (TypeI type : types) {
            DashSingleElement tag = nodes.findTag(DashSingleElement.class);
            DashSingleElement element = new DashSingleElement(type.toString());
            if (tag == null || !tag.getValue().equals(type.toString())) {
                nodes.add(element);
            }
        }
    }

    default <E extends WorkflowEvent> E addTypes(E event, TypeI... types) {
        return addElements(event, Types::new, Types.class, types);
    }

    default <C extends Nodes, E extends WorkflowEvent> E addElements(E event,
                                                                     Supplier<C> nodesSupplier,
                                                                     Class<C> aClass,
                                                                     TypeI... elements) {
        Nodes innerNodes = event.findTag(aClass);
        if (innerNodes == null) {
            innerNodes = nodesSupplier.get();
            event.add(innerNodes);
        }
        addElements(innerNodes, elements);
        return event;
    }

    interface TypeI {

    }
}

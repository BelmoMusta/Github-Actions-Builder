package org.example.yy.support;

import org.example.collections.Nodes;
import org.example.wrappers.leaves.DashQuotedSingleElement;
import org.example.wrappers.leaves.SingleElement;
import org.example.yy.WorkflowEvent;

import java.util.function.Function;
import java.util.function.Supplier;

public interface ElementsSupport {
    default <C extends Nodes, E extends WorkflowEvent> E addElements(E event,
                                                                     Supplier<C> nodesSupplier,
                                                                     Class<C> aClass,
                                                                     String... elements) {
        Nodes innerNodes = event.findTag(aClass);
        if (innerNodes == null) {
            innerNodes = nodesSupplier.get();
            event.add(innerNodes);
        }
        addElements(innerNodes, elements);
        return event;
    }

    default void addElements(Nodes nodes, String[] elements) {
        addGenericElements(nodes, elements, DashQuotedSingleElement.class, DashQuotedSingleElement::new);
    }

    default <S extends SingleElement> void addGenericElements(Nodes nodes,
                                                              Object[] elements,
                                                              Class<S> cls,
                                                              Function<String, S> generator) {
        for (Object element : elements) {
            SingleElement existingTag = nodes.findTag(cls);
            SingleElement newElement = generator.apply(String.valueOf(element));
            if (existingTag == null || !existingTag.getValue().equals(element)) {
                nodes.add(newElement);
            }
        }
    }

    default <N extends Nodes> N addNodes(N destNode,
                                         Class<? extends Nodes> cls,
                                         Supplier<Nodes> generator,
                                         Nodes... nodes) {
        Nodes innerJobs = destNode.findTag(cls);
        if (innerJobs == null) {
            innerJobs = generator.get();
            destNode.add(innerJobs);
        }
        for (Nodes job : nodes) {
            innerJobs.add(job);
        }
        return destNode;
    }
}

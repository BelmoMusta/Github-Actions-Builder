package org.example.yy.support;

import org.example.collections.Nodes;
import org.example.wrappers.DashQuotedSingleElement;
import org.example.wrappers.SingleElement;
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
		addGenericElements(nodes, elements,DashQuotedSingleElement.class, DashQuotedSingleElement::new);
	}
	
	default <S extends SingleElement> void addGenericElements(Nodes nodes,
															   String[] elements,
															   Class<S> cls,
															   Function<String, S>  generator) {
		for (String element : elements) {
			SingleElement existingTag = nodes.findTag(cls);
			SingleElement newElement = generator.apply(element);
			if (existingTag == null || !existingTag.value.equals(element)) {
				nodes.add(newElement);
			}
		}
	}
}

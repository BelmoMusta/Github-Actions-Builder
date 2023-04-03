package org.example.yy.support;

import org.example.collections.Nodes;
import org.example.wrappers.DashQuotedSingleElement;
import org.example.yy.WorkflowEvent;

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
	
	private static void addElements(Nodes nodes, String[] elements) {
		for (String element : elements) {
			DashQuotedSingleElement exisitingTag = nodes.findTag(DashQuotedSingleElement.class);
			DashQuotedSingleElement newElement = new DashQuotedSingleElement(element);
			if (exisitingTag == null || !exisitingTag.value.equals(element)) {
				nodes.add(newElement);
			}
		}
	}
}

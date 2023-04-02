package org.example.yy;

import org.example.collections.Nodes;
import org.example.collections.Types;
import org.example.wrappers.DashSingleElement;

public abstract class WorkflowEvent extends Nodes {
	
	protected WorkflowEvent(String name) {
		super(name);
	}
	
	public static <E extends WorkflowEvent> E addTypes(E event, TypeI... types) {
		Types innerTypes = event.findTag(Types.class);
		if (innerTypes == null) {
			innerTypes = new Types();
			event.add(innerTypes);
		}
		for (TypeI type : types) {
			DashSingleElement tag = innerTypes.findTag(DashSingleElement.class);
			DashSingleElement element = new DashSingleElement(type.toString());
			if (tag == null) {
				innerTypes.add(element);
			} else {
				if (!tag.value.equals(type.toString())) {
					innerTypes.add(element);
				}
			}
		}
		
		return event;
	}
	
	protected interface TypeI {
	
	}
	
}

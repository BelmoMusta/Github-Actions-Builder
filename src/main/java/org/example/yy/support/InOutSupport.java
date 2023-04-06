package org.example.yy.support;

import org.example.collections.Nodes;
import org.example.wrappers.InOut;
import org.example.yy.WorkflowEvent;

import java.util.function.Supplier;

public interface InOutSupport {
	
	default <E extends WorkflowEvent, N extends Nodes> E addInouts(E event,
																   Class<N> cls,
																   Supplier<N> generator,
																   InOut... inputs) {
		
		N exisistingInput = event.findTag(cls);
		if (exisistingInput == null) {
			exisistingInput = generator.get();
			event.add(exisistingInput);
		}
		for (InOut input : inputs) {
			exisistingInput.add(input);
		}
		
		return event;
	}
	
}

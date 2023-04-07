package org.example.yy.support;

import org.example.collections.Inputs;
import org.example.wrappers.Input;
import org.example.yy.WorkflowEvent;

public interface InputSupport extends InOutSupport {
	
	default <E extends WorkflowEvent> E addInputs(E event, Input... inputs) {
		return addInouts(event, Inputs.class, Inputs::new, inputs);
	}
	
	
	
}

package org.example.yy.support;

import org.example.collections.Inputs;
import org.example.collections.Nodes;
import org.example.wrappers.InOut;
import org.example.wrappers.Input;
import org.example.yy.WorkflowEvent;

import java.util.function.Supplier;

public interface InputSupport extends InOutSupport {
	
	default <E extends WorkflowEvent> E addInputs(E event, Input... inputs) {
		return addInouts(event, Inputs.class, Inputs::new, inputs);
	}
	
	
	
}

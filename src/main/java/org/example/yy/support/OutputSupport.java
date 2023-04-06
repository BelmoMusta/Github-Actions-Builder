package org.example.yy.support;

import org.example.collections.Outputs;
import org.example.wrappers.Output;
import org.example.yy.WorkflowEvent;

public interface OutputSupport extends InOutSupport {
	
	default <E extends WorkflowEvent> E addOutputs(E event, Output... outputs) {
		return addInouts(event, Outputs.class, Outputs::new, outputs);
	}
	
	
}

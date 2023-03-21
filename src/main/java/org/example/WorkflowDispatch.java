package org.example;

import org.example.collections.Inputs;
import org.example.wrappers.Input;

public class WorkflowDispatch extends WorkflowEvent {
	
	protected WorkflowDispatch() {
		super("workflow_dispatch");
	}
	
	public static WorkflowDispatch inputs(Input... inputs) {
		final WorkflowDispatch workflowDispatch = new WorkflowDispatch();
		Inputs innerInputs = new Inputs();
		
		for (Input input : inputs) {
			innerInputs.add(input);
		}
		workflowDispatch.add(innerInputs);
		return workflowDispatch;
	}
	
	public static WorkflowDispatch $(){
		return new WorkflowDispatch();
	}
	
}

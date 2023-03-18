package org.example;

import org.example.collections.Inputs;
import org.example.wrappers.Input;

public class WorkflowDispatch extends WorkflowEvent {
	Inputs inputs = new Inputs();
	
	public static WorkflowDispatch inputs(Input... inputs) {
		final WorkflowDispatch workflowDispatch = new WorkflowDispatch();
		for (Input input : inputs) {
			workflowDispatch.inputs.add(input);
		}
		return workflowDispatch;
	}
	
	public static WorkflowDispatch $(){
		return new WorkflowDispatch();
	}
	
	
	@Override
	public String toString() {
		inputs.setIndentLevel(getIndentLevel() + 1);
		Appender appender = new Appender();
		appender.append("workflow_dispatch: ");
		appender.newLine();
		appender.indent(getIndentLevel() + 1);
		appender.append("inputs: ");
		appender.newLine();
		appender.append(inputs.toString());
		
		return appender.toString();
	}
}

package org.example;

import org.example.collections.Inputs;
import org.example.wrappers.Indentable;
import org.example.wrappers.Input;
import org.example.wrappers.SingleElement;

import java.util.Arrays;
import java.util.List;

public class WorkflowDispatch extends WorkflowEvent {
	SingleElement name = new SingleElement("workflow_dispatch");
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
	public void setIndentLevel(int indentLvel) {
		super.setIndentLevel(indentLvel);
		name.setIndentLevel(indentLvel);
		inputs.setIndentLevel(getIndentLevel() + 1);
	}
	
	@Override
	protected List<Indentable> getIndentables() {
		return Arrays.asList(name, inputs);
	}
}

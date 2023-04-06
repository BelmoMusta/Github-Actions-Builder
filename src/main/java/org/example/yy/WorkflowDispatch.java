package org.example.yy;

import org.example.visitor.Visitor;
import org.example.wrappers.Input;
import org.example.yy.support.InputSupport;

public class WorkflowDispatch extends WorkflowEvent implements InputSupport {
	
	protected WorkflowDispatch() {
		super("workflow_dispatch");
	}
	
	public WorkflowDispatch inputs(Input... inputs) {
		return addInputs(this, inputs);
		
	}
	
	public static WorkflowDispatch $(){
		return new WorkflowDispatch();
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
visitor.visit(this, arg);
	}
	
}

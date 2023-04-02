package org.example.yy;

import org.example.collections.Inputs;
import org.example.visitor.Visitor;
import org.example.visitor.VoidVisitor;
import org.example.wrappers.Input;

public class WorkflowDispatch extends WorkflowEvent {
	
	protected WorkflowDispatch() {
		super("workflow_dispatch");
	}
	
	public WorkflowDispatch inputs(Input... inputs) {
		Inputs innerInputs = new Inputs();
		for (Input input : inputs) {
			innerInputs.add(input);
		}
		this.add(innerInputs);
		return this;
	}
	
	public static WorkflowDispatch $(){
		return new WorkflowDispatch();
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
visitor.visit(this, arg);
	}@Override
	public void accept(VoidVisitor visitor) {
		visitor.visit(this);
	}
	
}

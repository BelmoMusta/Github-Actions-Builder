package org.example.yy;

import org.example.visitor.Visitor;
import org.example.wrappers.Input;
import org.example.wrappers.Output;
import org.example.wrappers.Secret;
import org.example.yy.support.InputSupport;
import org.example.yy.support.OutputSupport;
import org.example.yy.support.SecretSupport;

public class WorkflowCall extends WorkflowEvent implements InputSupport, OutputSupport, SecretSupport {
	
	protected WorkflowCall() {
		super("workflow_call");
	}
	
	public WorkflowCall inputs(Input... inputs) {
		return addInputs(this, inputs);
	}
	
	public WorkflowCall secrets(Secret... secrets) {
		return addSecrets(this, secrets);
	}
	
	public WorkflowCall outputs(Output... inputs) {
		return addOutputs(this, inputs);
	}
	
	
	public static WorkflowCall $() {
		return new WorkflowCall();
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
	
}

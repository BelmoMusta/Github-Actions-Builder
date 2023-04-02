package org.example;

import org.example.visitor.Visitor;

public class DeploymentStatus extends WorkflowEvent {
	public DeploymentStatus() {
		super("deployment_status");
	}
	
	public static DeploymentStatus $() {
		return new DeploymentStatus();
	}
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
}

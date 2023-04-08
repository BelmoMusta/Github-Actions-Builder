package org.example.yy;

import org.example.visitor.Visitor;

public class DeploymentStatus extends WorkflowEvent {
	public DeploymentStatus() {
		super("deployment_status");
	}
	
	public static DeploymentStatus $() {
		return new DeploymentStatus();
	}
	
	@Override
	public <R> void accept(Visitor<R> visitor) {
		visitor.visit(this);
	}
}

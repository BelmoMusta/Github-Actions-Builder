package org.example.yy;

import org.example.visitor.Visitor;
import org.example.visitor.VoidVisitor;

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
	}@Override
	public void accept(VoidVisitor visitor) {
		visitor.visit(this);
	}
}

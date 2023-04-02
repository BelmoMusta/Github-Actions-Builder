package org.example;

import org.example.visitor.Visitor;

public class BranchProtectionRule extends WorkflowEventWithBranches {
	public BranchProtectionRule() {
		super("branch_protection_rule");
	}
	
	public static BranchProtectionRule $() {
		return new BranchProtectionRule();
	}
	
	public BranchProtectionRule types(BranchProtectionRule.Type... types) {
		return addTypes(this, types);
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
	
	public enum Type implements TypeI {
		
		CREATED,
		DELETED,
		EDITED,
		
		;
		
		@Override
		public String toString() {
			return super.toString().toLowerCase();
		}
	}
}

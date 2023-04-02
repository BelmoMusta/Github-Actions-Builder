package org.example.yy;

import org.example.visitor.Visitor;
import org.example.visitor.VoidVisitor;

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
	}@Override
	public void accept(VoidVisitor visitor) {
		visitor.visit(this);
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

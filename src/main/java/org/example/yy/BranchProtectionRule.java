package org.example.yy;

import org.example.visitor.Visitor;
import org.example.yy.support.TypesSupport;

public class BranchProtectionRule extends WorkflowEvent implements TypesSupport {
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
	public <R> void accept(Visitor<R> visitor) {
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

package org.example.yy;

import org.example.visitor.Visitor;
import org.example.yy.support.TypesSupport;

public class CheckRun extends WorkflowEvent implements TypesSupport {
	public CheckRun() {
		super("check_run");
	}
	
	public static CheckRun $() {
		return new CheckRun();
	}
	
	public CheckRun types(CheckRun.Type... types) {
		return addTypes(this, types);
	}
	
	@Override
	public <R> void accept(Visitor<R> visitor) {
		visitor.visit(this);
	}
	
	public enum Type implements TypeI {
		
		COMPLETED,
		CREATED,
		REQUESTED_ACTION,
		REREQUESTED,
		
		;
		
		@Override
		public String toString() {
			return super.toString().toLowerCase();
		}
	}
}

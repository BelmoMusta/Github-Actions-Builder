package org.example.yy;

import org.example.visitor.Visitor;
import org.example.visitor.VoidVisitor;
import org.example.wrappers.DashedNameQuotedValuePair;

public class Schedule extends WorkflowEvent {
	
	protected Schedule() {
		super("schedule");
	}
	
	public static Schedule $() {
		return new Schedule();
	}
	
	public Schedule cron(String... crons) {
		for (String cr : crons) {
			this.add(new DashedNameQuotedValuePair("cron", cr));
		}
		return this;
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
visitor.visit(this, arg);
	}@Override
	public void accept(VoidVisitor visitor) {
		visitor.visit(this);
	}
}

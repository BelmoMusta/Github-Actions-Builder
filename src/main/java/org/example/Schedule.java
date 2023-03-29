package org.example;

import org.example.visitor.Visitor;
import org.example.wrappers.DashedNameValuePair;

public class Schedule extends WorkflowEvent {
	
	protected Schedule() {
		super("schedule");
	}
	
	public static Schedule $() {
		return new Schedule();
	}
	
	public Schedule cron(String... crons) {
		for (String cr : crons) {
			this.add(new DashedNameValuePair("cron", cr));
		}
		return this;
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
}

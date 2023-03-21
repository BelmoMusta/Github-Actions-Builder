package org.example;

import org.example.wrappers.DashedNameValuePair;

public class Schedule extends WorkflowEvent {
	
	protected Schedule() {
		super("schedule");
	}
	
	public static Schedule $() {
		return new Schedule();
	}
	
	public static Schedule cron(String... crons) {
		final Schedule schedule = new Schedule();
		for (String cr : crons) {
			schedule.add(new DashedNameValuePair("cron", cr));
		}
		return schedule;
	}
}

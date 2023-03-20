package org.example;

import org.example.collections.Crons;
import org.example.wrappers.DashSingleElement;
import org.example.wrappers.Indentable;
import org.example.wrappers.NameValuePair;
import org.example.wrappers.SingleElement;

import java.util.Arrays;
import java.util.List;

public class Schedule extends WorkflowEvent {
	final Crons cron = new Crons();
	SingleElement name = new SingleElement("schedule");
	
	public static Schedule $() {
		return new Schedule();
	}
	
	public static Schedule cron(String... crones) {
		final Schedule schedule = new Schedule();
		for (String cr : crones) {
			NameValuePair cron = new NameValuePair("cron", cr);
			//cron.value = cr;
			schedule.cron.add(cron);
		}
		return schedule;
	}
	
	@Override
	public void setIndentLevel(int indentLvel) {
		super.setIndentLevel(indentLvel);
		name.setIndentLevel(getIndentLevel());
		cron.setIndentLevel(getIndentLevel() + 1);
	}
	
	@Override
	protected List<Indentable> getIndentables() {
		return Arrays.asList(name, cron);
	}
}

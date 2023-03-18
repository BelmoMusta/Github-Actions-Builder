package org.example;

import org.example.collections.Crons;
import org.example.wrappers.Indentable;
import org.example.wrappers.SimpleName;

import java.util.Arrays;
import java.util.List;

public class Schedule extends WorkflowEvent {
	final Crons cron = new Crons();
	SimpleName name = new SimpleName("schedule");
	
	public static Schedule $() {
		return new Schedule();
	}
	
	public static Schedule cron(String... types) {
		final Schedule schedule = new Schedule();
		for (String type : types) {
			Cron cron = new Cron();
			cron.value = type;
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

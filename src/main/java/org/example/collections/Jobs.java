package org.example.collections;

import org.example.Appender;
import org.example.Indentable;
import org.example.Job;

import java.util.ArrayList;
import java.util.List;

public class Jobs extends Indentable {
	private final List<Job> jobs = new ArrayList<>();
	
	public void add(Job job) {
		jobs.add(job);
	}
	
	@Override
	public void setIndentLevel(int indentLvel) {
		super.setIndentLevel(indentLvel);
		for (Job job : jobs) {
			job.setIndentLevel(getIndentLevel() + 1);
		}
	}
	
	@Override
	public String toString() {
		Appender appender = new Appender();
		appender.append("jobs: ");
		appender.newLine();
		for (Job job : jobs) {
			appender.indent(getIndentLevel());
			appender.append(job);
			appender.newLine();
		}
		//appender.newLine();
		return appender.toString();
	}
}

package org.example;

import org.example.collections.Steps;

import java.util.ArrayList;
import java.util.List;

public class Job extends Indentable {
	String name;
	String runsOn;
	
	List<String> neededJobs = new ArrayList<>();
	private Steps steps = new Steps();
	Container container;
	List<Service> services = new ArrayList<>();
	
	public static Job name(String name) {
		Job job = new Job();
		job.name = name;
		return job;
	}
	
	public Job runsOn(String s) {
		runsOn = s;
		return this;
	}
	
	public Job step(Step step) {
		steps.add(step);
		return this;
	}
	
	public Job needs(String name) {
		neededJobs.add(name);
		return this;
	}
	
	public Job container(Container container) {
		this.container = container;
		return this;
	}
	
	public Job service(Service service) {
		this.services.add(service);
		return this;
	}
	
	@Override
	public String toString() {
		steps.setIndentLevel(getIndentLevel() + 1);
		Appender appender = new Appender();
		appender.append(name)
				.append(":")
				.newLine();
		if (runsOn != null) {
			appender.indent(getIndentLevel() + 1);
			appender.append("runs_on: ")
					.append(runsOn)
					.newLine();
		}
		appender.append(steps);
		return appender.toString();
	}
}

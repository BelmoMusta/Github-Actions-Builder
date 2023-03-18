package org.example;

import org.example.collections.Environments;
import org.example.collections.Events;
import org.example.collections.Jobs;
import org.example.wrappers.NameValuePair;

public class Workflow {
	private NameValuePair name;
	private Events events = new Events();
	private Environments environments = new Environments();
	
	private Jobs jobs = new Jobs();
	
	public Workflow() {
	
	}
	
	@Override
	public String toString() {
		adaptIndentations();
		Appender sb = new Appender();
		sb.append(name);
		sb.newLine();
		sb.append(events);
		sb.append(environments);
		sb.append(jobs);
		
		return sb.toString();
	}
	
	private void adaptIndentations() {
		events.setIndentLevel(1);
		jobs.setIndentLevel(1);
		environments.setIndentLevel(1);
	}
	
	public static Workflow name(String name) {
		Workflow workflow = new Workflow();
		NameValuePair name_ = new NameValuePair("name", name);
		workflow.name = name_;
		
		return workflow;
	}
	
	public Workflow on(WorkflowEvent... events) {
		for (WorkflowEvent event : events) {
			this.events.add(event);
		}
		return this;
	}
	
	public Workflow env(Environment environment) {
		this.environments.add(environment);
		return this;
	}
	public Workflow env(String name, String value ) {
		Environment environment = new Environment(name, value);
		this.environments.add(environment);
		return this;
	}
	
	public Workflow job(Job job) {
		this.jobs.add(job);
		return this;
	}
	
	public Workflow job(String name) {
		Job job = new Job();
		job.name= name;
		this.jobs.add(job);
		return this;
	}
}

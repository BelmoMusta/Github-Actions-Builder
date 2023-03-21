package org.example;

import org.example.collections.AbstractCollection;
import org.example.collections.Environments;
import org.example.collections.Events;
import org.example.collections.Jobs;


public class Workflow extends AbstractCollection {
	private Events events = new Events();
	private Environments environments = new Environments();
	private Jobs jobs = new Jobs();
	
	protected Workflow(String name) {
		super(name, false);
		super.add(events);
		super.add(environments);
		super.add(jobs);
	}
	
	@Override
	public String toString() {
		setIndentLevel(0);
		return super.toString();
	}
	
	
	
	public static Workflow name(String name) {
		return new Workflow(name);
	}
	
	public Workflow on(WorkflowEvent... events) {
		for (WorkflowEvent event : events) {
			WorkflowEvent ev = this.events.findTag(event.getClass());
			if (ev == null) {
				this.events.add(event);
			} else {
			
			}
		}
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
}

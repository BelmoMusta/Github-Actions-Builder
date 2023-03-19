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
		super(name, true);
		super.add(events);
		super.add(environments);
		super.add(jobs);
	}
	
	@Override
	public String toString() {
		adaptIndentations();
		return super.toString();
	}
	
	private void adaptIndentations() {
		events.setIndentLevel(0);
		jobs.setIndentLevel(0);
		environments.setIndentLevel(0);
	}
	
	public static Workflow name(String name) {
		return new Workflow(name);
	}
	
	public Workflow on(WorkflowEvent... events) {
		for (WorkflowEvent event : events) {
			this.events.add(event);
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

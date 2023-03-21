package org.example;

import org.example.collections.AbstractCollection;
import org.example.collections.Environments;
import org.example.collections.Events;
import org.example.collections.Jobs;
import org.example.wrappers.Indentable;


public class Workflow extends AbstractCollection {
	
	protected Workflow(String name) {
		super(name, false);
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
		Events events_ = findTag(Events.class);
		if (events_ == null) {
			events_ = new Events();
			add(events_);
		}
		
		for (WorkflowEvent event : events) {
			WorkflowEvent ev = events_.findTag(event.getClass());
			if (ev == null) {
				events_.add(event);
			} else {
				System.err.println("WARNING : a workflow event of type '" + ev.name + "' exists");
			}
		}
		return this;
	}
	
	public Workflow env(String name, String value) {
		
		Environments environments = findTag(Environments.class);
		if (environments == null) {
			environments = new Environments();
			add(environments);
		}
		Environment environment = new Environment(name, value);
		environments.add(environment);
		return this;
	}
	
	public Workflow job(Job job) {
		Jobs jobs = findTag(Jobs.class);
		if (jobs == null) {
			jobs = new Jobs();
			add(jobs);
		}
		jobs.add(job);
		return this;
	}
}

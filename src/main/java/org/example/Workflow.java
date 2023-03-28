package org.example;

import org.example.collections.Environments;
import org.example.collections.Events;
import org.example.collections.Jobs;
import org.example.collections.Nodes;
import org.example.visitor.Visitor;

public class Workflow extends Nodes {
	
	protected Workflow(String name) {
		super(name, false);
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
	
	public Workflow jobs(Job... jobs) {
		Jobs innerJobs = findTag(Jobs.class);
		if (innerJobs == null) {
			innerJobs = new Jobs();
			add(innerJobs);
		}
		for (Job job : jobs) {
			innerJobs.add(job);
		}
		return this;
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg );
	}
}

package org.example.yy;

import org.example.collections.Events;
import org.example.collections.Jobs;
import org.example.collections.Nodes;
import org.example.visitor.Visitor;
import org.example.visitor.VoidVisitor;
import org.example.wrappers.LabeledName;

public class Workflow extends Nodes {
	
	protected Workflow(String name) {
		super(name, false);
	}
	
	public Workflow name(String name) {
		this.name = new LabeledName(name);
		return this;
	}
	
	public static Workflow $() {
		return new Workflow(null);
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
		return getEnv(this, name, value);
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
visitor.visit(this, arg);
	}@Override
	public void accept(VoidVisitor visitor) {
		visitor.visit(this);
	}
}

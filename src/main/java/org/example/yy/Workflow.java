package org.example.yy;

import org.example.collections.Events;
import org.example.collections.Jobs;
import org.example.collections.Nodes;
import org.example.visitor.Visitor;
import org.example.wrappers.leaves.LabeledName;
import org.example.yy.support.ElementsSupport;
import org.example.yy.support.EnvSupport;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Workflow extends Nodes implements EnvSupport, ElementsSupport {
	
	protected Workflow() {
		super(null, false);
	}
	
	public Workflow name(String name) {
		this.name = new LabeledName(name);
		return this;
	}
	
	public static Workflow $() {
		return new Workflow();
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
		addNodes(this, Jobs.class, Jobs::new, jobs);
		return this;
	}
	
	
	
	@Override
	public <R> void accept(Visitor<R> visitor) {
		visitor.visit(this);
	}
}

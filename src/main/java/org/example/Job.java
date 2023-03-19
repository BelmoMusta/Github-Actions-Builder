package org.example;

import org.example.collections.AbstractCollection;
import org.example.collections.Needs;
import org.example.collections.Steps;
import org.example.wrappers.NameValuePair;
import org.example.wrappers.SingleElement;

public class Job extends AbstractCollection {
	
 	private Needs needs = new Needs();
	private Steps steps = new Steps();
	
	private Container container = new Container();
 
	protected Job(String name) {
		super(name);
	}
	
	public static Job name(String name) {
		return new Job(name);
	}
	
	public Job runsOn(String s) {
		add(new NameValuePair("runs-on", s));
 		return this;
	}
	
	@Override
	public void setIndentLevel(int indentLvel) {
		super.setIndentLevel(indentLvel);
		needs.setIndentLevel(getIndentLevel() + 1);
		container.setIndentLevel(getIndentLevel() + 1);
	}
	
	public Job step(Step step) {
		if (steps.isEmpty()) {
			steps.setIndentLevel(getIndentLevel() + 1);
			add(steps);
		}
		steps.add(step);
		return this;
	}
	
	public Job needs(String name) {
		needs.add(new SingleElement(name));
		add(needs);
		return this;
	}
	
	public Job container(Container container) {
		this.container = container;
		return this;
	}
	
	public Job service(Service service) { // TODO
 		return this;
	}
}

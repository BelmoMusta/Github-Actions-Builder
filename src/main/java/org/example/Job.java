package org.example;

import org.example.collections.AbstractCollection;
import org.example.collections.Steps;
import org.example.wrappers.NameValuePair;

public class Job extends AbstractCollection {
	
	public Job(String name) {
		super(name);
	}
	
	public static Job name(String name) {
		return new Job(name);
	}
	
	public Job runsOn(String s) {
		add(new NameValuePair("runs-on", s));
 		return this;
	}
	
	public Job step(Step step) {
		Steps steps =findTag(Steps.class);
		if(steps == null) {
			steps = new Steps();
			add(steps);
		}
//		if (steps.isEmpty()) {
//			steps.setIndentLevel(getIndentLevel() + 1);
//			add(steps);
//		}
		steps.add(step);
		return this;
	}
	
	public Job needs(String name) {
 		add(new NameValuePair("needs", name));
		return this;
	}
	
	public Job container(Container container) {
		this.add(container);
		return this;
	}
	
	public Job service(Service service) { // TODO
 		return this;
	}
}

package org.example;

import org.example.collections.Needs;
import org.example.collections.Outputs;
import org.example.collections.SecondLevel;
import org.example.collections.Steps;
import org.example.wrappers.DashSingleElement;
import org.example.wrappers.NameValuePair;
import org.example.wrappers.Output;

public class Job extends SecondLevel {
	
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
		Steps steps = findTag(Steps.class);
		if (steps == null) {
			steps = new Steps();
			add(steps);
		}
		steps.add(step);
		return this;
	}
	
	public Job needs(String... jobs) {
		Needs needs = findTag(Needs.class);
		if (needs == null) {
			needs = new Needs();
			add(needs);
		}
		for (String job : jobs) {
			needs.add(new DashSingleElement(job));
			
		}
		return this;
	}
	
	public Job if_(String condition) {
		add(new NameValuePair("if", condition));
		return this;
	}
	
	
	public Job outputs(Output... outputs) {
		
		Outputs outs = new Outputs();
		for (Output input : outputs) {
			outs.add(input);
		}
		add(outs);
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

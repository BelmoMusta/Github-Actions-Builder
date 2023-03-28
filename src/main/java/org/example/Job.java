package org.example;

import org.example.collections.Needs;
import org.example.collections.Outputs;
import org.example.collections.Services;
import org.example.collections.Steps;
import org.example.collections.SubNode;
import org.example.visitor.Visitor;
import org.example.wrappers.DashSingleElement;
import org.example.wrappers.LabeledName;
import org.example.wrappers.NameValuePair;
import org.example.wrappers.Output;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Job extends SubNode {
	
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
	
	public Job id(String id) {
		class Id extends NameValuePair {
			Id(String id) {
				super("id", id);
			}
		}
		Id existingId = findTag(Id.class);
		if (existingId == null) {
			Id idToBe = new Id(id);
			add(idToBe);
		}
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
	
	private Job needs(List<String> jobs) {
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
	
	public Job needs(String... jobs) {
		return needs(Arrays.asList(jobs));
	}
	
	public Job needs(Job... jobs) {
		List<String> collectedJobs = Arrays.stream(jobs)
				.map(Job::get)
				.collect(Collectors.toList());
		return needs(collectedJobs);
		
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
	
	public Job service(Service... services) {
		Services innerServices = findTag(Services.class);
		if (innerServices == null) {
			innerServices = new Services();
			add(innerServices);
		}
		for (Service service : services) {
			innerServices.add(service);
		}
		return this;
	}
	
	public Job explicitName() {
		String name = super.name.get();
		add(new LabeledName(name));
		return this;
	}
	
	@Override
	public String get() {
		return name.get();
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
}

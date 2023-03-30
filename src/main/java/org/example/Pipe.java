package org.example;

import org.example.collections.Environments;
import org.example.collections.Needs;
import org.example.collections.SubNode;
import org.example.visitor.Visitor;
import org.example.wrappers.DashSingleElement;
import org.example.wrappers.SimpleSingleElement;
import org.example.wrappers.SingleElement;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Pipe extends SubNode {
	
	public Pipe(String name) {
		super(name);
	}
	
	public Pipe() {
		super("null");
	}
	
	public static Pipe $() {
		return new Pipe();
	}
	
	public Pipe entries(String... entries) {
		for (String entry : entries) {
			add(new SimpleSingleElement(entry));
		}
		return this;
	}
	
	private Pipe needs(List<String> jobs) {
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
	
	public Pipe needs(String... jobs) {
		return needs(Arrays.asList(jobs));
	}
	
	public Pipe needs(Pipe... jobs) {
		List<String> collectedJobs = Arrays.stream(jobs)
				.map(Pipe::get)
				.collect(Collectors.toList());
		return needs(collectedJobs);
		
	}
	
	public Pipe env(String name, String value) {
		
		Environments environments = findTag(Environments.class);
		if (environments == null) {
			environments = new Environments();
			add(environments);
		}
		Environment environment = new Environment(name, value);
		environments.add(environment);
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

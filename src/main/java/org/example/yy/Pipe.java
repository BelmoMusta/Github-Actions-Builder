package org.example.yy;

import org.example.collections.Needs;
import org.example.collections.Nodes;
import org.example.visitor.Visitor;
import org.example.visitor.VoidVisitor;
import org.example.wrappers.DashSingleElement;
import org.example.wrappers.SimpleEntry;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Pipe extends Nodes {
	
	public Pipe() {
		super(null); // not needed
	}
	
	public static Pipe $() {
		return new Pipe();
	}
	
	public Pipe entries(String... entries) {
		for (String entry : entries) {
			add(new SimpleEntry(entry));
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
		return getEnv(this, name, value);
	}
	
	@Override
	public String get() {
		return name.get();
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
visitor.visit(this, arg);
	}@Override
	public void accept(VoidVisitor visitor) {
		visitor.visit(this);
	}
}

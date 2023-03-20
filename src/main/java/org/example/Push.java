package org.example;

import org.example.collections.Branches;
import org.example.collections.Paths;
import org.example.collections.Tags;
import org.example.wrappers.DashQuotedSingleElement;
import org.example.wrappers.Indentable;
import org.example.wrappers.SingleElement;

import java.util.Arrays;
import java.util.List;

public class Push extends WorkflowEvent {
	final Branches branches = new Branches();
	final Paths paths = new Paths();
	final Tags tags = new Tags();
	SingleElement name = new SingleElement("push");
	
	
	public static Push $() {
		return new Push();
	}
	
	public static Push branches(String... branches) {
		final Push push = new Push();
		for (String branch : branches) {
			DashQuotedSingleElement br = new DashQuotedSingleElement(branch);
			push.branches.add(br);
		}
		return push;
	}
	
	public Push paths(String ... paths){
		for (String path : paths) {
			this.paths.add(new DashQuotedSingleElement(path));
		}
		
		return this;
	}
	
	public Push tags(String ... tags){
		for (String tag : tags) {
			this.tags.add(new DashQuotedSingleElement(tag));
		}
		
		return this;
	}
	
	@Override
	public void setIndentLevel(int indentLvel) {
		super.setIndentLevel(indentLvel);
		name.setIndentLevel(getIndentLevel());
		branches.setIndentLevel(getIndentLevel() + 1);
		paths.setIndentLevel(getIndentLevel() + 1);
		tags.setIndentLevel(getIndentLevel() + 1);
	}
	
	
	@Override
	protected List<Indentable> getIndentables() {
		return Arrays.asList(name,
				branches,
				paths,
				tags);
	}
}

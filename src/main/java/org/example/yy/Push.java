package org.example.yy;

import org.example.visitor.Visitor;
import org.example.visitor.VoidVisitor;
import org.example.yy.support.BranchesSupport;
import org.example.yy.support.TagsSupport;

public class Push extends WorkflowEvent implements BranchesSupport, TagsSupport,
		PathsSupport {
	public Push() {
		super("push");
	}
	
	public static Push $() {
		return new Push();
	}
	
	public Push paths(String... paths) {
		return addPaths(this, paths);
	}
	
	public Push branches(String... branches) {
		return addBranches(this, branches);
	}
	
	public Push tags(String... tags) {
		return addTags(this, tags);
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
	
	@Override
	public void accept(VoidVisitor<?> visitor) {
		visitor.visit(this);
	}
}

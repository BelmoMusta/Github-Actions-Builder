package org.example.yy;

import org.example.visitor.Visitor;
import org.example.yy.support.BranchesIgnoreSupport;
import org.example.yy.support.BranchesSupport;
import org.example.yy.support.PathsIgnoreSupport;
import org.example.yy.support.TagsIgnoreSupport;
import org.example.yy.support.TagsSupport;

public class Push extends WorkflowEvent implements BranchesSupport,
		BranchesIgnoreSupport,
		TagsSupport,
		TagsIgnoreSupport,
		PathsSupport,
		PathsIgnoreSupport {
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
	
	public Push branchesIgnore(String... branches) {
		return addBranchesIgnore(this, branches);
	}
	
	public Push tags(String... tags) {
		return addTags(this, tags);
	}
	
	public Push tagsIgnore(String... tags) {
		return addTagsIgnore(this, tags);
	}
	
	public Push pathsIgnore(String... paths) {
		return addPathsIgnore(this, paths);
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
	
}

package org.example.yy;

import org.example.visitor.Visitor;
import org.example.visitor.VoidVisitor;
import org.example.yy.support.BranchesIgnoreSupport;
import org.example.yy.support.BranchesSupport;
import org.example.yy.support.PathsIgnoreSupport;

public class PullRequestTarget extends WorkflowEvent implements
		BranchesSupport,
		BranchesIgnoreSupport,
		PathsSupport,
		PathsIgnoreSupport {
	
	protected PullRequestTarget() {
		super("pull_request_target");
	}
	
	public static PullRequestTarget $() {
		return new PullRequestTarget();
	}
	
	public PullRequestTarget branches(String... branches) {
		return addBranches(this, branches);
	}
	
	public PullRequestTarget branchesIgnore(String... branches) {
		return addBranchesIgnore(this, branches);
	}
	
	public PullRequestTarget paths(String... paths) {
		return addPaths(this, paths);
	}
	public PullRequestTarget pathsIgnore(String... paths) {
		return addPathsIgnore(this, paths);
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

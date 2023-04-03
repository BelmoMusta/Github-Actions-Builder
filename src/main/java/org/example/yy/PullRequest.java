package org.example.yy;

import org.example.visitor.Visitor;
import org.example.visitor.VoidVisitor;
import org.example.yy.support.BranchesIgnoreSupport;
import org.example.yy.support.BranchesSupport;
import org.example.yy.support.PathsIgnoreSupport;
import org.example.yy.support.TagsSupport;
import org.example.yy.support.TypesSupport;

public class PullRequest extends WorkflowEvent implements BranchesSupport,
		TagsSupport,
		PathsSupport,
		BranchesIgnoreSupport,
		PathsIgnoreSupport, TypesSupport {
	
	protected PullRequest() {
		super("pull_request");
	}
	
	public static PullRequest $() {
		return new PullRequest();
	}
	
	public PullRequest types(Type... types) {
		return addTypes(this, types);
	}
	
	public PullRequest paths(String... paths) {
		return addPaths(this, paths);
	}
	
	public PullRequest pathsIgnore(String... paths) {
		return addPathsIgnore(this, paths);
	}
	
	public PullRequest tags(String... paths) {
		return addTags(this, paths);
	}
	
	public PullRequest branches(String... branches) {
		return addBranches(this, branches);
	}
	
	public PullRequest branchesIgnore(String... branches) {
		return addBranchesIgnore(this, branches);
	}
	
	public enum Type implements TypeI {
		ASSIGNED,
		AUTO_MERGE_DISABLED,
		AUTO_MERGE_ENABLED,
		CLOSED,
		CONVERTED_TO_DRAFT,
		EDITED,
		LABELED,
		LOCKED,
		OPENED,
		READY_FOR_REVIEW,
		REOPENED,
		REVIEW_REQUESTED,
		REVIEW_REQUEST_REMOVED,
		SYNCHRONIZE,
		UNASSIGNED,
		UNLABELED,
		UNLOCKED,
		
		;
		@Override
		public String toString() {
			return super.toString().toLowerCase();
		}
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

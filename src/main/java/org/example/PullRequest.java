package org.example;

import org.example.collections.Paths;
import org.example.collections.Types;
import org.example.visitor.Visitor;
import org.example.wrappers.DashQuotedSingleElement;
import org.example.wrappers.DashSingleElement;

public class PullRequest extends WorkflowEventWithBranches {
	
	protected PullRequest(String... branches) {
		super("pull_request", branches);
	}
	
	public static PullRequest $(String... branches) {
		return new PullRequest(branches);
	}
	
	public PullRequest types(Type... types) {
		Types innerTypes = new Types();
		for (Type type : types) {
			DashSingleElement element = new DashSingleElement(type.toString());
			innerTypes.add(element);
		}
		this.add(innerTypes);
		return this;
	}
	
	public PullRequest paths(String... paths) {
		final Paths innerPaths = new Paths();
		for (String path : paths) {
			innerPaths.add(new DashQuotedSingleElement(path));
		}
		add(innerPaths);
		return this;
	}
	
	public static PullRequest branches(String... branches) {
		return new PullRequest(branches);
	}
	public enum Type {
		ASSIGNED,
		UNASSIGNED,
		LABELED,
		UNLABELED,
		OPENED,
		EDITED,
		CLOSED,
		REOPENED,
		SYNCHRONIZE,
		CONVERTED_TO_DRAFT,
		READY_FOR_REVIEW,
		LOCKED,
		UNLOCKED,
		REVIEW_REQUESTED,
		REVIEW_REQUEST_REMOVED,
		AUTO_MERGE_ENABLED,
		AUTO_MERGE_DISABLED;
		
		@Override
		public String toString() {
			return super.toString().toLowerCase();
		}
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
}

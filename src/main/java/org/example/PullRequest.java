package org.example;

import org.example.collections.Branches;
import org.example.collections.Types;
import org.example.wrappers.DashQuotedSingleElement;
import org.example.wrappers.DashSingleElement;

public class PullRequest extends WorkflowEvent {
	final Types types = new Types();
	protected PullRequest() {
		super("pull_request");
	}
	
	public static PullRequest $() {
		return new PullRequest();
	}
	
	public static PullRequest types(String... types) {
		final PullRequest pullRequest = new PullRequest();
		Types innerTypes = new Types();
		for (String type : types) {
			DashSingleElement element = new DashSingleElement(type);
			innerTypes.add(element);
		}
		pullRequest.add(innerTypes);
		return pullRequest;
	}
	
	public PullRequest branches(String... branches) {
		final Branches innerBranches = new Branches();
		for (String branch : branches) {
			innerBranches.add(new DashQuotedSingleElement(branch));
		}
		add(innerBranches);
		return this;
	}
}

package org.example.visitor;

import org.example.collections.Branches;
import org.example.collections.BranchesIgnore;
import org.example.collections.Environments;
import org.example.collections.Events;
import org.example.collections.Inputs;
import org.example.collections.Jobs;
import org.example.collections.Needs;
import org.example.collections.Options;
import org.example.collections.Outputs;
import org.example.collections.Paths;
import org.example.collections.Ports;
import org.example.collections.Services;
import org.example.collections.Steps;
import org.example.collections.Tags;
import org.example.collections.TagsIgnore;
import org.example.collections.Types;
import org.example.collections.Volumes;
import org.example.collections.Withs;
import org.example.wrappers.DashQuotedSingleElement;
import org.example.wrappers.DashSingleElement;
import org.example.wrappers.DashedId;
import org.example.wrappers.DashedNameQuotedValuePair;
import org.example.wrappers.DashedNameValuePair;
import org.example.wrappers.InOut;
import org.example.wrappers.InOutElement;
import org.example.wrappers.Input;
import org.example.wrappers.LabeledDashedName;
import org.example.wrappers.LabeledName;
import org.example.wrappers.NameValuePair;
import org.example.wrappers.Output;
import org.example.wrappers.SimpleEntry;
import org.example.wrappers.SingleElement;
import org.example.yy.BranchProtectionRule;
import org.example.yy.CheckRun;
import org.example.yy.CheckSuite;
import org.example.yy.Container;
import org.example.yy.Create;
import org.example.yy.Delete;
import org.example.yy.Deployment;
import org.example.yy.DeploymentStatus;
import org.example.yy.Discussion;
import org.example.yy.DiscussionComment;
import org.example.yy.Environment;
import org.example.yy.Fork;
import org.example.yy.Gollum;
import org.example.yy.Image;
import org.example.yy.IssueComment;
import org.example.yy.Issues;
import org.example.yy.Job;
import org.example.yy.Label;
import org.example.yy.MergeGroup;
import org.example.yy.Milestone;
import org.example.yy.Pipe;
import org.example.yy.PullRequest;
import org.example.yy.PullRequestComment;
import org.example.yy.PullRequestReview;
import org.example.yy.PullRequestReviewComment;
import org.example.yy.PullRequestTarget;
import org.example.yy.Push;
import org.example.yy.Release;
import org.example.yy.Schedule;
import org.example.yy.Service;
import org.example.yy.Step;
import org.example.yy.Volume;
import org.example.yy.Workflow;
import org.example.yy.WorkflowDispatch;

public abstract class AbstractVoidVisitor<R> implements VoidVisitor<R> {
	
	
	@Override
	public void visit(Branches branches) {
	}
	
	@Override
	public void visit(BranchesIgnore branchesIgnore) {
	}
	
	@Override
	public void visit(TagsIgnore tagsIgnore) {
	
	}
	
	@Override
	public void visit(Environments environments) {
	}
	@Override
	public void visit(Withs withs) {
	}
	
	@Override
	public void visit(Events events) {
	}
	
	@Override
	public void visit(Fork fork) {
	
	}
	@Override
	public void visit(Gollum gollum) {
	
	}
	
	@Override
	public void visit(Inputs inputs) {
	}
	
	@Override
	public  void visit(Pipe pipe){
	}
	
	@Override
	public void visit(Jobs jobs) {
	}
	
	@Override
	public void visit(Needs needs) {
	}
	
 
	@Override
	public void visit(Options options) {
	}
	
	@Override
	public void visit(Outputs outputs) {
	}
	
	@Override
	public void visit(Paths paths) {
	}
	
	@Override
	public void visit(Ports ports) {
	}
	
	@Override
	public void visit(Services services) {
	}
	
	@Override
	public void visit(Steps steps) {
	}
	
	@Override
	public void visit(Tags tags) {
	}
	
	@Override
	public void visit(Types types) {
	}
	
	@Override
	public void visit(Volumes volumes) {
	}
	
	@Override
	public void visit(DashedNameQuotedValuePair dashedNameQuotedValuePair) {
	}
	
	@Override
	public  void visit(DashedNameValuePair dashedNameQuotedValuePair){
	
	}
	
	@Override
	public void visit(DashQuotedSingleElement dashQuotedSingleElement) {
	}
	
	@Override
	public void visit(DashSingleElement dashSingleElement) {
	}
	
	@Override
	public void visit(InOut inOut) {
	}
	
	@Override
	public void visit(InOutElement<?> inOutElement) {
	}
	
	@Override
	public void visit(Input input) {
	}
	
	@Override
	public void visit(LabeledDashedName labeledDashedName) {
	}
	
	@Override
	public void visit(LabeledName labeledName) {
	}
	
	@Override
	public void visit(NameValuePair nameValuePair) {
	}
	
	
	@Override
	public void visit(Output output) {
	}
	
	@Override
	public void visit(SingleElement singleElement) {
	}
	
	@Override
	public void visit(SimpleEntry simpleEntry) {
	
	}
	
	
	@Override
	public void visit(Container container) {
	}
	
	@Override
	public void visit(Environment environment) {
	}
	
	@Override
	public void visit(Image image) {
	}
	
	@Override
	public void visit(IssueComment issueComment) {
	
	}
	@Override
	public void visit(Issues issues) {
	
	}
	
	@Override
	public void visit(Label label) {
	
	}
	
	@Override
	public void visit(MergeGroup mergeGroup) {
	
	}
	
	@Override
	public void visit(Milestone milestone) {
	
	}
	
	@Override
	public void visit(PullRequestComment pullRequestComment) {
	
	}
	
	@Override
	public void visit(PullRequestReview pullRequestReview) {
	
	}
	
	@Override
	public void visit(PullRequestReviewComment pullRequestReviewComment) {
	
	}
	
	@Override
	public void visit(Job job) {
	}
	
	@Override
	public void visit(PullRequest pullRequest) {
	}
	
	@Override
	public void visit(PullRequestTarget pullRequestTarget) {
	}
	
	@Override
	public void visit(Push push) {
	}
	
	@Override
	public void visit(Release release) {
	
	}
	@Override
	public void visit(Delete release) {
	
	}
	
	@Override
	public void visit(DeploymentStatus deploymentStatus) {
	
	}
	@Override
	public void visit(Discussion discussion) {
	
	}
	
	@Override
	public void visit(DiscussionComment discussionComment) {
 	}
	
	@Override
	public R getFinalResult() {
		return null;
	}
	
	@Override
	public void visit(BranchProtectionRule branchProtectionRule) {
	
	}
	
	@Override
	public void visit(CheckRun checkRun) {
	
	}
	@Override
	public void visit(Create create) {
	
	}
	@Override
	public void visit(CheckSuite checkSuite) {
	
	}
	@Override
	public void visit(Deployment deployment) {
	
	}
	
	@Override
	public void visit(DashedId dashedId) {
	}
	
	@Override
	public void visit(Schedule schedule) {
	}
	
	@Override
	public void visit(Service service) {
	}
	
	@Override
	public void visit(Step step) {
	}
	
	@Override
	public void visit(Volume volume) {
	}
	
	@Override
	public void visit(Workflow workflow) {
	}
	
	@Override
	public void visit(WorkflowDispatch workflowDispatch) {
	}
	
}

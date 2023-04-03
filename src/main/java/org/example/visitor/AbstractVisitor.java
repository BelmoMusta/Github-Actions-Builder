package org.example.visitor;

import org.example.collections.Branches;
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
import org.example.wrappers.Node;
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
import org.example.yy.Pipe;
import org.example.yy.PullRequest;
import org.example.yy.PullRequestTarget;
import org.example.yy.Push;
import org.example.yy.Release;
import org.example.yy.Schedule;
import org.example.yy.Service;
import org.example.yy.Step;
import org.example.yy.Volume;
import org.example.yy.Workflow;
import org.example.yy.WorkflowDispatch;

import java.util.Collection;

public abstract class AbstractVisitor<A> implements Visitor<A> {
	
	
	protected abstract void visitChildren(Collection<? extends Node> children, A arg, boolean addNewLine);
	
	@Override
	public void visit(Branches branches, A arg) {
	}
	
	@Override
	public void visit(Environments environments, A arg) {
	}
	@Override
	public void visit(Withs withs, A arg) {
	}
	
	@Override
	public void visit(Events events, A arg) {
	}
	
	@Override
	public void visit(Inputs inputs, A arg) {
	}
	
	@Override
	public  void visit(Pipe pipe, A arg){
	}
	
	@Override
	public void visit(Jobs jobs, A arg) {
	}
	
	@Override
	public void visit(Needs needs, A arg) {
	}
	
 
	@Override
	public void visit(Options options, A arg) {
	}
	
	@Override
	public void visit(Outputs outputs, A arg) {
	}
	
	@Override
	public void visit(Paths paths, A arg) {
	}
	
	@Override
	public void visit(Ports ports, A arg) {
	}
	
	@Override
	public void visit(Services services, A arg) {
	}
	
	@Override
	public void visit(Steps steps, A arg) {
	}
	
	@Override
	public void visit(Tags tags, A arg) {
	}
	
	@Override
	public void visit(Types types, A arg) {
	}
	
	@Override
	public void visit(Volumes volumes, A arg) {
	}
	
	@Override
	public void visit(DashedNameQuotedValuePair dashedNameQuotedValuePair, A arg) {
	}
	
	@Override
	public  void visit(DashedNameValuePair dashedNameQuotedValuePair, A arg){
	
	}
	
	@Override
	public void visit(DashQuotedSingleElement dashQuotedSingleElement, A arg) {
	}
	
	@Override
	public void visit(DashSingleElement dashSingleElement, A arg) {
	}
	
	@Override
	public void visit(InOut inOut, A arg) {
	}
	
	@Override
	public void visit(InOutElement<?> inOutElement, A arg) {
	}
	
	@Override
	public void visit(Input input, A arg) {
	}
	
	@Override
	public void visit(LabeledDashedName labeledDashedName, A arg) {
	}
	
	@Override
	public void visit(LabeledName labeledName, A arg) {
	}
	
	@Override
	public void visit(NameValuePair nameValuePair, A arg) {
	}
	
	
	@Override
	public void visit(Output output, A arg) {
	}
	
	@Override
	public void visit(SingleElement singleElement, A arg) {
	}
	
	@Override
	public void visit(SimpleEntry simpleEntry, A arg) {
	
	}
	
	
	@Override
	public void visit(Container container, A arg) {
	}
	
	@Override
	public void visit(Environment environment, A arg) {
	}
	
	@Override
	public void visit(Image image, A arg) {
	}
	
	@Override
	public void visit(Job job, A arg) {
	}
	
	@Override
	public void visit(PullRequest pullRequest, A arg) {
	}
	
	@Override
	public void visit(PullRequestTarget pullRequestTarget, A arg) {
	}
	
	@Override
	public void visit(Push push, A arg) {
	}
	
	@Override
	public void visit(Release release, A arg) {
	
	}
	@Override
	public void visit(Delete release, A arg) {
	
	}
	
	@Override
	public void visit(DeploymentStatus deploymentStatus, A arg) {
	
	}
	@Override
	public void visit(Discussion discussion, A arg) {
	
	}
	
	@Override
	public void visit(DiscussionComment discussionComment, A arg) {
 	}
	@Override
	public void visit(BranchProtectionRule branchProtectionRule, A arg) {
	
	}
	
	@Override
	public void visit(CheckRun checkRun, A arg) {
	
	}
	@Override
	public void visit(Create create, A arg) {
	
	}
	
	@Override
	public void visit(Fork fork, A arg) {
	
	}
	@Override
	public void visit(Gollum fork, A arg) {
	
	}
	
	@Override
	public void visit(IssueComment issueComment, A arg) {
	
	}
	
	@Override
	public void visit(Issues issueComment, A arg) {
	
	}
	@Override
	public void visit(Label issueComment, A arg) {
	
	}
	
	@Override
	public void visit(CheckSuite checkSuite, A arg) {
	
	}
	@Override
	public void visit(Deployment deployment, A arg) {
	
	}
	
	@Override
	public void visit(DashedId dashedId, A arg) {
	}
	
	@Override
	public void visit(Schedule schedule, A arg) {
	}
	
	@Override
	public void visit(Service service, A arg) {
	}
	
	@Override
	public void visit(Step step, A arg) {
	}
	
	@Override
	public void visit(Volume volume, A arg) {
	}
	
	@Override
	public void support(Visitor<A> anotherVisitor) {
	
	}
	
	@Override
	public void visit(Workflow workflow, A arg) {
	}
	
	@Override
	public void visit(WorkflowDispatch workflowDispatch, A arg) {
	}
	
}

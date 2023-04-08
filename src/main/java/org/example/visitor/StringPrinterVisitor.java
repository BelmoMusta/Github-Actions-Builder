package org.example.visitor;

import org.example.collections.Branches;
import org.example.collections.BranchesIgnore;
import org.example.collections.Environments;
import org.example.collections.Events;
import org.example.collections.Inputs;
import org.example.collections.Jobs;
import org.example.collections.Needs;
import org.example.collections.Nodes;
import org.example.collections.Options;
import org.example.collections.Outputs;
import org.example.collections.Paths;
import org.example.collections.PathsIgnore;
import org.example.collections.Ports;
import org.example.collections.Secrets;
import org.example.collections.Services;
import org.example.collections.Steps;
import org.example.collections.Tags;
import org.example.collections.TagsIgnore;
import org.example.collections.Types;
import org.example.collections.Volumes;
import org.example.collections.Withs;
import org.example.collections.Workflows;
import org.example.wrappers.leaves.Credentials;
import org.example.wrappers.leaves.DashQuotedSingleElement;
import org.example.wrappers.leaves.DashSingleElement;
import org.example.wrappers.leaves.DashedId;
import org.example.wrappers.leaves.DashedNameQuotedValuePair;
import org.example.wrappers.leaves.DashedNameValuePair;
import org.example.wrappers.leaves.InOut;
import org.example.wrappers.leaves.InOutElement;
import org.example.wrappers.leaves.Input;
import org.example.wrappers.leaves.LabeledDashedName;
import org.example.wrappers.leaves.LabeledName;
import org.example.wrappers.leaves.NameValuePair;
import org.example.wrappers.Node;
import org.example.wrappers.leaves.Output;
import org.example.wrappers.leaves.Secret;
import org.example.wrappers.leaves.SimpleEntry;
import org.example.wrappers.leaves.SingleElement;
import org.example.yy.BranchProtectionRule;
import org.example.yy.CheckRun;
import org.example.yy.CheckSuite;
import org.example.yy.Concurrency;
import org.example.yy.Container;
import org.example.yy.Create;
import org.example.yy.Cron;
import org.example.yy.Defaults;
import org.example.yy.Delete;
import org.example.yy.Deployment;
import org.example.yy.DeploymentStatus;
import org.example.yy.Discussion;
import org.example.yy.DiscussionComment;
import org.example.yy.Environment;
import org.example.yy.Fork;
import org.example.yy.Gollum;
import org.example.yy.IssueComment;
import org.example.yy.Issues;
import org.example.yy.Job;
import org.example.yy.Label;
import org.example.yy.MergeGroup;
import org.example.yy.Milestone;
import org.example.yy.PageBuild;
import org.example.yy.Permissions;
import org.example.yy.Pipe;
import org.example.yy.Project;
import org.example.yy.ProjectCard;
import org.example.yy.ProjectColumn;
import org.example.yy.Public;
import org.example.yy.PullRequest;
import org.example.yy.PullRequestComment;
import org.example.yy.PullRequestReview;
import org.example.yy.PullRequestReviewComment;
import org.example.yy.PullRequestTarget;
import org.example.yy.Push;
import org.example.yy.RegistryPackage;
import org.example.yy.Release;
import org.example.yy.RepositoryDispatch;
import org.example.yy.Run;
import org.example.yy.Schedule;
import org.example.yy.Service;
import org.example.yy.Status;
import org.example.yy.Step;
import org.example.yy.Volume;
import org.example.yy.Watch;
import org.example.yy.Workflow;
import org.example.yy.WorkflowCall;
import org.example.yy.WorkflowDispatch;
import org.example.yy.WorkflowRun;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StringPrinterVisitor implements Visitor<String> {
	
	private final Appender appender_ = new Appender();
	
	@Override
	public void visit(Concurrency concurrency) {
		refactored(concurrency);
	}
	
	@Override
	public void visit(Credentials credentials) {
		visitInOut(credentials);
	}
	
	@Override
	public void visit(Defaults defaults) {
		refactored(defaults);
		
	}
	
	@Override
	public void visit(Run run) {
		refactored(run);
		
	}
	
	@Override
	public void visit(Permissions permissions) {
		refactored(permissions);
		
	}
	
	@Override
	public void visit(Workflow workflow) {
		workflow.name.accept(this);
		visitChildren(workflow.children, appender_, true);
		
	}
	
	@Override
	public void visit(Workflows workflows) {
		refactored(workflows);
		
	}
	
	@Override
	public void visit(Events events) {
		refactored(events);
		
	}
	
	@Override
	public void visit(Push push) {
		refactored(push);
		
	}
	
	@Override
	public void visit(Release release) {
		refactored(release);
		
	}
	
	@Override
	public void visit(Delete delete) {
		refactored(delete);
		
	}
	
	@Override
	public void visit(DiscussionComment discussionComment) {
		refactored(discussionComment);
		
	}
	
	@Override
	public void visit(DeploymentStatus deploymentStatus) {
		refactored(deploymentStatus);
		
	}
	
	@Override
	public void visit(Discussion discussion) {
		refactored(discussion);
		
	}
	
	@Override
	public void visit(BranchProtectionRule branchProtectionRule) {
		refactored(branchProtectionRule);
		
	}
	
	public void refactored(Nodes nodes) {
		nodes.name.accept(this);
		appender_.increaseIndent();
		visitChildren(nodes.children, appender_, true);
		appender_.decreaseIndent();
	}
	
	@Override
	public void visit(CheckRun checkRun) {
		refactored(checkRun);
		
	}
	
	@Override
	public void visit(Create create) {
		refactored(create);
		
	}
	
	@Override
	public void visit(Fork fork) {
		refactored(fork);
		
	}
	
	@Override
	public void visit(Gollum fork) {
		refactored(fork);
		
	}
	
	@Override
	public void visit(IssueComment issueComment) {
		refactored(issueComment);
		
	}
	
	@Override
	public void visit(Issues issues) {
		refactored(issues);
		
	}
	
	@Override
	public void visit(Label label) {
		refactored(label);
		
	}
	
	@Override
	public void visit(MergeGroup mergeGroup) {
		refactored(mergeGroup);
		
	}
	
	@Override
	public void visit(Milestone milestone) {
		refactored(milestone);
		
	}
	
	@Override
	public void visit(PageBuild pageBuild) {
		refactored(pageBuild);
		
	}
	
	@Override
	public void visit(Project project) {
		refactored(project);
		
	}
	
	@Override
	public void visit(ProjectCard projectCard) {
		refactored(projectCard);
		
	}
	
	@Override
	public void visit(ProjectColumn projectColumn) {
		refactored(projectColumn);
		
	}
	
	@Override
	public void visit(Public aPublic) {
		refactored(aPublic);
		
	}
	
	@Override
	public void visit(Status status) {
		refactored(status);
		
	}
	
	@Override
	public void visit(Watch watch) {
		refactored(watch);
		
	}
	
	@Override
	public void visit(WorkflowCall workflowCall) {
		refactored(workflowCall);
		
	}
	
	@Override
	public void visit(Secret secret) {
		visitInOut(secret);
		
	}
	
	@Override
	public void visit(PullRequestComment pullRequestComment) {
		refactored(pullRequestComment);
		
	}
	
	@Override
	public void visit(PullRequestReview pullRequestReview) {
		refactored(pullRequestReview);
		
	}
	
	@Override
	public void visit(PullRequestReviewComment pullRequestReviewComment) {
		refactored(pullRequestReviewComment);
		
	}
	
	@Override
	public void visit(CheckSuite checkSuite) {
		refactored(checkSuite);
		
	}
	
	@Override
	public void visit(Deployment deployment) {
		refactored(deployment);
		
	}
	
	@Override
	public void visit(PullRequest pullRequest) {
		refactored(pullRequest);
		
	}
	
	@Override
	public void visit(WorkflowDispatch workflowDispatch) {
		refactored(workflowDispatch);
		
	}
	
	
	@Override
	public void visit(PullRequestTarget pullRequestTarget) {
		refactored(pullRequestTarget);
		
	}
	
	@Override
	public void visit(RepositoryDispatch repositoryDispatch) {
		refactored(repositoryDispatch);
		
	}
	
	@Override
	public void visit(Schedule schedule) {
		refactored(schedule);
		
	}
	
	protected void visitChildren(Collection<? extends Node> children, Appender toto, boolean addNewLine) {
		if (addNewLine && !children.isEmpty()) {
			appender_.newLine();
		}
		List<Node> nodes = new ArrayList<>(children);
		for (int i = 0; i < nodes.size(); i++) {
			nodes.get(i).accept(this);
			if (i < nodes.size() - 1) {
				appender_.newLine();
			}
		}
	}
	
	@Override
	public void visit(Branches branches) {
		refactored(branches);
		
	}
	
	@Override
	public void visit(BranchesIgnore branchesIgnore) {
		refactored(branchesIgnore);
		
	}
	
	@Override
	public void visit(TagsIgnore tagsIgnore) {
		refactored(tagsIgnore);
		
	}
	
	@Override
	public void visit(RegistryPackage registryPackage) {
		refactored(registryPackage);
		
	}
	
	@Override
	public void visit(Paths paths) {
		refactored(paths);
		
	}
	
	@Override
	public void visit(Cron cron) {
		appender_.append(cron.toString());
		
	}
	
	@Override
	public void visit(PathsIgnore paths) {
		refactored(paths);
		
	}
	
	@Override
	public void visit(Tags tags) {
		refactored(tags);
		
	}
	
	@Override
	public void visit(Types types) {
		refactored(types);
		
	}
	
	@Override
	public void visit(Inputs inputs) {
		refactored(inputs);
		
	}
	
	@Override
	public void visit(Secrets secrets) {
		refactored(secrets);
		
	}
	
	@Override
	public void visit(WorkflowRun workflowRun) {
		refactored(workflowRun);
		
	}
	
	@Override
	public void visit(Options options) {
		refactored(options);
		
	}
	
	@Override
	public void visit(Environments environments) {
		refactored(environments);
		
	}
	
	@Override
	public void visit(Withs withs) {
		refactored(withs);
		
	}
	
	@Override
	public void visit(Pipe pipe) {
		appender_.increaseIndent();
		visitChildren(pipe.children, appender_, false);
		appender_.decreaseIndent();
		
	}
	
	@Override
	public void visit(Jobs jobs) {
		refactored(jobs);
		
	}
	
	@Override
	public void visit(Steps jobs) {
		refactored(jobs);
		
	}
	
	@Override
	public void visit(Step step) {
		List<Node> nodes = new ArrayList<>(step.children);
		for (int i = 0; i < nodes.size(); i++) {
			Node node = nodes.get(i);
			if (i == 0) {
				node.accept(this);
			} else {
				appender_.increaseIndent();
				node.accept(this);
				appender_.decreaseIndent();
			}
			if (i < nodes.size() - 1) {
				appender_.newLine();
				
			}
		}
		
	}
	
	@Override
	public void visit(Needs jobs) {
		refactored(jobs);
		
	}
	
	@Override
	public void visit(Container container) {
		refactored(container);
		
	}
	
	@Override
	public void visit(Environment environment) {
		appender_.indent();
		appender_.append(environment.getName());
		appender_.append(": ");
		appender_.append(environment.getValue());
		
	}
	
	@Override
	public void visit(Volumes volumes) {
		refactored(volumes);
		
	}
	
	@Override
	public void visit(Volume volumes) {
		appender_.indent();
		appender_.append("- ");
		appender_.append(volumes.getName());
		appender_.append(":");
		appender_.append(volumes.getValue());
		
	}
	
	@Override
	public void visit(DashedId id) {
		appender_.indent();
		appender_.append("- ");
		appender_.append(id.getName());
		appender_.append(": ");
		appender_.append(id.getValue());
		
	}
	
	
	@Override
	public void visit(Services services) {
		refactored(services);
		
	}
	
	@Override
	public void visit(Service volumes) {
		refactored(volumes);
		
	}
	
	@Override
	public void visit(Ports ports) {
		refactored(ports);
		
	}
	
	@Override
	public void visit(Job job) {
		if (job.label != null) {
			job.label.accept(this);
			
			
		}
		appender_.increaseIndent();
		visitChildren(job.children, appender_, true);
		appender_.decreaseIndent();
		
		
	}
	
	@Override
	public void visit(Outputs outputs) {
		refactored(outputs);
		
	}
	
	@Override
	public void visit(Output output) {
		visitInOut(output);
		
	}
	
	@Override
	public void visit(DashQuotedSingleElement dashQuotedSingleElement) {
		appender_.indent();
		appender_.append("- ");
		appender_.appendSingleQuote(dashQuotedSingleElement.getValue());
		
	}
	
	@Override
	public void visit(DashSingleElement dashQuotedSingleElement) {
		appender_.indent();
		appender_.append("- ");
		appender_.append(dashQuotedSingleElement.getValue());
		
	}
	
	
	@Override
	public void visit(DashedNameQuotedValuePair dashedNameQuotedValuePair) {
		appender_.indent();
		appender_.append("- ");
		appender_.append(dashedNameQuotedValuePair.getName());
		appender_.append(": ");
		appender_.appendSingleQuote(dashedNameQuotedValuePair.getValue());
		
	}
	
	@Override
	public void visit(DashedNameValuePair dashedNameQuotedValuePair) {
		appender_.indent();
		appender_.append("- ");
		appender_.append(dashedNameQuotedValuePair.getName());
		appender_.append(": ");
		appender_.append(dashedNameQuotedValuePair.getValue());
		
	}
	
	@Override
	public void visit(LabeledDashedName labeledDashedName) {
		appender_.indent();
		appender_.append("- ");
		appender_.append(labeledDashedName.getName());
		appender_.append(": ");
		appender_.append(labeledDashedName.getValue());
		
	}
	
	@Override
	public void visit(SingleElement singleElement) {
		appender_.indent();
		appender_.append(singleElement.getValue());
		appender_.append(":");
		
	}
	
	@Override
	public void visit(SimpleEntry simpleEntry) {
		appender_.indent();
		appender_.append(simpleEntry.getValue());
		
	}
	
	@Override
	public void visit(InOutElement<?> inOutElement) {
		appender_.indent();
		appender_.append(inOutElement.getName());
		appender_.append(": ");
		if (inOutElement.withDoubleQuotes()) {
			appender_.appendDoubleQuote(inOutElement.getValue());
		} else {
			appender_.append(inOutElement.getValue());
		}
		
	}
	
	@Override
	public void visit(LabeledName labeledName) {
		appender_.indent();
		appender_.append(labeledName.getName());
		appender_.append(": ");
		appender_.append(labeledName.getValue());
		
	}
	
	@Override
	public void visit(Input input) {
		visitInOut(input);
		
	}
	
	private void visitInOut(InOut input) {
		input.name.accept(this);
		appender_.increaseIndent();
		visitChildren(input.inputElements, appender_, true);
		appender_.decreaseIndent();
	}
	
	@Override
	public void visit(NameValuePair nameValuePair) {
		appender_.indent();
		appender_.append(nameValuePair.getName());
		appender_.append(": ");
		appender_.append(nameValuePair.getValue());
	}
	
	@Override
	public String getResult() {
		return appender_.toString();
	}
	
}

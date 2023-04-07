package org.example.visitor;

import org.example.Appender;
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
import org.example.wrappers.Credentials;
import org.example.wrappers.DashQuotedSingleElement;
import org.example.wrappers.DashSingleElement;
import org.example.wrappers.DashedId;
import org.example.wrappers.DashedNameQuotedValuePair;
import org.example.wrappers.DashedNameValuePair;
import org.example.wrappers.InOutElement;
import org.example.wrappers.Input;
import org.example.wrappers.LabeledDashedName;
import org.example.wrappers.LabeledName;
import org.example.wrappers.NameValuePair;
import org.example.wrappers.Node;
import org.example.wrappers.Output;
import org.example.wrappers.Secret;
import org.example.wrappers.SimpleEntry;
import org.example.wrappers.SingleElement;
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

public class DefaultVisitorImpl implements Visitor<Appender> {
	
	public DefaultVisitorImpl() {
		//	support(new LeavesVisitorImpl());
	}
	
	@Override
	public void visit(Concurrency concurrency, Appender arg) {
		refactored(concurrency, arg);
	}
	
	@Override
	public void visit(Credentials credentials, Appender arg) {
		credentials.name.accept(this, arg);
		arg.increaseIndent();
		visitChildren(credentials.inputElements, arg, true);
		arg.decreaseIndent();
	}
	
	@Override
	public void visit(Defaults defaults, Appender arg) {
		refactored(defaults, arg);
	}
	
	@Override
	public void visit(Run run, Appender arg) {
		refactored(run, arg);
	}
	
	@Override
	public void visit(Permissions permissions, Appender arg) {
		refactored(permissions, arg);
	}
	
	@Override
	public void visit(Workflow workflow, Appender arg) {
		workflow.name.accept(this, arg);
		visitChildren(workflow.children, arg, true);
	}
	
	@Override
	public void visit(Workflows workflows, Appender arg) {
		refactored(workflows, arg);
	}
	
	@Override
	public void visit(Events events, Appender arg) {
		refactored(events, arg);
	}
	
	@Override
	public void visit(Push push, Appender arg) {
		refactored(push, arg);
	}
	
	@Override
	public void visit(Release release, Appender arg) {
		refactored(release, arg);
	}
	
	@Override
	public void visit(Delete delete, Appender arg) {
		refactored(delete, arg);
	}
	
	@Override
	public void visit(DiscussionComment discussionComment, Appender arg) {
		refactored(discussionComment, arg);
	}
	
	@Override
	public void visit(DeploymentStatus deploymentStatus, Appender arg) {
		refactored(deploymentStatus, arg);
	}
	
	@Override
	public void visit(Discussion discussion, Appender arg) {
		refactored(discussion, arg);
	}
	
	@Override
	public void visit(BranchProtectionRule branchProtectionRule, Appender arg) {
		refactored(branchProtectionRule, arg);
	}
	
	public void refactored(Nodes nodes, Appender arg) {
		nodes.name.accept(this, arg);
		arg.increaseIndent();
		visitChildren(nodes.children, arg, true);
		arg.decreaseIndent();
	}
	
	@Override
	public void visit(CheckRun checkRun, Appender arg) {
		refactored(checkRun, arg);
	}
	
	@Override
	public void visit(Create create, Appender arg) {
		refactored(create, arg);
	}
	
	@Override
	public void visit(Fork fork, Appender arg) {
		refactored(fork, arg);
	}
	
	@Override
	public void visit(Gollum fork, Appender arg) {
		refactored(fork, arg);
	}
	
	@Override
	public void visit(IssueComment issueComment, Appender arg) {
		refactored(issueComment, arg);
	}
	
	@Override
	public void visit(Issues issues, Appender arg) {
		refactored(issues, arg);
	}
	
	@Override
	public void visit(Label label, Appender arg) {
		refactored(label, arg);
	}
	
	@Override
	public void visit(MergeGroup mergeGroup, Appender arg) {
		refactored(mergeGroup, arg);
	}
	
	@Override
	public void visit(Milestone milestone, Appender arg) {
		refactored(milestone, arg);
	}
	
	@Override
	public void visit(PageBuild pageBuild, Appender arg) {
		refactored(pageBuild, arg);
	}
	
	@Override
	public void visit(Project project, Appender arg) {
		refactored(project, arg);
	}
	
	@Override
	public void visit(ProjectCard projectCard, Appender arg) {
		refactored(projectCard, arg);
	}
	
	@Override
	public void visit(ProjectColumn projectColumn, Appender arg) {
		refactored(projectColumn, arg);
	}
	
	@Override
	public void visit(Public aPublic, Appender arg) {
		refactored(aPublic, arg);
	}
	
	@Override
	public void visit(Status status, Appender arg) {
		refactored(status, arg);
	}
	
	@Override
	public void visit(Watch watch, Appender arg) {
		refactored(watch, arg);
	}
	
	@Override
	public void visit(WorkflowCall workflowCall, Appender arg) {
		refactored(workflowCall, arg);
	}
	
	@Override
	public void visit(Secret secret, Appender arg) {
		secret.name.accept(this, arg);
		arg.increaseIndent();
		visitChildren(secret.inputElements, arg, true);
		arg.decreaseIndent();
	}
	
	@Override
	public void visit(PullRequestComment pullRequestComment, Appender arg) {
		refactored(pullRequestComment, arg);
	}
	
	@Override
	public void visit(PullRequestReview pullRequestReview, Appender arg) {
		refactored(pullRequestReview, arg);
	}
	
	@Override
	public void visit(PullRequestReviewComment pullRequestReviewComment, Appender arg) {
		refactored(pullRequestReviewComment, arg);
	}
	
	@Override
	public void visit(CheckSuite checkSuite, Appender arg) {
		refactored(checkSuite, arg);
	}
	
	@Override
	public void visit(Deployment deployment, Appender arg) {
		refactored(deployment, arg);
	}
	
	@Override
	public void visit(PullRequest pullRequest, Appender arg) {
		refactored(pullRequest, arg);
	}
	
	@Override
	public void visit(WorkflowDispatch workflowDispatch, Appender arg) {
		refactored(workflowDispatch, arg);
	}
	
	@Override
	public void visit(PullRequestTarget pullRequestTarget, Appender arg) {
		refactored(pullRequestTarget, arg);
	}
	
	@Override
	public void visit(RepositoryDispatch repositoryDispatch, Appender arg) {
		refactored(repositoryDispatch, arg);
	}
	
	@Override
	public void visit(Schedule schedule, Appender arg) {
		refactored(schedule, arg);
	}
	
	protected void visitChildren(Collection<? extends Node> children, Appender arg, boolean addNewLine) {
		if (addNewLine && !children.isEmpty()) {
			arg.newLine();
		}
		List<Node> nodes = new ArrayList<>(children);
		for (int i = 0; i < nodes.size(); i++) {
			nodes.get(i).accept(this, arg);
			if (i < nodes.size() - 1) {
				arg.newLine();
			}
		}
	}
	
	@Override
	public void visit(Branches branches, Appender arg) {
		refactored(branches, arg);
	}
	
	@Override
	public void visit(BranchesIgnore branchesIgnore, Appender arg) {
		refactored(branchesIgnore, arg);
	}
	
	@Override
	public void visit(TagsIgnore tagsIgnore, Appender arg) {
		refactored(tagsIgnore, arg);
	}
	
	@Override
	public void visit(RegistryPackage registryPackage, Appender arg) {
		refactored(registryPackage, arg);
	}
	
	@Override
	public void visit(Paths paths, Appender arg) {
		refactored(paths, arg);
	}
	
	@Override
	public void visit(Cron cron, Appender arg) {
		arg.append(cron.toString());
	}
	
	@Override
	public void visit(PathsIgnore paths, Appender arg) {
		refactored(paths, arg);
	}
	
	@Override
	public void visit(Tags tags, Appender arg) {
		refactored(tags, arg);
	}
	
	@Override
	public void visit(Types types, Appender arg) {
		refactored(types, arg);
	}
	
	@Override
	public void visit(Inputs inputs, Appender arg) {
		refactored(inputs, arg);
	}
	
	@Override
	public void visit(Secrets secrets, Appender arg) {
		refactored(secrets, arg);
	}
	
	@Override
	public void visit(WorkflowRun workflowRun, Appender arg) {
		refactored(workflowRun, arg);
	}
	
	@Override
	public void visit(Options options, Appender arg) {
		refactored(options, arg);
	}
	
	@Override
	public void visit(Environments environments, Appender arg) {
		refactored(environments, arg);
	}
	
	@Override
	public void visit(Withs withs, Appender arg) {
		refactored(withs, arg);
	}
	
	@Override
	public void visit(Pipe pipe, Appender arg) {
		arg.increaseIndent();
		visitChildren(pipe.children, arg, false);
		arg.decreaseIndent();
	}
	
	@Override
	public void visit(Jobs jobs, Appender arg) {
		refactored(jobs, arg);
	}
	
	@Override
	public void visit(Steps jobs, Appender arg) {
		refactored(jobs, arg);
	}
	
	@Override
	public void visit(Step step, Appender arg) {
		List<Node> nodes = new ArrayList<>(step.children);
		for (int i = 0; i < nodes.size(); i++) {
			Node node = nodes.get(i);
			if (i == 0) {
				node.accept(this, arg);
			} else {
				arg.increaseIndent();
				node.accept(this, arg);
				arg.decreaseIndent();
			}
			if (i < nodes.size() - 1) {
				arg.newLine();
			}
		}
	}
	
	@Override
	public void visit(Needs jobs, Appender arg) {
		refactored(jobs, arg);
	}
	
	@Override
	public void visit(Container container, Appender arg) {
		refactored(container, arg);
	}
	
	@Override
	public void visit(Environment environment, Appender appender) {
		appender.indent();
		appender.append(environment.name);
		appender.append(": ");
		appender.append(environment.value);
	}
	
	@Override
	public void visit(Volumes volumes, Appender arg) {
		refactored(volumes, arg);
	}
	
	@Override
	public void visit(Volume volumes, Appender appender) {
		appender.indent();
		appender.append("- ");
		appender.append(volumes.name);
		appender.append(":");
		appender.append(volumes.value);
	}
	
	@Override
	public void visit(DashedId id, Appender appender) {
		appender.indent();
		appender.append("- ");
		appender.append(id.name);
		appender.append(": ");
		appender.append(id.value);
	}
	
	
	@Override
	public void visit(Services services, Appender arg) {
		refactored(services, arg);
	}
	
	@Override
	public void visit(Service volumes, Appender arg) {
		refactored(volumes, arg);
	}
	
	@Override
	public void visit(Ports ports, Appender arg) {
		refactored(ports, arg);
	}
	
	@Override
	public void visit(Job job, Appender arg) {
		if (job.label != null) {
			job.label.accept(this, arg);
			
		}
		arg.increaseIndent();
		visitChildren(job.children, arg, true);
		arg.decreaseIndent();
		
	}
	
	@Override
	public void visit(Outputs outputs, Appender arg) {
		refactored(outputs, arg);
	}
	
	@Override
	public void visit(Output output, Appender arg) {
		output.name.accept(this, arg);
		arg.increaseIndent();
		visitChildren(output.inputElements, arg, true);
		arg.decreaseIndent();
	}
	
	@Override
	public void visit(DashQuotedSingleElement dashQuotedSingleElement, Appender appender) {
		appender.indent();
		appender.append("- ");
		appender.appendSingleQuote(dashQuotedSingleElement.value);
	}
	
	@Override
	public void visit(DashSingleElement dashQuotedSingleElement, Appender appender) {
		appender.indent();
		appender.append("- ");
		appender.append(dashQuotedSingleElement.value);
	}
	
	
	@Override
	public void visit(DashedNameQuotedValuePair dashedNameQuotedValuePair, Appender appender) {
		appender.indent();
		appender.append("- ");
		appender.append(dashedNameQuotedValuePair.name);
		appender.append(": ");
		appender.appendSingleQuote(dashedNameQuotedValuePair.value);
	}
	
	@Override
	public void visit(DashedNameValuePair dashedNameQuotedValuePair, Appender appender) {
		appender.indent();
		appender.append("- ");
		appender.append(dashedNameQuotedValuePair.name);
		appender.append(": ");
		appender.append(dashedNameQuotedValuePair.value);
	}
	
	@Override
	public void visit(LabeledDashedName labeledDashedName, Appender appender) {
		appender.indent();
		appender.append("- ");
		appender.append(labeledDashedName.name);
		appender.append(": ");
		appender.append(labeledDashedName.value);
	}
	
	@Override
	public void visit(SingleElement singleElement, Appender appender) {
		appender.indent();
		appender.append(singleElement.value);
		appender.append(":");
	}
	
	@Override
	public void visit(SimpleEntry simpleEntry, Appender appender) {
		appender.indent();
		appender.append(simpleEntry.value);
	}
	
	@Override
	public void visit(InOutElement<?> inOutElement, Appender appender) {
		appender.indent();
		appender.append(inOutElement.name);
		appender.append(": ");
		if (inOutElement.withDoubleQuotes()) {
			appender.appendDoubleQuote(inOutElement.value);
		} else {
			appender.append(inOutElement.value);
		}
	}
	
	@Override
	public void visit(LabeledName labeledName, Appender appender) {
		appender.indent();
		appender.append(labeledName.name);
		appender.append(": ");
		appender.append(labeledName.value);
	}
	
	@Override
	public void visit(Input input, Appender arg) {
		input.name.accept(this, arg);
		arg.increaseIndent();
		visitChildren(input.inputElements, arg, true);
		arg.decreaseIndent();
	}
	
	@Override
	public void visit(NameValuePair nameValuePair, Appender appender) {
		appender.indent();
		appender.append(nameValuePair.name);
		appender.append(": ");
		appender.append(nameValuePair.value);
	}
	
}

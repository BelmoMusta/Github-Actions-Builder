package org.example.visitor;

import org.example.Appender;
import org.example.collections.Branches;
import org.example.collections.Environments;
import org.example.collections.Events;
import org.example.collections.Inputs;
import org.example.collections.Jobs;
import org.example.collections.Needs;
import org.example.collections.Nodes;
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
import org.example.yy.Job;
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DefaultVoidVisitorImpl extends AbstractVoidVisitor<String> {
	
	
	
	private final Appender appender;
	
	@Override
	public String getFinalResult() {
		return appender.toString();
	}
	
	public DefaultVoidVisitorImpl() {
		appender = new Appender();
	}
	
	@Override
	public void visit(Workflow workflow) {
		workflow.name.accept(this);
		visitChildren(workflow.children, appender, true);
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
		appender.increaseIndent();
		visitChildren(nodes.children, appender, true);
		appender.decreaseIndent();
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
	public void visit(Schedule schedule) {
		refactored(schedule);
	}
	
	protected void visitChildren(Collection<? extends Node> children, Appender arg, boolean addNewLine) {
		if (addNewLine && !children.isEmpty()) {
			arg.newLine();
		}
		List<Node> nodes = new ArrayList<>(children);
		for (int i = 0; i < nodes.size(); i++) {
			nodes.get(i).accept(this);
			if (i < nodes.size() - 1) {
				arg.newLine();
			}
		}
	}
	
	@Override
	public void visit(Branches branches) {
		refactored(branches);
	}
	
	@Override
	public void visit(Paths paths) {
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
		appender.increaseIndent();
		visitChildren(pipe.children, appender, false);
		appender.decreaseIndent();
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
				appender.increaseIndent();
				node.accept(this);
				appender.decreaseIndent();
			}
			if (i < nodes.size() - 1) {
				appender.newLine();
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
		appender.indent();
		appender.append(environment.name);
		appender.append(": ");
		appender.append(environment.value);
	}
	
	@Override
	public void visit(Volumes volumes) {
		refactored(volumes);
	}
	
	@Override
	public void visit(Volume volumes) {
		appender.indent();
		appender.append("- ");
		appender.append(volumes.name);
		appender.append(":");
		appender.append(volumes.value);
	}
	
	@Override
	public void visit(DashedId id) {
		appender.indent();
		appender.append("- ");
		appender.append(id.name);
		appender.append(": ");
		appender.append(id.value);
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
		refactored(job);
	}
	
	@Override
	public void visit(Outputs outputs) {
		refactored(outputs);
	}
	
	@Override
	public void visit(Output output) {
		output.name.accept(this);
		appender.increaseIndent();
		visitChildren(output.inputElements, appender, true);
		appender.decreaseIndent();
	}
	
	@Override
	public void visit(DashQuotedSingleElement dashQuotedSingleElement) {
		appender.indent();
		appender.append("- ");
		appender.appendSingleQuote(dashQuotedSingleElement.value);
	}
	
	@Override
	public void visit(DashSingleElement dashQuotedSingleElement) {
		appender.indent();
		appender.append("- ");
		appender.append(dashQuotedSingleElement.value);
	}
	
	@Override
	public void visit(DashedNameQuotedValuePair dashedNameQuotedValuePair) {
		appender.indent();
		appender.append("- ");
		appender.append(dashedNameQuotedValuePair.name);
		appender.append(": ");
		appender.appendSingleQuote(dashedNameQuotedValuePair.value);
	}
	
	@Override
	public void visit(DashedNameValuePair dashedNameQuotedValuePair) {
		appender.indent();
		appender.append("- ");
		appender.append(dashedNameQuotedValuePair.name);
		appender.append(": ");
		appender.append(dashedNameQuotedValuePair.value);
	}
	
	@Override
	public void visit(LabeledDashedName labeledDashedName) {
		appender.indent();
		appender.append("- ");
		appender.append(labeledDashedName.name);
		appender.append(": ");
		appender.append(labeledDashedName.value);
	}
	
	@Override
	public void visit(SingleElement singleElement) {
		appender.indent();
		appender.append(singleElement.value);
		appender.append(":");
	}
	
	@Override
	public void visit(SimpleEntry simpleEntry) {
		appender.indent();
		appender.append(simpleEntry.value);
	}
	
	@Override
	public void visit(InOutElement<?> inOutElement) {
		appender.indent();
		appender.append(inOutElement.name);
		appender.append(": ");
		if (inOutElement.isString()) {
			appender.appendSingleQuote(inOutElement.value);
		} else {
			appender.append(inOutElement.value);
		}
	}
	
	@Override
	public void visit(LabeledName labeledName) {
		appender.indent();
		appender.append(labeledName.name);
		appender.append(": ");
		appender.append(labeledName.value);
	}
	
	@Override
	public void visit(Input input) {
		input.name.accept(this);
		appender.increaseIndent();
		visitChildren(input.inputElements, appender, true);
		appender.decreaseIndent();
	}
	
	@Override
	public void visit(NameValuePair nameValuePair) {
		appender.indent();
		appender.append(nameValuePair.name);
		appender.append(": ");
		appender.append(nameValuePair.value);
	}
	
	@Override
	public String toString() {
		return appender.toString();
	}
}

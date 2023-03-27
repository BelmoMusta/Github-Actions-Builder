package org.example.visitor;

import org.example.Appender;
import org.example.Container;
import org.example.Environment;
import org.example.Image;
import org.example.Job;
import org.example.PullRequest;
import org.example.PullRequestTarget;
import org.example.Push;
import org.example.Schedule;
import org.example.Service;
import org.example.Step;
import org.example.Volume;
import org.example.Workflow;
import org.example.WorkflowDispatch;
import org.example.WorkflowEvent;
import org.example.WorkflowEventWithBranches;
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
import org.example.collections.Ports;
import org.example.collections.Services;
import org.example.collections.Steps;
import org.example.collections.SubNode;
import org.example.collections.Tags;
import org.example.collections.Types;
import org.example.collections.Volumes;
import org.example.wrappers.DashQuotedSingleElement;
import org.example.wrappers.DashSingleElement;
import org.example.wrappers.DashedNameValuePair;
import org.example.wrappers.InOut;
import org.example.wrappers.InOutElement;
import org.example.wrappers.Input;
import org.example.wrappers.LabeledDashedName;
import org.example.wrappers.LabeledName;
import org.example.wrappers.NameValuePair;
import org.example.wrappers.Node;
import org.example.wrappers.Output;
import org.example.wrappers.SingleElement;
import org.example.wrappers.Tag;

public class DefaultVisitorImpl extends AbstractVisitor<Appender> {
	
	@Override
	public void visit(Workflow workflow, Appender arg) {
		arg.append(workflow.name);
		arg.newLine();
		visitChildren(workflow.children, arg, 0);
	}
	
	@Override
	public void visit(Events events, Appender arg) {
		arg.append(events.name);
		arg.newLine();
		visitChildren(events.children, arg, 0);
	}
	
	@Override
	public void visit(Environments environments, Appender arg) {
		arg.append(environments.name);
		visitChildren(environments.children, arg, 0);
		
	}
	
	@Override
	public void visit(Push push, Appender arg) {
		applyIndentation(push, arg);
		arg.append(push.name).newLine();
		visitChildren(push.children, arg, 2);
	}
	
	private void applyIndentation(Node node, Appender arg) {
		arg.indent(node.getIndentLevel());
	}
	
	@Override
	public void visit(Branches branches, Appender arg) {
		applyIndentation(branches, arg);
		arg.append(branches.name).newLine();
		visitChildren(branches.children, arg, branches.getIndentLevel() + 1);
	}
	
	@Override
	public void visit(Paths paths, Appender arg) {
		applyIndentation(paths, arg);
		arg.append(paths.name).newLine();
		visitChildren(paths.children, arg);
	}
	
	@Override
	public void visit(Tags tags, Appender arg) {
		applyIndentation(tags, arg);
		arg.append(tags.name).newLine();
		visitChildren(tags.children, arg);
	}
	
	@Override
	public <X extends Node> void visit(X anyOtherTag, Appender arg) {
		arg.append(anyOtherTag.toString());
		arg.newLine();
	}
	
	
	@Override
	public void visit(BranchesIgnore branchesIgnore, Appender arg) {
	}
	
	@Override
	public void visit(Inputs inputs, Appender arg) {
		arg.newLine();
		applyIndentation(inputs, arg);
		arg.append(inputs.name);
		visitChildren(inputs.children, arg, inputs.getIndentLevel() + 1);
	}
	
	@Override
	public void visit(Jobs jobs, Appender arg) {
	}
	
	@Override
	public void visit(Needs needs, Appender arg) {
	}
	
	@Override
	public void visit(Nodes nodes, Appender arg) {
	}
	
	@Override
	public void visit(Options options, Appender arg) {
		arg.newLine();
		arg.append(options.name);
		if (!options.children.isEmpty()) {
			arg.newLine();
		}
		visitChildren(options.children, arg, options.getIndentLevel() + 1);
	}
	
	@Override
	public void visit(Outputs outputs, Appender arg) {
	}
	
	
	@Override
	public void visit(Ports ports, Appender arg) {
	}
	
	@Override
	public void visit(Services services, Appender arg) {
	}
	
	@Override
	public void visit(Steps steps, Appender arg) {
	}
	
	@Override
	public void visit(SubNode subNode, Appender arg) {
	}
	
	
	@Override
	public void visit(Types types, Appender arg) {
	}
	
	@Override
	public void visit(Volumes volumes, Appender arg) {
	}
	
	@Override
	public void visit(DashedNameValuePair dashedNameValuePair, Appender arg) {
	}
	
	@Override
	public void visit(DashQuotedSingleElement dashQuotedSingleElement, Appender arg) {
		applyIndentation(dashQuotedSingleElement, arg);
		arg.append(dashQuotedSingleElement.toString());
		arg.newLine();
	}
	
	@Override
	public void visit(DashSingleElement dashSingleElement, Appender arg) {
	}
	
	@Override
	public void visit(InOut inOut, Appender arg) {
	}
	
	@Override
	public void visit(InOutElement inOutElement, Appender arg) {
		arg.newLine();
		applyIndentation(inOutElement, arg);
		arg.append(inOutElement.toString());
	}
	
	@Override
	public void visit(Input input, Appender arg) {
		arg.newLine();
		applyIndentation(input, arg);
		arg.append(input.name);
		visitChildren(input.inputElements, arg, input.getIndentLevel() + 1);
	}
	
	@Override
	public void visit(LabeledDashedName labeledDashedName, Appender arg) {
	}
	
	@Override
	public void visit(LabeledName labeledName, Appender arg) {
	}
	
	@Override
	public void visit(NameValuePair nameValuePair, Appender arg) {
		arg.newLine();
		arg.append(nameValuePair.toString() + "llll");
	}
	
	
	@Override
	public void visit(Output output, Appender arg) {
	}
	
	@Override
	public void visit(SingleElement singleElement, Appender arg) {
	}
	
	@Override
	public void visit(Container container, Appender arg) {
	}
	
	@Override
	public void visit(Environment environment, Appender arg) {
	}
	
	@Override
	public void visit(Image image, Appender arg) {
	}
	
	@Override
	public void visit(Job job, Appender arg) {
	}
	
	@Override
	public void visit(PullRequest pullRequest, Appender arg) {
	}
	
	@Override
	public void visit(PullRequestTarget pullRequestTarget, Appender arg) {
	}
	
	
	@Override
	public void visit(Schedule schedule, Appender arg) {
	}
	
	@Override
	public void visit(Service service, Appender arg) {
	}
	
	@Override
	public void visit(Step step, Appender arg) {
	}
	
	@Override
	public void visit(Volume volume, Appender arg) {
	}
	
	
	@Override
	public void visit(WorkflowDispatch workflowDispatch, Appender arg) {
		applyIndentation(workflowDispatch, arg);
		arg.append(workflowDispatch.name);
		visitChildren(workflowDispatch.children, arg, 2);
	}
	
	public void visitNodes(Nodes nodes, Appender arg) {
		applyIndentation(nodes, arg);
		arg.append(nodes.name);
		visitChildren(nodes.children, arg, 2);
	}
	
	
	@Override
	public void visit(WorkflowEventWithBranches workflowEventWithBranches, Appender arg) {
	}
	
}

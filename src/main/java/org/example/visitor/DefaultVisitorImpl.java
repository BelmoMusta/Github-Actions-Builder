package org.example.visitor;

import org.example.Appender;
import org.example.Container;
import org.example.Environment;
import org.example.Job;
import org.example.Pipe;
import org.example.PullRequest;
import org.example.PullRequestTarget;
import org.example.Push;
import org.example.Schedule;
import org.example.Service;
import org.example.Step;
import org.example.Volume;
import org.example.Workflow;
import org.example.WorkflowDispatch;
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DefaultVisitorImpl extends SubVisitor<Appender> {
	
	public DefaultVisitorImpl(){
	//	support(new LeavesVisitorImpl());
	}
	
	@Override
	public void visit(Workflow workflow, Appender arg) {
		workflow.name.accept(this, arg);
		visitChildren(workflow.children, arg, true);
	}
	
	@Override
	public void visit(Events events, Appender arg) {
		visitWithIndents(events, arg);
	}
	
	@Override
	public void visit(Push push, Appender arg) {
		push.name.accept(this, arg);
		arg.increaseIndent();
		visitChildren(push.children, arg, true);
		arg.decreaseIndent();
	}
	
	@Override
	public void visit(PullRequest pullRequest, Appender arg) {
		pullRequest.name.accept(this, arg);
		arg.increaseIndent();
		visitChildren(pullRequest.children, arg, true);
		arg.decreaseIndent();
	}
	
	private void visitWithIndents(Nodes nodes, Appender arg) {
		nodes.name.accept(this, arg);
		arg.increaseIndent();
		visitChildren(nodes.children, arg, true);
		arg.decreaseIndent();
	}
	
	@Override
	public void visit(WorkflowDispatch workflowDispatch, Appender arg) {
		workflowDispatch.name.accept(this, arg);
		arg.increaseIndent();
		visitChildren(workflowDispatch.children, arg, true);
		arg.decreaseIndent();
	}
	
	@Override
	public void visit(PullRequestTarget workflowDispatch, Appender arg) {
		workflowDispatch.name.accept(this, arg);
		arg.increaseIndent();
		visitChildren(workflowDispatch.children, arg, true);
		arg.decreaseIndent();
	}
	
	@Override
	public void visit(Schedule schedule, Appender arg) {
		visitWithIndents(schedule, arg);
	}
	
	@Override
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
		super.visitChildren(children, arg, addNewLine);
	}
	
	@Override
	public void visit(Branches branches, Appender arg) {
		visitWithIndents(branches, arg);
		
	}
	
	@Override
	public void visit(Paths paths, Appender arg) {
		visitWithIndents(paths, arg);
	}
	
	@Override
	public void visit(Tags tags, Appender arg) {
		visitWithIndents(tags, arg);
	}
	
	@Override
	public void visit(Types types, Appender arg) {
		visitWithIndents(types, arg);
	}
	
	@Override
	public void visit(Inputs inputs, Appender arg) {
		visitWithIndents(inputs, arg);
	}
	
	@Override
	public void visit(Options options, Appender arg) {
		visitWithIndents(options, arg);
	}
	
	@Override
	public void visit(Environments environments, Appender arg) {
		visitWithIndents(environments, arg);
	}
	
	@Override
	public void visit(Withs withs, Appender arg) {
		visitWithIndents(withs, arg);
	}
	
	@Override
	public void visit(Pipe pipe, Appender arg) {
		arg.increaseIndent();
		visitChildren(pipe.children, arg, false);
		arg.decreaseIndent();
	}
	
	@Override
	public void visit(Jobs jobs, Appender arg) {
		visitWithIndents(jobs, arg);
	}
	
	@Override
	public void visit(Steps jobs, Appender arg) {
		visitWithIndents(jobs, arg);
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
		visitWithIndents(jobs, arg);
	}
	
	@Override
	public void visit(Container container, Appender arg) {
		visitWithIndents(container, arg);
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
		visitWithIndents(volumes, arg);
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
		visitWithIndents(services, arg);
	}
	
	@Override
	public void visit(Service volumes, Appender arg) {
		visitWithIndents(volumes, arg);
	}
	
	@Override
	public void visit(Ports ports, Appender arg) {
		visitWithIndents(ports, arg);
	}
	
	@Override
	public void visit(Job job, Appender arg) {
		visitWithIndents(job, arg);
	}
	
	@Override
	public void visit(Outputs outputs, Appender arg) {
		visitWithIndents(outputs, arg);
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
		if (inOutElement.isString()) {
			appender.appendSingleQuote(inOutElement.value);
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

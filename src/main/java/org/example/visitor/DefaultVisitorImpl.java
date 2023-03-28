package org.example.visitor;

import org.example.Appender;
import org.example.Container;
import org.example.Job;
import org.example.PullRequest;
import org.example.PullRequestTarget;
import org.example.Push;
import org.example.Schedule;
import org.example.Service;
import org.example.Step;
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
import org.example.wrappers.DashQuotedSingleElement;
import org.example.wrappers.InOutElement;
import org.example.wrappers.Input;
import org.example.wrappers.NameValuePair;
import org.example.wrappers.Output;

public class DefaultVisitorImpl extends AbstractVisitor<Appender> {
	
	@Override
	public void visit(Workflow workflow, Appender arg) {
		arg.append(workflow.name);
		arg.newLine();
		visitChildren(workflow.children, arg);
	}
	
	@Override
	public void visit(Events events, Appender arg) {
		visitWithIndents(events, arg);
		arg.newLine();
	}
	
	@Override
	public void visit(Push push, Appender arg) {
		push.name.accept(this, arg);
		arg.increaseIndent();
		visitChildren(push.children, arg);
		arg.decreaseIndent();
	}
	
	@Override
	public void visit(PullRequest pullRequest, Appender arg) {
		visitWithIndents(pullRequest, arg);
	}
	
	private void visitWithIndents(Nodes nodes, Appender arg) {
		arg.append(nodes.name).newLine();
		arg.increaseIndent();
		visitChildren(nodes.children, arg);
		arg.decreaseIndent();
	}
	
	@Override
	public void visit(WorkflowDispatch workflowDispatch, Appender arg) {
		visitWithIndents(workflowDispatch, arg);
	}
	
	@Override
	public void visit(PullRequestTarget workflowDispatch, Appender arg) {
		visitWithIndents(workflowDispatch, arg);
	}
	
	@Override
	public void visit(Schedule schedule, Appender arg) {
		visitWithIndents(schedule, arg);
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
		if (!options.children.isEmpty()) {
			arg.newLine();
		}
		visitWithIndents(options, arg);
	}
	
	@Override
	public void visit(Environments environments, Appender arg) {
		visitWithIndents(environments, arg);
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
	public void visit(Step jobs, Appender arg) {
		visitWithIndents(jobs, arg);
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
	public void visit(Volumes volumes, Appender arg) {
		visitWithIndents(volumes, arg);
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
		arg.append(output.name);
		arg.increaseIndent();
		visitChildren(output.inputElements, arg);
		arg.decreaseIndent();
		arg.newLine();
	}
	
	@Override
	public void visit(DashQuotedSingleElement dashQuotedSingleElement, Appender arg) {
		arg.append(dashQuotedSingleElement.toString());
		arg.newLine();
	}
	
	@Override
	public void visit(InOutElement inOutElement, Appender arg) {
		arg.newLine();
		arg.append(inOutElement.toString());
	}
	
	@Override
	public void visit(Input input, Appender arg) {
		arg.append(input.name);
		arg.increaseIndent();
		visitChildren(input.inputElements, arg);
		arg.decreaseIndent();
	}
	
	@Override
	public void visit(NameValuePair nameValuePair, Appender arg) {
		arg.append(nameValuePair);
		arg.newLine();
	}
	
}

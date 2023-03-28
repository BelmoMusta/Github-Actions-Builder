package org.example.visitor;

import org.example.Appender;
import org.example.PullRequest;
import org.example.Push;
import org.example.Workflow;
import org.example.WorkflowDispatch;
import org.example.collections.Branches;
import org.example.collections.Events;
import org.example.collections.Inputs;
import org.example.collections.Nodes;
import org.example.collections.Options;
import org.example.collections.Paths;
import org.example.collections.Tags;
import org.example.wrappers.DashQuotedSingleElement;
import org.example.wrappers.InOutElement;
import org.example.wrappers.Input;
import org.example.wrappers.NameValuePair;

public class DefaultVisitorImpl extends AbstractVisitor<Appender> {
	
	@Override
	public void visit(Workflow workflow, Appender arg) {
		arg.append(workflow.name);
		arg.newLine();
		visitChildren(workflow.children, arg);
	}
	
	@Override
	public void visit(Events events, Appender arg) {
		arg.append(events.name);
		arg.newLine();
		arg.indent++;
		visitChildren(events.children, arg);
		arg.indent--;
	}
	
	@Override
	public void visit(Push push, Appender arg) {
		push.name.accept(this, arg);
		arg.indent++;
		visitChildren(push.children, arg);
		arg.indent--;
	}
	
	@Override
	public void visit(PullRequest pullRequest, Appender arg) {
		visitWithIndents(pullRequest, arg);
	}
	
	private void visitWithIndents(Nodes nodes, Appender arg) {
		arg.append(nodes.name).newLine();
		arg.indent++;
		visitChildren(nodes.children, arg);
		arg.indent--;
	}
	
	@Override
	public void visit(WorkflowDispatch workflowDispatch, Appender arg) {
		visitWithIndents(workflowDispatch, arg);
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
		arg.indent++;
		visitChildren(input.inputElements, arg);
		arg.indent--;
	}
	
	@Override
	public void visit(NameValuePair nameValuePair, Appender arg) {
		arg.append(nameValuePair);
		arg.newLine();
	}
	
}

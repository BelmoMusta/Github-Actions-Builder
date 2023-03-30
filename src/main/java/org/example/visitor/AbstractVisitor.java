package org.example.visitor;

import org.example.Container;
import org.example.Environment;
import org.example.Image;
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
import org.example.collections.Types;
import org.example.collections.Volumes;
import org.example.collections.Withs;
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

import java.util.Collection;

public abstract class AbstractVisitor<A> implements Visitor<A> {
	
	
	protected void visitChildren(Collection<? extends Node> children, A arg, boolean addNewLine) {
		for (Node child : children) {
			child.accept(this, arg);
		}
	}
	
	@Override
	public void visit(Branches branches, A arg) {
	}
	
	@Override
	public void visit(BranchesIgnore branchesIgnore, A arg) {
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
	public void visit(DashedNameValuePair dashedNameValuePair, A arg) {
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
	public void visit(InOutElement inOutElement, A arg) {
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
	public void visit(Workflow workflow, A arg) {
	}
	
	@Override
	public void visit(WorkflowDispatch workflowDispatch, A arg) {
	}
	
}

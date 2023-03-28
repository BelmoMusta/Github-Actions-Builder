package org.example.visitor;

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
import org.example.wrappers.Output;
import org.example.wrappers.SingleElement;
import org.example.wrappers.Tag;

public interface ValuedVisitor<A, R> {
	R visit(Workflow workflow, A arg);
	
	R visit(WorkflowEvent workflowEvent, A arg);
	
	R visit(Paths paths, A arg);
	
	R visit(Tags tags, A arg);
	
	R visit(Branches branches, A arg);
	
	R visit(BranchesIgnore branchesIgnore, A arg);
	
	R visit(Environments environments, A arg);
	
	R visit(Events events, A arg);
	
	R visit(Inputs inputs, A arg);
	
	R visit(Jobs jobs, A arg);
	
	R visit(Needs needs, A arg);
	
	R visit(Nodes nodes, A arg);
	
	R visit(Options options, A arg);
	
	R visit(Outputs outputs, A arg);
	
	R visit(Ports ports, A arg);
	
	R visit(Services services, A arg);
	
	R visit(Steps steps, A arg);
	
	R visit(SubNode subNode, A arg);
	
	R visit(Types types, A arg);
	
	R visit(Volumes volumes, A arg);
	
	R visit(DashedNameValuePair dashedNameValuePair, A arg);
	
	R visit(DashQuotedSingleElement dashQuotedSingleElement, A arg);
	
	R visit(DashSingleElement dashSingleElement, A arg);
	
	R visit(InOut inOut, A arg);
	
	R visit(InOutElement inOutElement, A arg);
	
	R visit(Input input, A arg);
	
	R visit(LabeledDashedName labeledDashedName, A arg);
	
	R visit(LabeledName labeledName, A arg);
	
	R visit(NameValuePair nameValuePair, A arg);
	
	R visit(Output output, A arg);
	
	R visit(SingleElement singleElement, A arg);
	
	R visit(Tag tag, A arg);
	
	
	R visit(Container container, A arg);
	
	R visit(Environment environment, A arg);
	
	R visit(Image image, A arg);
	
	R visit(Job job, A arg);
	
	R visit(PullRequest pullRequest, A arg);
	
	R visit(PullRequestTarget pullRequestTarget, A arg);
	
	R visit(Push push, A arg);
	
	R visit(Schedule schedule, A arg);
	
	R visit(Service service, A arg);
	
	R visit(Step step, A arg);
	
	R visit(Volume volume, A arg);
	
	R visit(WorkflowDispatch workflowDispatch, A arg);
	
	R visit(WorkflowEventWithBranches workflowEventWithBranches, A arg);
	
}

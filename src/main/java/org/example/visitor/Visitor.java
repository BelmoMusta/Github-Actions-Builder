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
import org.example.wrappers.DashedId;
import org.example.wrappers.DashedNameValuePair;
import org.example.wrappers.InOut;
import org.example.wrappers.InOutElement;
import org.example.wrappers.Input;
import org.example.wrappers.LabeledDashedName;
import org.example.wrappers.LabeledName;
import org.example.wrappers.NameValuePair;
import org.example.wrappers.Output;
import org.example.wrappers.SimpleEntry;
import org.example.wrappers.SingleElement;

public interface Visitor<A> {
	void support(Visitor<A> anotherVisitor);
	void visit(Workflow workflow, A arg);
	
	void visit(Paths paths, A arg);
	
	void visit(Tags tags, A arg);
	
	void visit(Branches branches, A arg);
	
	void visit(BranchesIgnore branchesIgnore, A arg);
	
	void visit(Environments environments, A arg);
	void visit(Withs environments, A arg);
	
	void visit(Events events, A arg);
	
	void visit(Inputs inputs, A arg);
	
	void visit(Pipe pipe, A arg);
	
	void visit(Jobs jobs, A arg);

	void visit(Needs needs, A arg);

 
	void visit(Options options, A arg);

	void visit(Outputs outputs, A arg);

	void visit(Ports ports, A arg);

	void visit(Services services, A arg);

	void visit(Steps steps, A arg);

 
	void visit(Types types, A arg);

	void visit(Volumes volumes, A arg);
	
	void visit(DashedNameValuePair dashedNameValuePair, A arg);
	void visit(DashQuotedSingleElement dashQuotedSingleElement, A arg);
	void visit(DashSingleElement dashSingleElement, A arg);
	void visit(InOut inOut, A arg);
	void visit(InOutElement<?> inOutElement, A arg);
	void visit(Input input, A arg);
	void visit(LabeledDashedName labeledDashedName, A arg);
	void visit(LabeledName labeledName, A arg);
	void visit(NameValuePair nameValuePair, A arg);
	void visit(Output output, A arg);
	void visit(SingleElement singleElement, A arg);
	void visit(SimpleEntry simpleEntry, A arg);
	void visit(DashedId dashedId, A arg);
	
	void visit(Container container, A arg);
	void visit(Environment environment, A arg);
	void visit(Image image, A arg);
	void visit(Job job, A arg);
	void visit(PullRequest pullRequest, A arg);
	void visit(PullRequestTarget pullRequestTarget, A arg);
	void visit(Push push, A arg);
	void visit(Schedule schedule, A arg);
	void visit(Service service, A arg);
	void visit(Step step, A arg);
	void visit(Volume volume, A arg);
	void visit(WorkflowDispatch workflowDispatch, A arg);
	
 
}

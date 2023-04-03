package org.example.visitor;

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
import org.example.collections.PathsIgnore;
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
import org.example.wrappers.InOut;
import org.example.wrappers.InOutElement;
import org.example.wrappers.Input;
import org.example.wrappers.LabeledDashedName;
import org.example.wrappers.LabeledName;
import org.example.wrappers.NameValuePair;
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
import org.example.yy.Fork;
import org.example.yy.Gollum;
import org.example.yy.Image;
import org.example.yy.IssueComment;
import org.example.yy.Issues;
import org.example.yy.Job;
import org.example.yy.Label;
import org.example.yy.MergeGroup;
import org.example.yy.Milestone;
import org.example.yy.PageBuild;
import org.example.yy.Pipe;
import org.example.yy.Project;
import org.example.yy.ProjectCard;
import org.example.yy.ProjectColumn;
import org.example.yy.Public;
import org.example.yy.PullRequest;
import org.example.yy.PullRequestComment;
import org.example.yy.PullRequestTarget;
import org.example.yy.Push;
import org.example.yy.Release;
import org.example.yy.Schedule;
import org.example.yy.Service;
import org.example.yy.Step;
import org.example.yy.Volume;
import org.example.yy.Workflow;
import org.example.yy.WorkflowDispatch;

public interface VoidVisitor<R> {
	
	R getFinalResult();
	void visit(BranchProtectionRule branchProtectionRule);
	
	void visit(Branches branches);
	
	void visit(BranchesIgnore branchesIgnore);
	
	void visit(CheckRun checkRun);
	
	void visit(CheckSuite checkSuite);
	
	void visit(Container container);
	
	void visit(Create create);
	
	void visit(DashQuotedSingleElement dashQuotedSingleElement);
	
	void visit(DashSingleElement dashSingleElement);
	
	void visit(DashedId dashedId);
	
	void visit(DashedNameQuotedValuePair dashedNameQuotedValuePair);
	
	void visit(DashedNameValuePair dashedNameQuotedValuePair);
	
	void visit(Delete release);
	
	void visit(Deployment deployment);
	
	void visit(DeploymentStatus deploymentStatus);
	
	void visit(Discussion deploymentStatus);
	
	void visit(DiscussionComment release);
	
	void visit(Environment environment);
	
	void visit(Environments environments);
	
	void visit(Events events);
	void visit(Fork fork);
	void visit(Gollum gollum);
	
	void visit(Image image);
	void visit(IssueComment issueComment);
	void visit(Issues issues);
	void visit(Label label);
	void visit(MergeGroup mergeGroup);
	void visit(Milestone milestone);
	void visit(PageBuild pageBuild);
	void visit(Project project);
	
	void visit(ProjectCard projectCard);
	void visit(ProjectColumn projectColumn);
	void visit(Public aPublic);
	void visit(PullRequestComment pullRequestComment);
	
	void visit(InOut inOut);
	
	void visit(InOutElement<?> inOutElement);
	
	void visit(Input input);
	
	void visit(Inputs inputs);
	
	void visit(Job job);
	
	void visit(Jobs jobs);
	
	void visit(LabeledDashedName labeledDashedName);
	
	void visit(LabeledName labeledName);
	
	void visit(NameValuePair nameValuePair);
	
	void visit(Needs needs);
	
	void visit(Options options);
	
	void visit(Output output);
	
	void visit(Outputs outputs);
	
	void visit(Paths paths);
	void visit(PathsIgnore paths);
	
	void visit(Pipe pipe);
	
	void visit(Ports ports);
	
	void visit(PullRequest pullRequest);
	
	void visit(PullRequestTarget pullRequestTarget);
	
	void visit(Push push);
	
	void visit(Release release);
	
	void visit(Schedule schedule);
	
	void visit(Service service);
	
	void visit(Services services);
	
	void visit(SimpleEntry simpleEntry);
	
	void visit(SingleElement singleElement);
	
	void visit(Step step);
	
	void visit(Steps steps);
	
	void visit(Tags tags);
	
	void visit(Types types);
	
	void visit(Volume volume);
	
	void visit(Volumes volumes);
	
	void visit(Withs environments);
	
	void visit(Workflow workflow);
	
	void visit(WorkflowDispatch workflowDispatch);
	
}

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

public interface Visitor<A> {
	void visit(Concurrency workflow, A arg);
	void visit(Credentials workflow, A arg);
	void visit(Defaults defaults, A arg);
	void visit(Run run, A arg);
	void visit(Permissions permissions, A arg);
	void visit(Workflow workflow, A arg);
	void visit(Workflows workflow, A arg);
	
	void visit(Paths paths, A arg);
	void visit(Cron cron, A arg);
	void visit(PathsIgnore paths, A arg);
	
	void visit(Tags tags, A arg);
	
	void visit(Branches branches, A arg);
	
	void visit(BranchesIgnore branchesIgnore, A arg);
	void visit(TagsIgnore tagsIgnore, A arg);
	void visit(RegistryPackage registryPackage, A arg);
	
	void visit(Environments environments, A arg);
	void visit(Withs environments, A arg);
	
	void visit(Events events, A arg);
	
	void visit(Inputs inputs, A arg);
	void visit(Secrets secrets, A arg);
	void visit(WorkflowRun workflowRun, A arg);
	
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
	
	void visit(DashedNameQuotedValuePair dashedNameQuotedValuePair, A arg);
	
	void visit(DashedNameValuePair dashedNameQuotedValuePair, A arg);
	
	void visit(DashQuotedSingleElement dashQuotedSingleElement, A arg);
	void visit(DashSingleElement dashSingleElement, A arg);
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
	void visit(Job job, A arg);
	void visit(PullRequest pullRequest, A arg);
	void visit(PullRequestTarget pullRequestTarget, A arg);
	void visit(RepositoryDispatch repositoryDispatch, A arg);
	void visit(Push push, A arg);
	void visit(Release release, A arg);
	void visit(Delete release, A arg);
	void visit(DiscussionComment release, A arg);
	void visit(DeploymentStatus deploymentStatus, A arg);
	void visit(Discussion deploymentStatus, A arg);
	void visit(BranchProtectionRule branchProtectionRule, A arg);
	void visit(CheckRun checkRun, A arg);
	void visit(Create create, A arg);
	void visit(Fork fork, A arg);
	void visit(Gollum gollum, A arg);
	void visit(IssueComment issueComment, A arg);
	void visit(Issues issues, A arg);
	void visit(Label issues, A arg);
	void visit(MergeGroup mergeGroup, A arg);
	void visit(Milestone milestone, A arg);
	void visit(PageBuild pageBuild, A arg);
	void visit(Project project, A arg);
	void visit(ProjectCard projectCard, A arg);
	void visit(ProjectColumn projectColumn, A arg);
	void visit(Public aPublic, A arg);
	void visit(Status aPublic, A arg);
	
	void visit(Watch watch, A arg);
	
	void visit(WorkflowCall workflowCall, A arg);
	void visit(Secret secret, A arg);
	
	void visit(PullRequestComment pullRequestComment, A arg);
	void visit(PullRequestReview pullRequestReview, A arg);
	void visit(PullRequestReviewComment pullRequestReviewComment, A arg);
	void visit(CheckSuite checkSuite, A arg);
	void visit(Deployment deployment, A arg);
	void visit(Schedule schedule, A arg);
	void visit(Service service, A arg);
	void visit(Step step, A arg);
	void visit(Volume volume, A arg);
	void visit(WorkflowDispatch workflowDispatch, A arg);
	
 
}

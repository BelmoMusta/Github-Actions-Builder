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
import org.example.wrappers.leaves.Credentials;
import org.example.wrappers.leaves.DashQuotedSingleElement;
import org.example.wrappers.leaves.DashSingleElement;
import org.example.wrappers.leaves.DashedId;
import org.example.wrappers.leaves.DashedNameQuotedValuePair;
import org.example.wrappers.leaves.DashedNameValuePair;
import org.example.wrappers.leaves.InOutElement;
import org.example.wrappers.leaves.Input;
import org.example.wrappers.leaves.LabeledDashedName;
import org.example.wrappers.leaves.LabeledName;
import org.example.wrappers.leaves.NameValuePair;
import org.example.wrappers.leaves.Output;
import org.example.wrappers.leaves.Secret;
import org.example.wrappers.leaves.SimpleEntry;
import org.example.wrappers.leaves.SingleElement;
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
import org.example.yy.Matrix;
import org.example.yy.MatrixElement;
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
import org.example.yy.Strategy;
import org.example.yy.Volume;
import org.example.yy.Watch;
import org.example.yy.Workflow;
import org.example.yy.WorkflowCall;
import org.example.yy.WorkflowDispatch;
import org.example.yy.WorkflowRun;

public interface Visitor<R> {
    void visit(Concurrency workflow);

    void visit(Strategy strategy);

    void visit(Matrix strategy);

    void visit(MatrixElement matrixElement);

    void visit(Credentials workflow);

    void visit(Defaults defaults);

    void visit(Run run);

    void visit(Permissions permissions);

    void visit(Workflow workflow);

    void visit(Workflows workflow);

    void visit(Paths paths);

    void visit(Cron cron);

    void visit(PathsIgnore paths);

    void visit(Tags tags);

    void visit(Branches branches);

    void visit(BranchesIgnore branchesIgnore);

    void visit(TagsIgnore tagsIgnore);

    void visit(RegistryPackage registryPackage);

    void visit(Environments environments);

    void visit(Withs environments);

    void visit(Events events);

    void visit(Inputs inputs);

    void visit(Secrets secrets);

    void visit(WorkflowRun workflowRun);

    void visit(Pipe pipe);

    void visit(Jobs jobs);

    void visit(Needs needs);


    void visit(Options options);

    void visit(Outputs outputs);

    void visit(Ports ports);

    void visit(Services services);

    void visit(Steps steps);


    void visit(Types types);

    void visit(Volumes volumes);

    void visit(DashedNameQuotedValuePair dashedNameQuotedValuePair);

    void visit(DashedNameValuePair dashedNameQuotedValuePair);

    void visit(DashQuotedSingleElement dashQuotedSingleElement);

    void visit(DashSingleElement dashSingleElement);

    void visit(InOutElement<?> inOutElement);

    void visit(Input input);

    void visit(LabeledDashedName labeledDashedName);

    void visit(LabeledName labeledName);

    void visit(NameValuePair nameValuePair);

    void visit(Output output);

    void visit(SingleElement singleElement);

    void visit(SimpleEntry simpleEntry);

    void visit(DashedId dashedId);

    void visit(Container container);

    void visit(Environment environment);

    void visit(Job job);

    void visit(PullRequest pullRequest);

    void visit(PullRequestTarget pullRequestTarget);

    void visit(RepositoryDispatch repositoryDispatch);

    void visit(Push push);

    void visit(Release release);

    void visit(Delete release);

    void visit(DiscussionComment release);

    void visit(DeploymentStatus deploymentStatus);

    void visit(Discussion deploymentStatus);

    void visit(BranchProtectionRule branchProtectionRule);

    void visit(CheckRun checkRun);

    void visit(Create create);

    void visit(Fork fork);

    void visit(Gollum gollum);

    void visit(IssueComment issueComment);

    void visit(Issues issues);

    void visit(Label issues);

    void visit(MergeGroup mergeGroup);

    void visit(Milestone milestone);

    void visit(PageBuild pageBuild);

    void visit(Project project);

    void visit(ProjectCard projectCard);

    void visit(ProjectColumn projectColumn);

    void visit(Public aPublic);

    void visit(Status aPublic);

    void visit(Watch watch);

    void visit(WorkflowCall workflowCall);

    void visit(Secret secret);

    void visit(PullRequestComment pullRequestComment);

    void visit(PullRequestReview pullRequestReview);

    void visit(PullRequestReviewComment pullRequestReviewComment);

    void visit(CheckSuite checkSuite);

    void visit(Deployment deployment);

    void visit(Schedule schedule);

    void visit(Service service);

    void visit(Step step);

    void visit(Volume volume);

    void visit(WorkflowDispatch workflowDispatch);

    R getResult();

}

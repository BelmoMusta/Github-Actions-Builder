package org.example.visitor;

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
import org.example.wrappers.Node;
import org.example.wrappers.leaves.Credentials;
import org.example.wrappers.leaves.DashQuotedSingleElement;
import org.example.wrappers.leaves.DashSingleElement;
import org.example.wrappers.leaves.DashedId;
import org.example.wrappers.leaves.DashedNameQuotedValuePair;
import org.example.wrappers.leaves.DashedNameValuePair;
import org.example.wrappers.leaves.InOut;
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StringPrinterVisitor implements Visitor<String> {

    private final Appender appender_ = new Appender();

    @Override
    public void visit(Concurrency concurrency) {
        refactored(concurrency, false);
    }

    @Override
    public void visit(Strategy strategy) {
        refactored(strategy, false);
    }

    @Override
    public void visit(Matrix strategy) {
        refactored(strategy, false);
    }


    @Override
    public void visit(MatrixElement matrixElement) {
        refactored(matrixElement, true);
    }

    @Override
    public void visit(Credentials credentials) {
        visitInOut(credentials);
    }

    @Override
    public void visit(Defaults defaults) {
        refactored(defaults, false);

    }

    @Override
    public void visit(Run run) {
        refactored(run, false);

    }

    @Override
    public void visit(Permissions permissions) {
        refactored(permissions, false);

    }

    @Override
    public void visit(Workflow workflow) {
        workflow.name.accept(this);
        visitChildren(workflow.children, true, false);

    }

    @Override
    public void visit(Workflows workflows) {
        refactored(workflows, false);

    }

    @Override
    public void visit(Events events) {
        refactored(events, false);

    }

    @Override
    public void visit(Push push) {
        refactored(push, false);

    }

    @Override
    public void visit(Release release) {
        refactored(release, false);

    }

    @Override
    public void visit(Delete delete) {
        refactored(delete, false);

    }

    @Override
    public void visit(DiscussionComment discussionComment) {
        refactored(discussionComment, false);

    }

    @Override
    public void visit(DeploymentStatus deploymentStatus) {
        refactored(deploymentStatus, false);

    }

    @Override
    public void visit(Discussion discussion) {
        refactored(discussion, false);

    }

    @Override
    public void visit(BranchProtectionRule branchProtectionRule) {
        refactored(branchProtectionRule, false);

    }

    public void refactored(Nodes nodes, boolean inlineArray) {
        nodes.name.accept(this);
        appender_.increaseIndent();
        visitChildren(nodes.children, true, inlineArray);
        appender_.decreaseIndent();
    }

    @Override
    public void visit(CheckRun checkRun) {
        refactored(checkRun, false);

    }

    @Override
    public void visit(Create create) {
        refactored(create, false);

    }

    @Override
    public void visit(Fork fork) {
        refactored(fork, false);

    }

    @Override
    public void visit(Gollum fork) {
        refactored(fork, false);

    }

    @Override
    public void visit(IssueComment issueComment) {
        refactored(issueComment, false);

    }

    @Override
    public void visit(Issues issues) {
        refactored(issues, false);

    }

    @Override
    public void visit(Label label) {
        refactored(label, false);

    }

    @Override
    public void visit(MergeGroup mergeGroup) {
        refactored(mergeGroup, false);

    }

    @Override
    public void visit(Milestone milestone) {
        refactored(milestone, false);

    }

    @Override
    public void visit(PageBuild pageBuild) {
        refactored(pageBuild, false);

    }

    @Override
    public void visit(Project project) {
        refactored(project, false);

    }

    @Override
    public void visit(ProjectCard projectCard) {
        refactored(projectCard, false);

    }

    @Override
    public void visit(ProjectColumn projectColumn) {
        refactored(projectColumn, false);

    }

    @Override
    public void visit(Public aPublic) {
        refactored(aPublic, false);

    }

    @Override
    public void visit(Status status) {
        refactored(status, false);

    }

    @Override
    public void visit(Watch watch) {
        refactored(watch, false);

    }

    @Override
    public void visit(WorkflowCall workflowCall) {
        refactored(workflowCall, false);

    }

    @Override
    public void visit(Secret secret) {
        visitInOut(secret);

    }

    @Override
    public void visit(PullRequestComment pullRequestComment) {
        refactored(pullRequestComment, false);

    }

    @Override
    public void visit(PullRequestReview pullRequestReview) {
        refactored(pullRequestReview, false);

    }

    @Override
    public void visit(PullRequestReviewComment pullRequestReviewComment) {
        refactored(pullRequestReviewComment, false);

    }

    @Override
    public void visit(CheckSuite checkSuite) {
        refactored(checkSuite, false);

    }

    @Override
    public void visit(Deployment deployment) {
        refactored(deployment, false);

    }

    @Override
    public void visit(PullRequest pullRequest) {
        refactored(pullRequest, false);

    }

    @Override
    public void visit(WorkflowDispatch workflowDispatch) {
        refactored(workflowDispatch, false);

    }


    @Override
    public void visit(PullRequestTarget pullRequestTarget) {
        refactored(pullRequestTarget, false);

    }

    @Override
    public void visit(RepositoryDispatch repositoryDispatch) {
        refactored(repositoryDispatch, false);

    }

    @Override
    public void visit(Schedule schedule) {
        refactored(schedule, false);

    }

    protected void visitChildren(Collection<? extends Node> children, boolean addNewLine, boolean inlineArray) {
        List<Node> nodes = new ArrayList<>(children);
        if (inlineArray) {
            appender_.append(" [");
            for (int i = 0; i < nodes.size(); i++) {
                appender_.appendWithQuotes(nodes.get(i).get(), false);
                if(i<nodes.size()-1){
                    appender_.append(", ");
                }
            }
            appender_.append("]");
        } else {
            if (addNewLine && !children.isEmpty()) {
                appender_.newLine();
            }

            for (int i = 0; i < nodes.size(); i++) {
                nodes.get(i).accept(this);
                if (i < nodes.size() - 1) {
                    appender_.newLine();
                }
            }
        }
    }

    @Override
    public void visit(Branches branches) {
        refactored(branches, true);

    }

    @Override
    public void visit(BranchesIgnore branchesIgnore) {
        refactored(branchesIgnore, false);

    }

    @Override
    public void visit(TagsIgnore tagsIgnore) {
        refactored(tagsIgnore, false);

    }

    @Override
    public void visit(RegistryPackage registryPackage) {
        refactored(registryPackage, false);

    }

    @Override
    public void visit(Paths paths) {
        refactored(paths, false);

    }

    @Override
    public void visit(Cron cron) {
        appender_.append(cron.toString());

    }

    @Override
    public void visit(PathsIgnore paths) {
        refactored(paths, false);

    }

    @Override
    public void visit(Tags tags) {
        refactored(tags, false);

    }

    @Override
    public void visit(Types types) {
        refactored(types, false);

    }

    @Override
    public void visit(Inputs inputs) {
        refactored(inputs, false);

    }

    @Override
    public void visit(Secrets secrets) {
        refactored(secrets, false);

    }

    @Override
    public void visit(WorkflowRun workflowRun) {
        refactored(workflowRun, false);

    }

    @Override
    public void visit(Options options) {
        refactored(options, false);

    }

    @Override
    public void visit(Environments environments) {
        refactored(environments, false);

    }

    @Override
    public void visit(Withs withs) {
        refactored(withs, false);

    }

    @Override
    public void visit(Pipe pipe) {
        appender_.increaseIndent();
        visitChildren(pipe.children, false, false);
        appender_.decreaseIndent();

    }

    @Override
    public void visit(Jobs jobs) {
        refactored(jobs, false);

    }

    @Override
    public void visit(Steps jobs) {
        refactored(jobs, false);

    }

    @Override
    public void visit(Step step) {
        List<Node> nodes = new ArrayList<>(step.children);
        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            if (i == 0) {
                node.accept(this);
            } else {
                appender_.increaseIndent();
                node.accept(this);
                appender_.decreaseIndent();
            }
            if (i < nodes.size() - 1) {
                appender_.newLine();

            }
        }

    }

    @Override
    public void visit(Needs jobs) {
        refactored(jobs, false);

    }

    @Override
    public void visit(Container container) {
        refactored(container, false);

    }

    @Override
    public void visit(Environment environment) {
        appender_.indent();
        appender_.append(environment.getName());
        appender_.append(": ");
        appender_.append(environment.getValue());

    }

    @Override
    public void visit(Volumes volumes) {
        refactored(volumes, false);

    }

    @Override
    public void visit(Volume volumes) {
        appender_.indent();
        appender_.append("- ");
        appender_.append(volumes.getName());
        appender_.append(":");
        appender_.append(volumes.getValue());

    }

    @Override
    public void visit(DashedId id) {
        appender_.indent();
        appender_.append("- ");
        appender_.append(id.getName());
        appender_.append(": ");
        appender_.append(id.getValue());

    }


    @Override
    public void visit(Services services) {
        refactored(services, false);

    }

    @Override
    public void visit(Service volumes) {
        refactored(volumes, false);

    }

    @Override
    public void visit(Ports ports) {
        refactored(ports, false);

    }

    @Override
    public void visit(Job job) {
        if (job.label != null) {
            job.label.accept(this);


        }
        appender_.increaseIndent();
        visitChildren(job.children, true, false);
        appender_.decreaseIndent();


    }

    @Override
    public void visit(Outputs outputs) {
        refactored(outputs, false);

    }

    @Override
    public void visit(Output output) {
        visitInOut(output);

    }

    @Override
    public void visit(DashQuotedSingleElement dashQuotedSingleElement) {
        appender_.indent();
        appender_.append("- ");
        appender_.appendSingleQuote(dashQuotedSingleElement.getValue());

    }

    @Override
    public void visit(DashSingleElement dashQuotedSingleElement) {
        appender_.indent();
        appender_.append("- ");
        appender_.append(dashQuotedSingleElement.getValue());

    }


    @Override
    public void visit(DashedNameQuotedValuePair dashedNameQuotedValuePair) {
        appender_.indent();
        appender_.append("- ");
        appender_.append(dashedNameQuotedValuePair.getName());
        appender_.append(": ");
        appender_.appendSingleQuote(dashedNameQuotedValuePair.getValue());

    }

    @Override
    public void visit(DashedNameValuePair dashedNameQuotedValuePair) {
        appender_.indent();
        appender_.append("- ");
        appender_.append(dashedNameQuotedValuePair.getName());
        appender_.append(": ");
        appender_.append(dashedNameQuotedValuePair.getValue());

    }

    @Override
    public void visit(LabeledDashedName labeledDashedName) {
        appender_.indent();
        appender_.append("- ");
        appender_.append(labeledDashedName.getName());
        appender_.append(": ");
        appender_.append(labeledDashedName.getValue());

    }

    @Override
    public void visit(SingleElement singleElement) {
        appender_.indent();
        appender_.append(singleElement.getValue());
        appender_.append(":");

    }

    @Override
    public void visit(SimpleEntry simpleEntry) {
        appender_.indent();
        appender_.append(simpleEntry.getValue());

    }

    @Override
    public void visit(InOutElement<?> inOutElement) {
        appender_.indent();
        appender_.append(inOutElement.getName());
        appender_.append(": ");
        if (inOutElement.withDoubleQuotes()) {
            appender_.appendDoubleQuote(inOutElement.getValue());
        } else {
            appender_.append(inOutElement.getValue());
        }

    }

    @Override
    public void visit(LabeledName labeledName) {
        appender_.indent();
        appender_.append(labeledName.getName());
        appender_.append(": ");
        appender_.append(labeledName.getValue());

    }

    @Override
    public void visit(Input input) {
        visitInOut(input);

    }

    private void visitInOut(InOut input) {
        input.name.accept(this);
        appender_.increaseIndent();
        visitChildren(input.inputElements, true, false);
        appender_.decreaseIndent();
    }

    @Override
    public void visit(NameValuePair nameValuePair) {
        appender_.indent();
        appender_.append(nameValuePair.getName());
        appender_.append(": ");
        appender_.append(nameValuePair.getValue());
    }

    @Override
    public String getResult() {
        return appender_.toString();
    }

}

package org.example.yy;

import org.example.visitor.Visitor;
import org.example.yy.support.BranchesIgnoreSupport;
import org.example.yy.support.BranchesSupport;
import org.example.yy.support.PathsIgnoreSupport;
import org.example.yy.support.TypesSupport;

public class PullRequestTarget extends WorkflowEvent implements
        BranchesSupport,
        BranchesIgnoreSupport,
        PathsSupport,
        PathsIgnoreSupport,
        TypesSupport {

    protected PullRequestTarget() {
        super("pull_request_target");
    }

    public static PullRequestTarget $() {
        return new PullRequestTarget();
    }

    public PullRequestTarget branches(String... branches) {
        return addBranches(this, branches);
    }

    public PullRequestTarget branchesIgnore(String... branches) {
        return addBranchesIgnore(this, branches);
    }

    public PullRequestTarget paths(String... paths) {
        return addPaths(this, paths);
    }

    public PullRequestTarget types(Type... types) {
        return addTypes(this, types);
    }

    public PullRequestTarget pathsIgnore(String... paths) {
        return addPathsIgnore(this, paths);
    }

    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }

    public enum Type implements TypeI {
        ASSIGNED,
        AUTO_MERGE_DISABLED,
        AUTO_MERGE_ENABLED,
        CLOSED,
        CONVERTED_TO_DRAFT,
        EDITED,
        LABELED,
        LOCKED,
        OPENED,
        READY_FOR_REVIEW,
        REOPENED,
        REVIEW_REQUEST_REMOVED,
        REVIEW_REQUESTED,
        SYNCHRONIZE,
        UNASSIGNED,
        UNLABELED,
        UNLOCKED,

        ;

        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }
    }
}

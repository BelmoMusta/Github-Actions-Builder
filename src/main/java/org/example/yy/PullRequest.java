package org.example.yy;

import org.example.visitor.Visitor;
import org.example.yy.support.BranchesIgnoreSupport;
import org.example.yy.support.BranchesSupport;
import org.example.yy.support.PathsIgnoreSupport;
import org.example.yy.support.TypesSupport;

public class PullRequest extends WorkflowEvent implements BranchesSupport,
        PathsSupport,
        BranchesIgnoreSupport,
        PathsIgnoreSupport, TypesSupport {

    protected PullRequest() {
        super("pull_request");
    }

    public static PullRequest $() {
        return new PullRequest();
    }

    public PullRequest types(Type... types) {
        return addTypes(this, types);
    }

    public PullRequest paths(String... paths) {
        return addPaths(this, paths);
    }

    public PullRequest pathsIgnore(String... paths) {
        return addPathsIgnore(this, paths);
    }

    public PullRequest branches(String... branches) {
        return addBranches(this, branches);
    }

    public PullRequest branchesIgnore(String... branches) {
        return addBranchesIgnore(this, branches);
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
        REVIEW_REQUESTED,
        REVIEW_REQUEST_REMOVED,
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

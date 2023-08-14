package org.example.yy;

import org.example.visitor.Visitor;
import org.example.yy.support.TypesSupport;

public class PullRequestComment extends WorkflowEvent implements TypesSupport {

    protected PullRequestComment() {
        super("pull_request_comment");
    }
    public static PullRequestComment $() {
        return new PullRequestComment();
    }
    public PullRequestComment types(Type... types) {
        return addTypes(this, types);
    }
    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }

    public enum Type implements TypeI {
        CREATED,
        DELETED,
        EDITED,

        ;

        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }
    }
}

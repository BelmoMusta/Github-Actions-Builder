package org.example.yy;

import org.example.visitor.Visitor;
import org.example.yy.support.TypesSupport;

public class IssueComment extends WorkflowEvent implements TypesSupport {
    public IssueComment() {
        super("issue_comment");
    }

    public static IssueComment $() {
        return new IssueComment();
    }

    public IssueComment types(IssueComment.Type... types) {
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

package org.example.yy;

import org.example.visitor.Visitor;
import org.example.yy.support.TypesSupport;

public class DiscussionComment extends WorkflowEvent implements TypesSupport {
    public DiscussionComment() {
        super("discussion_comment");
    }

    public static DiscussionComment $() {
        return new DiscussionComment();
    }

    public DiscussionComment types(DiscussionComment.Type... types) {
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

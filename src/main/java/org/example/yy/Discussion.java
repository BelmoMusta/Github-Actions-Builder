package org.example.yy;

import org.example.visitor.Visitor;
import org.example.yy.support.TypesSupport;

public class Discussion extends WorkflowEvent implements TypesSupport {
    public Discussion() {
        super("discussion");
    }

    public static Discussion $() {
        return new Discussion();
    }

    public Discussion types(Discussion.Type... types) {
        return addTypes(this, types);
    }

    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }

    public enum Type implements TypeI {
        UNLOCKED,
        ANSWERED,
        CATEGORY_CHANGED,
        CREATED,
        DELETED,
        EDITED,
        LABELED,
        LOCKED,
        PINNED,
        TRANSFERRED,
        UNANSWERED,
        UNLABELED,
        UNPINNED;

        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }
    }
}

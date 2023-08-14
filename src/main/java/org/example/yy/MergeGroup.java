package org.example.yy;

import org.example.visitor.Visitor;
import org.example.yy.support.TypesSupport;

public class MergeGroup extends WorkflowEvent implements TypesSupport {
    public MergeGroup() {
        super("merge_group");
    }

    public static MergeGroup $() {
        return new MergeGroup();
    }

    public MergeGroup types(MergeGroup.Type... types) {
        return addTypes(this, types);
    }

    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }

    public enum Type implements TypeI {
        CHECKS_REQUESTED;

        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }
    }
}

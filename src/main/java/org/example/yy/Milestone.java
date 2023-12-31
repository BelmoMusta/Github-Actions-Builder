package org.example.yy;

import org.example.visitor.Visitor;
import org.example.yy.support.TypesSupport;

public class Milestone extends WorkflowEvent implements TypesSupport {
    public Milestone() {
        super("milestone");
    }

    public static Milestone $() {
        return new Milestone();
    }

    public Milestone types(Milestone.Type... types) {
        return addTypes(this, types);
    }

    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }


    public enum Type implements TypeI {
        CLOSED,
        CREATED,
        DELETED,
        EDITED,
        OPENED;

        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }
    }
}

package org.example.yy;

import org.example.visitor.Visitor;
import org.example.yy.support.TypesSupport;

public class Project extends WorkflowEvent implements TypesSupport {
    public Project() {
        super("project");
    }

    public static Project $() {
        return new Project();
    }

    public Project types(Project.Type... types) {
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
        REOPENED,
        ;

        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }
    }
}

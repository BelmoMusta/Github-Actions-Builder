package org.example.yy;

import org.example.visitor.Visitor;
import org.example.yy.support.TypesSupport;

public class Label extends WorkflowEvent implements TypesSupport {
    public Label() {
        super("label");
    }

    public static Label $() {
        return new Label();
    }

    public Label types(Label.Type... types) {
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

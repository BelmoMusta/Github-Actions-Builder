package org.example.yy;

import org.example.visitor.Visitor;
import org.example.yy.support.TypesSupport;

public class Watch extends WorkflowEvent implements TypesSupport {

    protected Watch() {
        super("watch");
    }
    public static Watch $() {
        return new Watch();
    }
    public Watch types(Type... types) {
        return addTypes(this, types);
    }
    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }

    public enum Type implements TypeI {
        STARTED,

        ;

        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }
    }
}

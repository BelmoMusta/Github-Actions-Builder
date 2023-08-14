package org.example.yy;

import org.example.visitor.Visitor;
import org.example.yy.support.TypesSupport;

public class RegistryPackage extends WorkflowEvent implements TypesSupport {

    protected RegistryPackage() {
        super("registry_package");
    }
    public static RegistryPackage $() {
        return new RegistryPackage();
    }
    public RegistryPackage types(Type... types) {
        return addTypes(this, types);
    }
    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }

    public enum Type implements TypeI {
        PUBLISHED,
        UPDATED;

        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }
    }
}

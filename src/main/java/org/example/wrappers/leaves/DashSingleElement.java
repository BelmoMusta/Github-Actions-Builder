package org.example.wrappers.leaves;

import org.example.visitor.Visitor;

public class DashSingleElement extends SingleElement {
    public DashSingleElement(String value) {
        super(value);
    }

    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }
}

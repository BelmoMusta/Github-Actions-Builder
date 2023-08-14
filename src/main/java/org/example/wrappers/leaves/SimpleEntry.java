package org.example.wrappers.leaves;

import org.example.visitor.Visitor;

public class SimpleEntry extends SingleElement {
    public SimpleEntry(String value) {
        super(value);
    }

    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }
}

package org.example.yy;

import org.example.visitor.Visitor;

public class MatrixElement extends InlinedElementsNode {
    protected MatrixElement(String name) {
        super(name);
    }

    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }
}

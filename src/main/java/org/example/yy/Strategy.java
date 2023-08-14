package org.example.yy;

import org.example.collections.Nodes;
import org.example.visitor.Visitor;

public class Strategy extends Nodes {
    protected Strategy() {
        super("strategy");
    }

    public static Strategy $() {
        return new Strategy();
    }

    public Strategy matrix(Matrix matrix) {
        add(matrix);
        return this;
    }

    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }
}

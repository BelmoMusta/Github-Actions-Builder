package org.example.yy;

import org.example.collections.Nodes;
import org.example.visitor.Visitor;
import org.example.wrappers.leaves.NameValuePair;

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
    public Strategy failFast(boolean value) {
        add(new NameValuePair("fail-fast", value+""));
        return this;
    }
    public Strategy failFast() {
        return failFast(true);
    }

}

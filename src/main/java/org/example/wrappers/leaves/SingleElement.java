package org.example.wrappers.leaves;

import org.example.visitor.Visitor;

public class SingleElement extends NameValuePair {

    public SingleElement(String value) {
        super(null, value);
    }

    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }


}

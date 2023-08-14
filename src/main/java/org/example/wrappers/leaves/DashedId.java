package org.example.wrappers.leaves;

import org.example.visitor.Visitor;

public class DashedId extends Id {
    public DashedId(String value) {
        super(value);
    }

    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }


}

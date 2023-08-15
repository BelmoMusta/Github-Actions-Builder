package org.example.yy;

import org.example.collections.Nodes;
import org.example.visitor.Visitor;
import org.example.wrappers.leaves.NameValuePair;
import org.example.wrappers.leaves.SingleElement;

import java.util.List;

public class Matrix extends Nodes {
    protected Matrix() {
        super("matrix");
    }

    public static Matrix $() {
        return new Matrix();
    }


    public Matrix include(String name, String... values) {
        SingleElement include = new SingleElement("include");
        // todo
        add(include);
        return this;
    }
    public Matrix line(String name, String... values) {
        List<MatrixElement> tags = findTags(MatrixElement.class);
        MatrixElement existing = null;
        for (MatrixElement tag : tags) {
            if (tag.name.get().equals(name)) {
                existing = tag;
                break;
            }
        }
        if (existing == null) {
            existing = new MatrixElement(name);
            add(existing);
        }
        existing.addElements(values);
        return this;
    }

    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }

}

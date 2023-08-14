package org.example.yy;

import org.example.collections.Nodes;
import org.example.wrappers.leaves.SingleElement;

public class InlinedElementsNode extends Nodes {

    protected InlinedElementsNode(String name) {
        super(name);
    }


    public void addElements(String... elements) {
        for (String element : elements) {
            add(new SingleElement(element));
        }

    }
}

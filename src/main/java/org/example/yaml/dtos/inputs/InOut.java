package org.example.yaml.dtos.inputs;

import org.example.collections.Options;
import org.example.wrappers.Node;
import org.example.wrappers.Tag;
import org.example.wrappers.leaves.SingleElement;

import java.util.ArrayList;
import java.util.List;

public class InOut extends Tag {
    public SingleElement name;
    public List<Node> inputElements = new ArrayList<>();
    protected Options options = new Options();


    public enum Type {
        CHOICE,
        ENVIRONMENT,
        BOOLEAN,
        STRING;


    }
}

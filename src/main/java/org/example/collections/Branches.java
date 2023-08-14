package org.example.collections;

import org.example.visitor.Visitor;

public class Branches extends Nodes {
    public static String master(){
        return "master";
    }

    public static String develop(){
        return "develop";
    }
    public Branches() {
        super("branches");
    }

    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }
}

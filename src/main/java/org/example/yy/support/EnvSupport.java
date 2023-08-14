package org.example.yy.support;

import org.example.collections.Environments;
import org.example.collections.Nodes;
import org.example.yy.Environment;

public interface EnvSupport {

    default <N extends Nodes> N getEnv(N node, String name, String value) {
        Environments environments = node.findTag(Environments.class);
        if (environments == null) {
            environments = new Environments();
            node.add(environments);
        }
        Environment environment = new Environment(name, value);
        environments.add(environment);
        return node;
    }
}

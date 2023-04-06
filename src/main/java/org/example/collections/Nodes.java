package org.example.collections;

import org.example.wrappers.LabeledDashedName;
import org.example.wrappers.LabeledName;
import org.example.wrappers.Node;
import org.example.wrappers.SingleElement;
import org.example.wrappers.Tag;
import org.example.yy.Environment;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Nodes extends Tag {
	
	public final Collection<Node> children = new ArrayList<>();
	public  Node name;
	
	public void add(Node tag) {
		children.add(tag);
	}
	
	protected Nodes(String name) {
		this.name = new SingleElement(name);
	}
	
	protected Nodes(String name, boolean nameWithDash) {
		if (nameWithDash) {
			this.name = new LabeledDashedName(name);
		} else {
			this.name = new LabeledName(name);
		}
	}
	
	public <T extends Node> T findTag(Class<T> cls) {
		for (Node tag : children) {
			if (cls == tag.getClass()) {
				return (T) tag;
			}
		}
		return null;
	}
	
	protected static <N extends Nodes> N getEnv(N node, String name, String value){
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

package org.example.collections;

import org.example.wrappers.Node;
import org.example.wrappers.Tag;
import org.example.wrappers.leaves.LabeledDashedName;
import org.example.wrappers.leaves.LabeledName;
import org.example.wrappers.leaves.SingleElement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Nodes extends Tag {
	
	public final Collection<Node> children = new ArrayList<>();
	public Node name;
	
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
	public <T extends Node> List<T> findTags(Class<T> cls) {
		List<Node> list = new ArrayList<>();
		for (Node tag : children) {
			if (cls == tag.getClass()) {
				list.add(tag);
			}
		}
		return (List<T>) list;
	}
}

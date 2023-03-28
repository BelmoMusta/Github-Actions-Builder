package org.example.collections;

import org.example.wrappers.LabeledDashedName;
import org.example.wrappers.LabeledName;
import org.example.wrappers.Node;
import org.example.wrappers.SingleElement;
import org.example.wrappers.Tag;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public abstract class Nodes extends Tag {
	
	public final Collection<Node> children = new ArrayList<>();
	public final Node name;
	
	public void add(Node tag) {
		children.add(tag);
	}
	
	public void add(Node tag, Function<Node, Node> converter) {
		children.add(converter.apply(tag));
	}
	
	public void add(String tag, Function<String, Node> converter) {
		children.add(converter.apply(tag));
	}
	public void addAll(List<String> tags, Function<String, Node> converter) {
		for (String tag : tags) {
			children.add(converter.apply(tag));
		}
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
	
	protected boolean acceptEmptyCollection() {
		return false;
	}
	
	@Override
	public boolean isNotEmpty() {
		return !children.isEmpty();
	}
	
	public <T extends Node> T findTag(Class<T> cls) {
		for (Node tag : children) {
			if (cls == tag.getClass()) {
				return (T) tag;
			}
		}
		return null;
	}
}

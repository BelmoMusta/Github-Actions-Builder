package org.example.collections;

import org.example.Appender;
import org.example.wrappers.Indentable;
import org.example.wrappers.LabeledDashedName;
import org.example.wrappers.LabeledName;
import org.example.wrappers.SingleElement;
import org.example.wrappers.Tag;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCollection extends Indentable {
	public final List<Tag> collection = new ArrayList<>();
	protected final Tag name;
	
	public void add(Tag tag) {
		collection.add(tag);
	}
	
	protected AbstractCollection(String name) {
		this.name = new SingleElement(name);
	}
	
	protected AbstractCollection(String name, boolean nameWithDash) {
		if (nameWithDash) {
			this.name = new LabeledDashedName(name);
		} else {
			this.name = new LabeledName(name);
		}
	}
	
	@Override
	public String toString() {
		Appender appender = new Appender();
		if (acceptEmptyCollection() && collection.isEmpty()) {
			if (!name.isEmpty()) {
				appender.append(name);
			}
		} else if (!collection.isEmpty()) {
			if (!name.isEmpty()) {
				appender.append(name);
				appender.newLine();
			}
			appender.appendCollection(collection);
		}
		return appender.toString();
	}
	
	protected boolean acceptEmptyCollection() {
		return false;
	}
	
	@Override
	public boolean isEmpty() {
		return collection.isEmpty();
	}
	
	public <T extends Tag> T findTag(Class<T> cls) {
		for (Tag tag : collection) {
			if (cls == tag.getClass()) {
				return (T) tag;
			}
		}
		return null;
	}
	
	@Override
	public void setIndentLevel(int indentLevel) {
		super.setIndentLevel(indentLevel);
		for (Tag tag : collection) {
			tag.setIndentLevel(indentLevel);
		}
	}
}

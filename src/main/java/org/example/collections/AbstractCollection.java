package org.example.collections;

import org.example.Appender;
import org.example.wrappers.Tag;
import org.example.wrappers.LabeledDashedName;
import org.example.wrappers.LabeledName;
import org.example.wrappers.SingleElement;
import org.example.wrappers.Indentable;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCollection extends Tag {
	public final List<Indentable> collection = new ArrayList<>();
	public final Indentable name;
	
	public void add(Indentable tag) {
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
			if (name.isNotEmpty()) {
				appender.append(name);
			}
		} else if (!collection.isEmpty()) {
			if (name.isNotEmpty()) {
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
	public boolean isNotEmpty() {
		return !collection.isEmpty();
	}
	
	public <T extends Indentable> T findTag(Class<T> cls) {
		for (Indentable tag : collection) {
			if (cls == tag.getClass()) {
				return (T) tag;
			}
		}
		return null;
	}
	
	@Override
	public void setIndentLevel(int indentLevel) {
		super.setIndentLevel(indentLevel);
		for (Indentable tag : collection) {
			tag.setIndentLevel(indentLevel);
		}
	}
}

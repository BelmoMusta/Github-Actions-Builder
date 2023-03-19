package org.example.collections;

import org.example.Appender;
import org.example.wrappers.DashSingleElement;
import org.example.wrappers.Indentable;
import org.example.wrappers.LabeledName;
import org.example.wrappers.SingleElement;
import org.example.wrappers.Tag;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCollection extends Indentable {
	protected final List<Tag> collection = new ArrayList<>();
	protected final Tag name;
	
	public void add(Tag tag) {
		collection.add(tag);
	}
	
	protected AbstractCollection(String name) {
		this.name = new SingleElement(name);
	}
	
	protected AbstractCollection(String name, boolean withLabel) {
		if(withLabel)
		this.name = new LabeledName(name);
		else
			this.name = new DashSingleElement(name);
	}
	
	@Override
	public void setIndentLevel(int indentLvel) {
		super.setIndentLevel(indentLvel);
		for (Tag element : collection) {
			element.setIndentLevel(indentLvel + 1);
		}
	}
	
	@Override
	public String toString() {
		Appender appender = new Appender();
		
		if (!collection.isEmpty()) {
			appender.indent(getIndentLevel());
			appender.append(name);
			appender.newLine();
			appender.append(collection);
		}
		return appender.toString();
	}
	
	@Override
	public boolean isEmpty() {
		return collection.isEmpty();
	}
}
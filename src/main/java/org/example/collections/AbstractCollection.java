package org.example.collections;

import org.example.Appender;
import org.example.wrappers.Indentable;
import org.example.wrappers.SingleElement;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCollection extends Indentable {
	private final List<Indentable> collection = new ArrayList<>();
	private final SingleElement name;
	
	protected abstract String getName();
	
	public void add(Indentable indentable) {
		collection.add(indentable);
	}
	protected AbstractCollection(){
		name = new SingleElement(getName());
	}
	@Override
	public void setIndentLevel(int indentLvel) {
		super.setIndentLevel(indentLvel);
		for (Indentable element : collection) {
			element.setIndentLevel(indentLvel + 1);
		}
	}
	
	@Override
	public String toString() {
		Appender appender = new Appender();
		
		if (!collection.isEmpty()) {
			appender.indent(getIndentLevel());
			appender.append(name);
			appender.append(collection);
		}
		return appender.toString();
	}
	
	@Override
	public boolean isEmpty() {
		return collection.isEmpty();
	}
}

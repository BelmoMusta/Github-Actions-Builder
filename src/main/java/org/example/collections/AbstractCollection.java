package org.example.collections;

import org.example.Appender;
import org.example.wrappers.Indentable;
import org.example.wrappers.LabeledDashedName;
import org.example.wrappers.LabeledName;
import org.example.wrappers.SingleElement;
import org.example.wrappers.Tag;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public abstract class AbstractCollection extends Tag {
	
	private boolean collectionWithbrackets;
	public final List<Indentable> collection = new ArrayList<>();
	public final Indentable name;
	
	public void add(Indentable tag) {
		collection.add(tag);
	}
	
	public void add(Indentable tag, Function<Indentable, Indentable> converter) {
		collection.add(converter.apply(tag));
	}
	
	public void add(String tag, Function<String, Indentable> converter) {
		collection.add(converter.apply(tag));
	}
	public void addAll(List<String> tags, Function<String, Indentable> converter) {
		for (String tag : tags) {
			collection.add(converter.apply(tag));
		}
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
				if(!collectionWithbrackets) {
					appender.newLine();
				}
			}
			if (collectionWithbrackets){
				appender.appendCollection(collection, true);
			} else {
				appender.appendCollection(collection);
			}
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
	
	public <T extends AbstractCollection> T setCollectionWithbrackets(boolean collectionWithbrackets) {
		this.collectionWithbrackets = collectionWithbrackets;
		return (T) this;
	}
}

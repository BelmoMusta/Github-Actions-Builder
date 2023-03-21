package org.example;

import org.example.collections.AbstractCollection;
import org.example.wrappers.Tag;

import java.util.ArrayList;
import java.util.Collection;

public class Appender {
	StringBuilder stringBuilder = new StringBuilder();
	
	public Appender indent(int amount) {
		for (int i = 0; i < amount; i++) {
			append("  ");
		}
		return this;
	}
	
	public Appender append(String str) {
		stringBuilder.append(str);
		return this;
	}
	
	public Appender appendSingleQuote(String str) {
		stringBuilder.append("'");
		stringBuilder.append(str);
		stringBuilder.append("'");
		
		return this;
	}
	
	
	public Appender newLine() {
		return append("\n");
	}
	
	public Appender append(Object str) {
		if (str != null) {
			stringBuilder.append(str);
		}
		return this;
	}
	
	public Appender append(Tag str) {
		if (str != null) {
			indent(str.getIndentLevel());
			stringBuilder.append(str);
		}
		return this;
	}
	
	public Appender appendCollection(Collection<Tag> elements) {
		
		ArrayList<Tag> tags = new ArrayList<>(elements);
		
		for (int i = 0; i < tags.size(); i++) {
			Tag tag = tags.get(i);
			append(tag);
			if (i < tags.size() - 1) {
				newLine();
			}
		}
		
		return this;
	}
	
	
	@Override
	public String toString() {
		return stringBuilder.toString();
	}
}

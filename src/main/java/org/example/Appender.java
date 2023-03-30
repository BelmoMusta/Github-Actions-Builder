package org.example;

import org.example.wrappers.Node;

import java.util.ArrayList;
import java.util.Collection;

public class Appender {
	private int indent;
	StringBuilder stringBuilder = new StringBuilder();
	
	public Appender indent(int amount) {
		for (int i = 0; i < amount; i++) {
			stringBuilder.append("  ");
		}
		return this;
	}
	
	public Appender appendSingleQuote(String str) {
		stringBuilder.append("'");
		stringBuilder.append(str);
		stringBuilder.append("'");
		
		return this;
	}
	
	
	public Appender newLine() {
		  stringBuilder.append("\n");
		  return this;
	}
	
	public Appender append(Object str) {
		if (str != null) {
			indent(indent);
			stringBuilder.append(str);
		}
		return this;
	}
	public Appender append_(Object str) {
		if (str != null) {
			stringBuilder.append(str);
		}
		return this;
	}
	
	public Appender appendCollection(Collection<Node> elements) {
		
		ArrayList<Node> tags = new ArrayList<>(elements);
		
		for (int i = 0; i < tags.size(); i++) {
			Node node = tags.get(i);
			append(node);
			if (i < tags.size() - 1) {
				newLine();
			}
		}
		
		return this;
	}
	
	public Appender appendCollection(Collection<Node> elements, boolean withBrackets) {
		
		ArrayList<Node> nodes = new ArrayList<>(elements);
		if (withBrackets) {
		//	indent(1);
			append("[");
		}
		for (int i = 0; i < nodes.size(); i++) {
			Node node = nodes.get(i);
			if (withBrackets) {
				append(node.get());
			} else {
				append(node);
			}
			if (i < nodes.size() - 1) {
				if (withBrackets) {
					append(", ");
				} else {
					newLine();
				}
			}
		}
		append("]");
		
		
		return this;
	}
	
	
	@Override
	public String toString() {
		return stringBuilder.toString();
	}
	
	public void increaseIndent() {
		indent ++;
	}
	public void decreaseIndent() {
		indent --;
	}
}

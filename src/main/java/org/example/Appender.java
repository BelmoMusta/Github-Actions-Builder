package org.example;

import java.util.Collection;
import java.util.stream.Collectors;

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
		stringBuilder.append(str);
		return this;
	}
	
	public <T> Appender append(Collection<T> elements) {
		String reduce = elements.stream()
				.map(Object::toString)
				.collect(Collectors.joining("\n"));
		stringBuilder.append(reduce);
		return this;
	}
	
	
	@Override
	public String toString() {
		return stringBuilder.toString();
	}
}

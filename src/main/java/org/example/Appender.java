package org.example;

public class Appender {
	private int indent;
	StringBuilder stringBuilder = new StringBuilder();
	
	public Appender indent() {
		indent(indent);
		return this;
	}
	
	public Appender indent(int amount) {
		stringBuilder.append("  ".repeat(Math.max(0, amount)));
		return this;
	}
	
	public Appender appendSingleQuote(String str) {
		return appendWithQuotes(str, false);
	}
	public Appender appendDoubleQuote(String str) {
		return appendWithQuotes(str, true);
	}
	
	private Appender appendWithQuotes(String str, boolean doubleQuotes) {
		String quotes = "'";
		if (doubleQuotes) {
			quotes = "\"";
		}
		stringBuilder.append(quotes);
		stringBuilder.append(str);
		stringBuilder.append(quotes);
		
		return this;
	}
	
	
	public Appender newLine() {
		stringBuilder.append("\n");
		return this;
	}
	
	public Appender append(String str) {
		if (str != null) {
			stringBuilder.append(str);
		}
		return this;
	}
	
	@Override
	public String toString() {
		return stringBuilder.toString();
	}
	
	public void increaseIndent() {
		indent++;
	}
	
	public void decreaseIndent() {
		indent--;
	}
}

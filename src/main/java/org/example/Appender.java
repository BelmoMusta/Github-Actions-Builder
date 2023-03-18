package org.example;

public class Appender {
	StringBuilder stringBuilder = new StringBuilder();
	
	public Appender indent(int amount) {
		for (int i = 0; i < amount; i++) {
			append("  ");
		}
		return this;
	}
	public Appender append(String str){
		stringBuilder.append(str);
		return this;
	}
	
	public Appender newLine(){
		return append("\n");
	}
	
	public Appender append(Object str){
		stringBuilder.append(str);
		return this;
	}
	
	@Override
	public String toString() {
		return stringBuilder.toString();
	}
}

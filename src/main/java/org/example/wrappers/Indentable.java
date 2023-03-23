package org.example.wrappers;

public interface Indentable {
	boolean isNotEmpty();
	
	void setIndentLevel(int level);
	int getIndentLevel();
	
	default String get() {
		return "";
	}
}

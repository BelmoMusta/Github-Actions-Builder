package org.example.wrappers;

import org.example.visitor.Visitable;

public interface Node extends Visitable {
	boolean isNotEmpty();
	
	void setIndentLevel(int level);
	int getIndentLevel();
	
	default String get() {
		return "";
	}
}

package org.example.wrappers;

import org.example.visitor.Visitable;

public interface Node extends Visitable {
	boolean isNotEmpty();
	
	default String get() {
		return "";
	}
}

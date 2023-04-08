package org.example.visitor;

public interface Visitable {
	<R> void accept(Visitor<R> visitor);
}

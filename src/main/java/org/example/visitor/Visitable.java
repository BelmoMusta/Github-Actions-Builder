package org.example.visitor;

public interface Visitable {
	void accept(VoidVisitor<?> visitor);
	<A> void accept(Visitor<A> visitor, A arg);
	<A, R> R accept(ValuedVisitor<A, R> visitor, A arg);
}

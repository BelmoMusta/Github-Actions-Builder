package org.example.yy;

import org.example.visitor.Visitor;
import org.example.yy.support.CustomTypesSupport;

public class RepositoryDispatch extends WorkflowEvent implements CustomTypesSupport {
	
	protected RepositoryDispatch() {
		super("repository_dispatch");
	}
	
	public RepositoryDispatch types(String... types) {
		return addTypes(this, types);
	}
	
	public static RepositoryDispatch $() {
		return new RepositoryDispatch();
	}
	
	@Override
	public <R> void accept(Visitor<R> visitor) {
		visitor.visit(this);
	}
	
	
}

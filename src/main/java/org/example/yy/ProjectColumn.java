package org.example.yy;

import org.example.visitor.Visitor;
import org.example.yy.support.TypesSupport;

public class ProjectColumn extends WorkflowEvent implements TypesSupport {
	public ProjectColumn() {
		super("project_column");
	}
	
	public static ProjectColumn $() {
		return new ProjectColumn();
	}
	
	public ProjectColumn types(ProjectColumn.Type... types) {
		return addTypes(this, types);
	}
	
	@Override
	public <R> void accept(Visitor<R> visitor) {
		visitor.visit(this);
	}
	
	
	public enum Type implements TypeI {
		
		CREATED,
		DELETED,
		MOVED,
		UPDATED,
		
		;
		
		@Override
		public String toString() {
			return super.toString().toLowerCase();
		}
	}
}

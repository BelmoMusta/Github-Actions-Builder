package org.example.yy;

import org.example.visitor.Visitor;
import org.example.yy.support.TypesSupport;

public class ProjectCard extends WorkflowEvent implements TypesSupport {
	public ProjectCard() {
		super("project_card");
	}
	
	public static ProjectCard $() {
		return new ProjectCard();
	}
	
	public ProjectCard types(ProjectCard.Type... types) {
		return addTypes(this, types);
	}
	
	@Override
	public <R> void accept(Visitor<R> visitor) {
		visitor.visit(this);
	}
	
	
	public enum Type implements TypeI {
		
		CONVERTED,
		CREATED,
		DELETED,
		EDITED,
		MOVED,
		
		;
		
		@Override
		public String toString() {
			return super.toString().toLowerCase();
		}
	}
}

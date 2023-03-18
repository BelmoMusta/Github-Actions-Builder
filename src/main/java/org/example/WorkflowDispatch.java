package org.example;

import org.example.collections.Branches;

import java.util.ArrayList;
import java.util.List;

public class WorkflowDispatch extends WorkflowEvent {
	Branches branches = new Branches();
	
	public WorkflowDispatch branches(String ... branches){
		for (String branch : branches) {
			this.branches.add(new Branch(branch));
		}
		return this;
	}
	
	@Override
	public String toString() {
		branches.setIndentLevel(getIndentLevel() + 1);
		Appender appender = new Appender();
		appender.append("workflow_dispatch: ");
		appender.newLine();
		appender.indent(getIndentLevel() + 1);
		appender.append("branches: ");
		appender.newLine();
		appender.append(branches.toString());
		
		return appender.toString();
	}
}

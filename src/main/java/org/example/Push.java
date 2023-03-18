package org.example;

import org.example.collections.Branches;

public class Push extends WorkflowEvent {
	final Branches branches = new Branches();
	
	public Push branches(String... branches) {
		for (String branch : branches) {
			Branch br = new Branch(branch);
			this.branches.add(br);
		}
		return this;
	}
	
	@Override
	public String toString() {
		branches.setIndentLevel(getIndentLevel() + 1);
		Appender appender = new Appender();
		appender.append("push: ");
		appender.newLine();
		appender.indent(getIndentLevel() + 1);
		appender.append("branches: ");
		appender.newLine();
		appender.append(branches.toString());
		
		return appender.toString();
	}
}

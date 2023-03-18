package org.example.collections;

import org.example.Appender;
import org.example.Branch;
import org.example.Indentable;

import java.util.ArrayList;
import java.util.List;

public class Branches extends Indentable {
	private final List<Branch> branches = new ArrayList<>();
	
	public void add(Branch branch) {
		branch.setIndentLevel(getIndentLevel() + 1);
		branches.add(branch);
	}
	
	@Override
	public String toString() {
		Appender appender = new Appender();
	 
		for (Branch branch : branches) {
			appender.indent(getIndentLevel());
			appender.append(branch);
			appender.newLine();
		}
		
		return appender.toString();
	}
}

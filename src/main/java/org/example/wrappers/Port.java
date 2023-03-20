package org.example.wrappers;

public class Port extends SingleElement {
	
	public Port(String port) {super(port);}
	
	public boolean addColumn() {
		return false;
	}
	
	public boolean addDashAtFirst() {
		return true;
	}
}

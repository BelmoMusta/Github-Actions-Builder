package org.example.wrappers;

public class LabeledDashedName extends LabeledName {
	public LabeledDashedName(String value) {
		super(value);
	}
	
	@Override
	public boolean addDashAtFirst() {
		return true;
	}
}

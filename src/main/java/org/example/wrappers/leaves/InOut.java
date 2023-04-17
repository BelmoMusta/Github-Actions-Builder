package org.example.wrappers.leaves;

import org.example.collections.Options;
import org.example.wrappers.Node;
import org.example.wrappers.Tag;

import java.util.ArrayList;
import java.util.List;

public class InOut extends Tag {
	public SingleElement name;
	
	protected Options options = new Options();
	public List<Node> inputElements = new ArrayList<>();
	
	
	public enum Type {
		CHOICE,
		ENVIRONMENT,
		BOOLEAN,
		STRING;
		
		@Override
		public java.lang.String toString() {
			return super.toString().toLowerCase();
		}
	}
}

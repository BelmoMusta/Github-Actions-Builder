package org.example.wrappers;

import org.example.collections.Options;

import java.util.ArrayList;
import java.util.List;

public class InOut extends Tag {
	public SingleElement name;
	
	protected Options options = new Options();
	protected InOutElement<String> default_;
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

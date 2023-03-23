package org.example.collections;

import org.example.wrappers.DashSingleElement;
import org.example.wrappers.Indentable;

import java.util.Arrays;

public class Needs extends SecondLevel {
	public Needs() {
		super("needs");
	}
	
	@Override
	public void add(Indentable tag) {
		/**
		 * do not add the same tag more than once
		 */
		for (Indentable indentable : collection) {
			if (indentable.get().equals(tag.get())) {
				return;
			}
		}
		super.add(tag);
	}
	
	public static Needs name(String...jobs){
		Needs needs = new Needs();
		needs.addAll(Arrays.asList(jobs), DashSingleElement::new);
		return needs;
	}
	
	@Override
	public Needs setCollectionWithbrackets(boolean collectionWithbrackets) {
		 super.setCollectionWithbrackets(collectionWithbrackets);
		 return this;
	}
}

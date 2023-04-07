package org.example.yy;

import org.example.collections.Nodes;
import org.example.collections.Withs;
import org.example.visitor.Visitor;
import org.example.wrappers.DashSingleElement;
import org.example.wrappers.DashedNameQuotedValuePair;
import org.example.wrappers.DashedNameValuePair;
import org.example.wrappers.LabeledDashedName;
import org.example.wrappers.LabeledName;
import org.example.wrappers.NameValuePair;
import org.example.wrappers.Node;
import org.example.yy.support.IdSupport;

public class Step extends Nodes implements IdSupport {
	
	protected Step() {
		super(null, true);
	}
	
	public static Step $() {
		return new Step();
	}
	
	public Step id(String id) {
		return addId(this, id);
	}
	
	public Step if_(String condition) {
		add(new NameValuePair("if", condition));
		return this;
	}
	
	public Step timeoutMinutes(int minutes) {
		add(new NameValuePair("timeout-minutes", String.valueOf(minutes)));
		return this;
	}
	
	public Step env(String name, String value) {
		return getEnv(this, name, value);
	}
	
	
	public Step with(String name, String value) {
		
		Withs withs = findTag(Withs.class);
		if (withs == null) {
			withs = new Withs();
			add(withs);
		}
		With with = new With(name, value);
		withs.add(with);
		return this;
	}
	
	public Step with(String name, Pipe value) {
		
		Withs withs = findTag(Withs.class);
		if (withs == null) {
			withs = new Withs();
			add(withs);
		}
		With with = new With(name, "|");
		withs.add(with);
		withs.add(value);
		return this;
	}
	
	public Step name(String name) {
		if (children.isEmpty()) {
			this.add(new LabeledDashedName(name));
		} else {
			this.add(new LabeledName(name));
			
		}
		return this;
	}
	
	public Step workingDirectory(String directory) {
		if (children.isEmpty()) {
			this.add(new DashedNameValuePair("working-directory", directory));
		} else {
			this.add(new NameValuePair("working-directory", directory));
		}
		
		return this;
	}
	
	public Step uses(String s) {
		if (children.isEmpty()) {
			this.add(new DashedNameValuePair("uses", s));
		} else {
			this.add(new NameValuePair("uses", s));
		}
		
		return this;
	}
	
	public Step run(String s) {
		if (children.isEmpty()) {
			this.add(new DashedNameQuotedValuePair("run", s));
		} else {
			this.add(new NameValuePair("run", s));
		}
		return this;
	}
	
	public Step run(Pipe pipe) {
		final Node run;
		if (children.isEmpty()) {
			run = new DashSingleElement("run: |");
		} else {
			run = new NameValuePair("run", "|");
		}
		this.add(run);
		this.add(pipe);
		return this;
	}
	public Step continueOnError(boolean continueOnError) {
		this.add(new NameValuePair("continue-on-error", String.valueOf(continueOnError)));
		return this;
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
visitor.visit(this, arg);
	}
	
	public Step shell(String shell) {
		if (children.isEmpty()) {
			this.add(new DashedNameValuePair("shell", shell));
		} else {
			this.add(new NameValuePair("shell", shell));
		}
		return this;
	}
}

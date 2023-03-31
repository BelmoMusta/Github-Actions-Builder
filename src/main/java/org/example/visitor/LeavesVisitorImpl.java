package org.example.visitor;

import org.example.Appender;
import org.example.Environment;
import org.example.Volume;
import org.example.wrappers.DashQuotedSingleElement;
import org.example.wrappers.DashSingleElement;
import org.example.wrappers.DashedId;
import org.example.wrappers.DashedNameValuePair;
import org.example.wrappers.InOutElement;
import org.example.wrappers.LabeledDashedName;
import org.example.wrappers.LabeledName;
import org.example.wrappers.NameValuePair;
import org.example.wrappers.SimpleEntry;
import org.example.wrappers.SingleElement;

public class LeavesVisitorImpl extends AbstractVisitor<Appender> {
	
	
	@Override
	public void visit(Environment environment, Appender appender) {
		appender.indent();
		appender.append(environment.name);
		appender.append(": ");
		appender.append(environment.value);
	}
	
	@Override
	public void visit(Volume volumes, Appender appender) {
		appender.indent();
		appender.append("- ");
		appender.append(volumes.name);
		appender.append(":");
		appender.append(volumes.value);
	}
	
	@Override
	public void visit(DashedId id, Appender appender) {
		appender.indent();
		appender.append("- ");
		appender.append(id.name);
		appender.append(": ");
		appender.append(id.value);
	}
	
	
	@Override
	public void visit(DashQuotedSingleElement dashQuotedSingleElement, Appender appender) {
		appender.indent();
		appender.append("- ");
		appender.appendSingleQuote(dashQuotedSingleElement.value);
	}
	
	@Override
	public void visit(DashSingleElement dashQuotedSingleElement, Appender appender) {
		appender.indent();
		appender.append("- ");
		appender.append(dashQuotedSingleElement.value);
	}
	
	@Override
	public void visit(DashedNameValuePair dashedNameValuePair, Appender appender) {
		appender.indent();
		appender.append("- ");
		appender.append(dashedNameValuePair.name);
		appender.append(": ");
		appender.appendSingleQuote(dashedNameValuePair.value);
	}
	
	@Override
	public void visit(LabeledDashedName labeledDashedName, Appender appender) {
		appender.indent();
		appender.append("- ");
		appender.append(labeledDashedName.name);
		appender.append(": ");
		appender.append(labeledDashedName.value);
	}
	
	@Override
	public void visit(SingleElement singleElement, Appender appender) {
		appender.indent();
		appender.append(singleElement.value);
		appender.append(":");
	}
	
	@Override
	public void visit(SimpleEntry simpleEntry, Appender appender) {
		appender.indent();
		appender.append(simpleEntry.value);
	}
	
	@Override
	public void visit(InOutElement<?> inOutElement, Appender appender) {
		appender.indent();
		appender.append(inOutElement.name);
		appender.append(": ");
		if (inOutElement.isString()) {
			appender.appendSingleQuote(inOutElement.value);
		} else {
			appender.append(inOutElement.value);
		}
	}
	
	@Override
	public void visit(LabeledName labeledName, Appender appender) {
		appender.indent();
		appender.append(labeledName.name);
		appender.append(": ");
		appender.append(labeledName.value);
	}
	
	
	@Override
	public void visit(NameValuePair nameValuePair, Appender appender) {
		appender.indent();
		appender.append(nameValuePair.name);
		appender.append(": ");
		appender.append(nameValuePair.value);
	}
	
}

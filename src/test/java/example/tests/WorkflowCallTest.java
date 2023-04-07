package example.tests;

import org.example.Appender;
import org.example.visitor.DefaultVisitorImpl;
import org.example.visitor.Visitor;
import org.example.wrappers.Input;
import org.example.wrappers.Output;
import org.example.wrappers.Secret;
import org.example.yy.WorkflowCall;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WorkflowCallTest {
	@Test
	public void test() {
		WorkflowCall workflowDispatch = WorkflowCall.$()
				.inputs(Input.$().name("in")
						.type(Input.Type.boolean_)
						.default_("true")
						.description("description")
						.required(false))
				.outputs(Output.$().name("out")
						.description("description").value("1"))
				
				.secrets(Secret.$().name("pass")
						.description("pass")
						.required());
		Appender appender = new Appender();
		Visitor<Appender> visitor = new DefaultVisitorImpl();
		workflowDispatch.accept(visitor, appender);
		String expected = "workflow_call:\n" +
				"  inputs:\n" +
				"    in:\n" +
				"      type: boolean\n" +
				"      default: true\n" +
				"      description: \"description\"\n" +
				"      required: false\n" +
				"  outputs:\n" +
				"    out:\n" +
				"      description: \"description\"\n" +
				"      value: 1\n" +
				"  secrets:\n" +
				"    pass:\n" +
				"      description: \"pass\"\n" +
				"      required: true";
		Assertions.assertEquals(expected, appender.toString());
	}
}

package example.tests;

import org.example.visitor.StringPrinterVisitor;
import org.example.visitor.Visitor;
import org.example.wrappers.leaves.Input;
import org.example.wrappers.leaves.Output;
import org.example.wrappers.leaves.Secret;
import org.example.yy.WorkflowCall;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WorkflowCallTest {
	@Test
	public void test() {
		WorkflowCall workflowDispatch = WorkflowCall.$()
				.inputs(Input.$().name("in")
						.type(Input.Type.BOOLEAN)
						.default_("true")
						.description("description")
						.required(false))
				.outputs(Output.$().name("out")
						.description("description").value("1"))
				
				.secrets(Secret.$().name("pass")
						.description("pass")
						.required());
		
		Visitor<String> visitor = new StringPrinterVisitor();
		workflowDispatch.accept(visitor);
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
		Assertions.assertEquals(expected, visitor.getResult());
	}
}

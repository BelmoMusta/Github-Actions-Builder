package example.tests;

import org.example.visitor.StringPrinterVisitor;
import org.example.visitor.Visitor;
import org.example.yy.WorkflowRun;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WorkflowRunTest {
	@Test
	public void test() {
		WorkflowRun workflowRun = WorkflowRun.$()
				.branches("a")
				.branchesIgnore("b")
				.types(WorkflowRun.Type.COMPLETED,
						WorkflowRun.Type.IN_PROGRESS,
						WorkflowRun.Type.REQUESTED)
				.workflows("e", "f");
		
		Visitor<String> visitor = new StringPrinterVisitor();
		workflowRun.accept(visitor);
		String expected = "workflow_run:\n" +
				"  branches:\n" +
				"    - 'a'\n" +
				"  branches-ignore:\n" +
				"    - 'b'\n" +
				"  types:\n" +
				"    - completed\n" +
				"    - in_progress\n" +
				"    - requested\n" +
				"  workflows:\n" +
				"    - 'e'\n" +
				"    - 'f'";
		Assertions.assertEquals(expected, visitor.getResult());
	}
}

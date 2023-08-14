package example.tests;

import org.example.visitor.StringPrinterVisitor;
import org.example.visitor.Visitor;
import org.example.wrappers.leaves.Input;
import org.example.yy.WorkflowDispatch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WorkflowDispatchTest {
    @Test
    public void test() {
        WorkflowDispatch workflowDispatch = WorkflowDispatch.$()
                .inputs(Input.$().name("logLevel")
                                .description("log level")
                                .type(Input.Type.CHOICE)
                                .required()
                                .default_("'warning'")
                                .options("info", "warning", "debug"),
                        Input.$().name("settings")
                                .required());

        Visitor<String> visitor = new StringPrinterVisitor();
        workflowDispatch.accept(visitor);
        String expected = "workflow_dispatch:\n" +
                "  inputs:\n" +
                "    logLevel:\n" +
                "      description: \"log level\"\n" +
                "      type: choice\n" +
                "      required: true\n" +
                "      default: 'warning'\n" +
                "      options:\n" +
                "        - 'info'\n" +
                "        - 'warning'\n" +
                "        - 'debug'\n" +
                "    settings:\n" +
                "      required: true";
        Assertions.assertEquals(expected, visitor.getResult());
    }
}

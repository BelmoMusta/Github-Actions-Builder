package example.tests;

import org.example.visitor.StringPrinterVisitor;
import org.example.wrappers.leaves.Output;
import org.example.yy.Job;
import org.example.yy.Pipe;
import org.example.yy.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StepRunTest {
    static String EXPECTED = "my_build:\n" +
            "  name: my_build\n" +
            "  id: first-job\n" +
            "  runs-on: ubuntu-latest\n" +
            "  steps:\n" +
            "    - uses: actions/checkout@master\n" +
            "      name: Checking out our code\n" +
            "    - run: |\n" +
            "        echo\n" +
            "        lol\n" +
            "      name: Say something\n" +
            "  needs:\n" +
            "    - a\n" +
            "    - w\n" +
            "    - b\n" +
            "  outputs:\n" +
            "    completed:\n" +
            "      type: boolean\n" +
            "      required: true";

    @Test
    public void main() {
        Job job = Job.$()
                .label("my_build")
                .name("my_build")
                .id("first-job")
                .runsOn("ubuntu-latest")
                .step(Step.$()
                        .uses("actions/checkout@master")
                        .name("Checking out our code")
                )
                .needs("a")
                .needs("w")
                .needs("b")
                .outputs(Output.$()
                        .name("completed")
                        .type(Output.Type.BOOLEAN)
                        .required())
                .step(Step.$()
                        .run(Pipe.$().entries("echo", "lol"))
                        .name("Say something")
                );
        StringPrinterVisitor visitor = new StringPrinterVisitor();

        job.accept(visitor);
        Assertions.assertEquals(EXPECTED, visitor.getResult());
    }
}

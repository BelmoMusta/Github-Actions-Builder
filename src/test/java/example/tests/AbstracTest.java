package example.tests;

import org.example.visitor.StringPrinterVisitor;
import org.example.visitor.Visitor;
import org.junit.jupiter.api.BeforeEach;

public abstract class AbstracTest {

    protected Visitor<String> visitor;

    @BeforeEach
    public void before() {

        visitor = new StringPrinterVisitor();
    }
}

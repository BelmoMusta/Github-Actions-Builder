package example.tests;

import org.example.visitor.StringPrinterVisitor;
import org.example.visitor.Visitor;
import org.example.yy.RegistryPackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegistryPackageTest {
    @Test
    public void test() {
        RegistryPackage registryPackage = RegistryPackage.$();

        Visitor<String> visitor = new StringPrinterVisitor();
        registryPackage.accept(visitor);
        String expected = "registry_package:";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testTypes() {
        RegistryPackage registryPackage = RegistryPackage.$()
                .types(RegistryPackage.Type.values());


        Visitor<String> visitor = new StringPrinterVisitor();
        registryPackage.accept(visitor);
        String expected = "registry_package:\n" +
                "  types:\n" +
                "    - published\n" +
                "    - updated";
        Assertions.assertEquals(expected, visitor.getResult());
    }
}

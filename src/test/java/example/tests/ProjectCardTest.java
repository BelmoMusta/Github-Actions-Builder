package example.tests;

import org.example.yy.ProjectCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProjectCardTest extends AbstracTest {

    @Test
    public void initTest() {
        ProjectCard projectCard = ProjectCard.$();
        projectCard.accept(visitor);
        String expected = "project_card:";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void releaseTypesTest() {
        ProjectCard projectCard = ProjectCard.$()
                .types(ProjectCard.Type.values());
        projectCard.accept(visitor);
        String expected = "project_card:\n" +
                "  types:\n" +
                "    - converted\n" +
                "    - created\n" +
                "    - deleted\n" +
                "    - edited\n" +
                "    - moved";
        Assertions.assertEquals(expected, visitor.getResult());
    }
}

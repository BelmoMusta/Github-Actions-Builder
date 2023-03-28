package example.tests;

import org.example.Container;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContainerTest {
	@Test
	public void main() {
		
		String expected = "container:\n" +
				"    image: node:10.16-jessie\n" +
				"    volumes:\n" +
				"      - my_docker_volume:/volume_mount\n" +
				"      - foo:bar\n" +
				"    options: --cpus 1\n" +
				"    env:\n" +
				"      NODE_ENV: development\n" +
				"    options: --cpu 1 ooo=9\n" +
				"    ports:\n" +
				"      - 80";
		Container container = Container.image("node:10.16-jessie")
				.volume("my_docker_volume", "/volume_mount")
				.volume("foo", "bar")
				.options("--cpus 1")
				.env("NODE_ENV", "development")
				.options("--cpu 1", "ooo=9")
				.port("80");
		Assertions.assertEquals(expected, container.toString());
	}
}

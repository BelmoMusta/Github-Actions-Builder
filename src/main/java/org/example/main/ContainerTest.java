package org.example.main;

import org.example.Container;
import org.example.Job;
import org.example.Step;

public class ContainerTest {
	public static void main(String[] args) {
		Container container = Container.image("node:10.16-jessie")
				.volume("my_docker_volume", "/volume_mount")
				.volume("foo", "bar")
				.options("--cpus 1")
				.env("NODE_ENV", "development")
				.options("--cpu 1", "ooo=9")
				.port("80");
		container.setIndentLevel(1);
		System.out.println(container);
		
		System.out.println("_____");
	}
}

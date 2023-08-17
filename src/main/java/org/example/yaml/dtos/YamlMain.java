package org.example.yaml.dtos;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.example.yaml.dtos.events.CheckRun;
import org.example.yaml.dtos.events.Push;
import org.example.yaml.dtos.events.RegistryPackage;
import org.example.yaml.dtos.events.WorkflowDispatch;

import java.io.FileWriter;

public class YamlMain {
    public static void main(String[] args) throws Exception {
        YamlWorkflow wf = YamlWorkflow.$("test-WF")
                .on(CheckRun.$()
                                .types(CheckRun.Type.COMPLETED,
                                        CheckRun.Type.COMPLETED,
                                        CheckRun.Type.CREATED),
                        WorkflowDispatch.$(),
                        Push.$()
                                .branches("master")
                                .ignoreBranches("not_master")
                                .tags("my_tag")
                                .ignoreTags("not_my_tag")
                                .paths("/path1", "/path2")
                                .ignorePaths("test/path"),
                        RegistryPackage.$().types(RegistryPackage.Type.PUBLISHED)
                );
        YAMLFactory yamlFactory = new MyFactory();
        ObjectMapper mapper = new ObjectMapper(yamlFactory);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);


        FileWriter fileWriter = new FileWriter("yaml_maven_generated.yml");
        //fileWriter.write(wf);
        // fileWriter.close();
        mapper.writeValue(fileWriter, wf);
    }
}

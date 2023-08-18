package org.example.yaml.dtos;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import org.example.yaml.dtos.events.CheckRun;
import org.example.yaml.dtos.events.CheckSuite;
import org.example.yaml.dtos.events.Push;
import org.example.yaml.dtos.events.RegistryPackage;
import org.example.yaml.dtos.events.Schedule;
import org.example.yaml.dtos.events.WorkflowDispatch;
import org.example.yaml.dtos.inputs.Input;
import org.example.yaml.dtos.inputs.Output;

import java.io.FileWriter;

public class YamlMain {
    public static void main(String[] args) throws Exception {
        YamlWorkflow wf = YamlWorkflow.$("test-WF")
                .on(
                        Schedule.$()
                                .cron("* * * * *")
                                .cron("1 * * * *")
                                .cron("2 * * * *"),
                        CheckSuite.$()
                                .types(CheckSuite.Type.COMPLETED),
                        CheckRun.$()
                                .types(CheckRun.Type.COMPLETED,
                                        CheckRun.Type.COMPLETED,
                                        CheckRun.Type.CREATED),
                        WorkflowDispatch.$()
                                .inputs(Input.$()
                                        .name("in")
                                        .description("totoootot")
                                        .type(Input.Type.BOOLEAN)
                                        .default_("false")
                                        .required(),
                                        Input.$().name("test")
                                                .options("lol", "foo"))
                                .outputs(Output.$().name("version")
                                        .value("1.0.0"))
                        ,
                        Push.$()
                                .branches("master")
                                .ignoreBranches("not_master")
                                .tags("my_tag")
                                .ignoreTags("not_my_tag")
                                .paths("/path1", "/path2")
                                .ignorePaths("test/path"),
                        RegistryPackage.$().types(RegistryPackage.Type.PUBLISHED)
                );
        YAMLFactory yamlFactory = new MyFactory().enable(YAMLGenerator.Feature.INDENT_ARRAYS_WITH_INDICATOR);
        ObjectMapper mapper = new ObjectMapper(yamlFactory);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);


        FileWriter fileWriter = new FileWriter("yaml_maven_generated.yml");
        //fileWriter.write(wf);
        // fileWriter.close();
        mapper.writeValue(fileWriter, wf);
    }
}

package org.example.yaml.dtos;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.dataformat.yaml.util.StringQuotingChecker;

import java.io.FileWriter;

public class YamlMain {
    public static void main(String[] args) throws Exception {
        YamlWorkflow wf = YamlWorkflow.$("test-WF");
        YAMLFactory yamlFactory = new MyFactory();
        ObjectMapper mapper = new ObjectMapper(yamlFactory
        );


        FileWriter fileWriter = new FileWriter("yaml_maven_generated.yml");
        //fileWriter.write(wf);
        // fileWriter.close();
        mapper.writeValue(fileWriter, wf);
    }
}

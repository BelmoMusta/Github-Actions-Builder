package org.example.yaml.dtos;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.dataformat.yaml.util.StringQuotingChecker;

import java.io.IOException;
import java.io.Writer;

public class MyFactory extends YAMLFactory {

    @Override
    protected YAMLGenerator _createGenerator(Writer out, IOContext ctxt) throws IOException {
        int feats = _yamlGeneratorFeatures;
        StringQuotingChecker quotingChecker = new MyStringQuotingChecker();
        if (_dumperOptions == null) {
            return new YAMLGenerator(ctxt, _generatorFeatures, feats,
                    quotingChecker, _objectCodec, out, _version);
        } else {
            return new YAMLGenerator(ctxt, _generatorFeatures, feats,
                    quotingChecker, _objectCodec, out, _dumperOptions);
        }
    }
}

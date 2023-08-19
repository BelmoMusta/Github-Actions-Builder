package org.example.yaml.dtos;

import com.fasterxml.jackson.dataformat.yaml.util.StringQuotingChecker;

import java.util.Arrays;
import java.util.List;

public class MyStringQuotingChecker extends StringQuotingChecker.Default {
    private static final List<String> EXCLUDED = Arrays.asList("on");// o not quote the 'on' entry
    @Override
    public boolean needToQuoteName(String name) {
        if (EXCLUDED.contains(name)) {
            return false;
        }
        return super.needToQuoteName(name);
    }
    @Override
    public boolean needToQuoteValue(String value) {
        if (value.contains(" ")) {
            return true;
        }
        return super.needToQuoteValue(value);
    }
}

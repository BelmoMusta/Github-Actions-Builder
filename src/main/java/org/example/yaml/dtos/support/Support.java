package org.example.yaml.dtos.support;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Support extends LinkedHashMap<String, Collection<String>> {
    @Override
    public Collection<String> put(String key, Collection<String> value) {
        Collection<String> strings = get(key);
        if (strings != null) {
            Set<String> merged = new LinkedHashSet<>(strings);
            merged.addAll(value);
            return super.put(key, merged);
        }
        Collection<String> v = value;
        if (!(value instanceof Set)) {
            v = new LinkedHashSet<>(value);
        }
        return super.put(key, v);
    }
    public Collection<String> putIgnore(String key, Collection<String> value) {
        return put(key+"-ignore", value);
    }
    public void putEnum(String key, Collection<Enum<?>> value) {
        put(key, value.stream()
                .map(Enum::name)
                .map(String::toLowerCase)
                .collect(Collectors.toList()));
    }
}

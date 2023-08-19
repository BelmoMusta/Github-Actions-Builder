package org.example.yaml.dtos.jobs;

import java.util.LinkedHashMap;

public class Run extends LinkedHashMap {

    public static Run $() {
        return new Run();
    }

    public Run shell(String shell) {
       put("shell", shell);
        return this;
    }

    public Run workingDirectory(String wd) {
        put("working-directory", wd);
        return this;
    }
}

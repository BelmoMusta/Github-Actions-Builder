package org.example.yaml.dtos.events;

import org.example.yaml.dtos.YamlEvent;

import java.util.ArrayList;

class Cron {
    final String value;
    Cron(String value) {this.value = value;}

    public String getCron() {
        return value;
    }
}


public class Schedule extends ArrayList<Cron> implements YamlEvent {

    public static Schedule $() {
        return new Schedule();
    }

    public Schedule cron(String... crons) {
        for (String cron : crons) {
            add(new Cron(cron));
        }
        return this;
    }

    @Override
    public String name() {
        return "schedule";
    }
}

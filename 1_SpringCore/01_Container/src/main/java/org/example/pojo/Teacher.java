package org.example.pojo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Teacher {

    Teacher() {
        log.info("Class Teacher No Args Constructor");
    }

    Teacher(String name, int classId) {
        log.info("Class Teacher All Args Constructor");
        this.name = name;
        this.classId = classId;
    }

    private String name;

    private int classId;

    public static void createInstance(){

    }
}

package org.example.pojo;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
public class Classroom {

    Classroom() {
        log.info("No args constructor.");
    }

    public Classroom(int num, String subject, String teacherName) {
        log.info("All args constructor.");
        this.num = num;
        this.subject = subject;
        this.teacherName = teacherName;
    }

    @Setter
    private int num;

    @Setter
    private String subject;

    private String teacherName;

    public void setTeacherName(String teacherName) {
        log.info("Setter set teacherName.");
        this.teacherName = teacherName;
    }
}

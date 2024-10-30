package org.example.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class Classroom {

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
    @Getter
    private int num;

    @Setter
    @Getter
    private String subject;

    private String teacherName;

    public String getTeacherName() {
        log.info("Getter");
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        log.info("Setter");
        this.teacherName = teacherName;
    }
}

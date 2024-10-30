package org.example.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TeacherService {

    private static TeacherService teacherService = new TeacherService();

    private TeacherService() {
    }

    public static TeacherService createInstance() {
        log.info("通过静态工厂实例化TeacherService.");
        return teacherService;
    }
}

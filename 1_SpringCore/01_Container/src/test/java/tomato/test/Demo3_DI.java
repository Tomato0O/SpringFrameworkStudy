package tomato.test;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Classroom;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖注入：两个主要的变体：基于构造器的注入和基于Setter的注入
 */
@Slf4j
public class Demo3_DI {

    static ApplicationContext context = new ClassPathXmlApplicationContext("classroom.xml");

    @Test
    public void constructorDI() {
        context.getBean("classroom1");
    }

    @Test
    public void setterDI() {
        context.getBean("classroom3");
        context.getBean("classroom4");
        context.getBean("classroom5");
        Classroom classroom6 = context.getBean("classroom6", Classroom.class);

        log.info("{}", classroom6);
    }
}

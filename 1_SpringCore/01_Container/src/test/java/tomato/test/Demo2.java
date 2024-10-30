package tomato.test;

import org.example.service.TeacherService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Constructor;

/**
 * 实例化Bean的三种方式
 * https://springdoc.cn/spring/core.html#beans-factory-class-ctor
 */
public class Demo2 {

    /**
     * 构造方法实例化
     */
    @Test
    public void constructor() {
        new ClassPathXmlApplicationContext("teacher.xml");
    }

    /**
     * 静态工厂实例化。在bean.xml指定factory-method
     * https://springdoc.cn/spring/core.html#beans-factory-class-static-factory-method
     */
    @Test
    public void staticFactory() {
        TeacherService.createInstance();
    }

    /**
     * 实例工厂实例化。
     */
    @Test
    public void instanceFactory(){

    }
}

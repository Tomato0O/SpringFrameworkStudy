package tomato.test;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Student;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

@Slf4j
public class Demo1 {


    /**
     * 使用传统xml形式注册bean
     */
    @Test
    public void xml() {
        // 控制反转：把创建对象实例的权限交给spring容器，由spring容器来管理SpringBean的生命周期
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml", "empty.xml");

        /*
         * `org.springframework.beans`和`org.springframework.context`包是IOC容器的基础
         * BeanFactory接口用于管理任何类型的对象，ApplicationContext是BeanFactory的子接口，实现了一些新功能
         * */

        // 使用容器，获取SpringBean，再调用对象方法
        Student stu1 = context.getBean("stu1", Student.class);
        String msg = stu1.introduceMySelf();
        log.info("{}", msg);

        // 获取容器中所有注册的SpringBean
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            log.warn("{}", beanDefinitionName);
        }
    }

    /**
     * 使用groovy
     */
    @Test
    public void groovy() {
        ApplicationContext context = new GenericGroovyApplicationContext("bean.groovy");
    }

    /**
     * 最灵活的变体
     * <a href="https://springdoc.cn/spring/core.html#beans-factory-client">...</a>
     */
    @Test
    public void generic() {
        GenericApplicationContext context = new GenericApplicationContext();

        new XmlBeanDefinitionReader(context).loadBeanDefinitions("bean.xml", "empty.xml");
    }

    @Test
    public void alias() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        context.getBean("stu1");
        // 通过别名a1来获取Bean
        context.getBean("a1");

        try {
            context.getBean("stu2");
        } catch (Exception e) {
            log.error("No named bean stu2 found!");
        }

        // 测试Bean多个可用的name
        context.getBean("student_zhang_san");
        context.getBean("zhang_san");
    }
}

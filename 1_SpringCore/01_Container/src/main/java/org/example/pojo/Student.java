package org.example.pojo;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private int id;

    private short age;

    private char sex;

    private String name;

    public String introduceMySelf() {
        return "Hello, I'm " + name + ", and I'm " + age + " years old.";
    }

    /**
     * 非静态内部类实例化：在 Java 中，非静态内部类（如 Student.Boy）会隐式地持有对外部类（Student）实例的引用。
     * 这意味着要实例化一个 Student.Boy 对象，必须首先有一个 Student 对象。
     * 因此，非静态内部类不能单独被实例化，除非通过外部类的实例。
     * <p>
     * 将内部类改为静态内部类：可以将类声明为静态内部类，这样它就不依赖于外部类 Student 的实例，可以单独实例化
     * <p>
     * Spring 尝试通过默认构造函数来实例化 Student.Boy，
     * 但由于 Student.Boy 依赖于 Student 的实例，因此它没有生成默认的无参构造函数。
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Boy {

        private short height;

        public String sayHello() {
            return "I'm " + height + " cm.";
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Girl {

        private float weight;

        public String sayHello() {
            return "I'm " + weight + " kg.";
        }
    }
}
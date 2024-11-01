在Spring框架中，**Spring Bean** 是一个由Spring IoC（控制反转）容器管理的对象。Spring Bean的生命周期由容器负责，容器负责创建、配置和管理这些对象的依赖关系。Spring Bean 是构建Spring应用程序的基本组成部分，通过依赖注入（Dependency Injection）机制进行管理。

### 核心概念：
1. **配置与管理**：
    - Bean 可以通过 XML 配置文件、Java 注解或 Java 配置类（`@Configuration`）进行定义。
    - Spring 容器会根据配置文件或注解，自动创建和管理这些 Bean 对象。

2. **Bean的生命周期**：
    - 创建：当Spring容器启动时，根据配置创建和实例化 Bean。
    - 初始化：可以通过 `@PostConstruct` 注解或 `init-method` 指定 Bean 的初始化方法。
    - 使用：Spring 管理这些 Bean 的依赖并通过依赖注入使它们在应用中相互协作。
    - 销毁：当容器关闭时，可以通过 `@PreDestroy` 注解或 `destroy-method` 指定 Bean 的销毁方法。

3. **依赖注入**：
    - Spring Bean 之间的依赖通过 IoC 容器注入，可以通过构造函数、setter 方法或直接注解（如 `@Autowired`）进行注入。Spring框架的IoC容器会自动解析这些依赖。

4. **Bean的作用域（Scope）**：
    - **singleton**：默认作用域。整个 Spring 容器中只创建一个 Bean 实例。
    - **prototype**：每次请求都会创建一个新的 Bean 实例。
    - 其他作用域：如 `request`、`session` 和 `application`，多用于 Web 应用开发。

### 例子：
#### XML 配置方式：
```xml
<bean id="myBean" class="com.example.MyClass">
    <!-- 可以在这里配置Bean的依赖 -->
</bean>
```

#### 注解方式：
```java
@Component
public class MyBean {
    // 这个类会被Spring管理为一个Bean
}
```

#### 使用依赖注入：
```java
@Component
public class MyService {
    private final MyBean myBean;

    @Autowired
    public MyService(MyBean myBean) {
        this.myBean = myBean;
    }
}
```

### 总结：
Spring Bean 是 Spring 容器管理的核心对象，Spring 通过 IoC 容器对这些 Bean 进行管理，并且通过依赖注入机制解决对象之间的依赖问题。
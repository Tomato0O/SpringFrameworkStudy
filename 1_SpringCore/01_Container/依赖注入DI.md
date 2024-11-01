**依赖注入（Dependency Injection, DI）** 是一种设计模式，用于解决对象之间的依赖问题。简单来说，依赖注入就是将对象所依赖的其他对象由外部传递给它，而不是在类内部自己创建。依赖注入的核心思想是**反转对象依赖的控制权**，即对象不负责自己管理依赖，而是由外部（例如Spring IoC容器）来提供它所需要的依赖。

### 依赖注入的核心思想：
传统编程中，对象通常通过自己创建所依赖的对象来完成任务，例如使用 `new` 关键字。而在依赖注入中，对象的依赖关系是通过外部来传递的，这样可以使对象更加灵活、可测试、可扩展。

### 依赖注入的优势：
1. **松耦合**：依赖注入使得类与类之间的依赖关系松散，减少类之间的直接耦合，增强代码的可维护性和扩展性。
2. **可测试性**：由于依赖可以从外部传入，单元测试时可以更方便地传入 mock 对象，而无需依赖实际的实现。
3. **易于扩展和维护**：当需要修改依赖关系时，不需要修改使用依赖的类，只需要改变注入的依赖即可，符合开放封闭原则。

### 依赖注入的类型：
1. **构造函数注入**：
    - 通过构造函数将依赖传递给对象，适合用于那些依赖是必需的场景。
    - 例子：
      ```java
      public class MyService {
          private final MyRepository repository;
 
          // 构造函数注入
          public MyService(MyRepository repository) {
              this.repository = repository;
          }
      }
      ```
      在使用时，外部会通过构造函数提供 `MyRepository` 的具体实现。

2. **Setter方法注入**：
    - 通过 setter 方法来注入依赖，适合那些依赖是可选的场景。
    - 例子：
      ```java
      public class MyService {
          private MyRepository repository;
 
          // Setter 方法注入
          public void setRepository(MyRepository repository) {
              this.repository = repository;
          }
      }
      ```

3. **字段注入**（通过注解）：
    - 直接将依赖注入到对象的字段上，常见于使用 `@Autowired` 注解的场景。
    - 例子：
      ```java
      public class MyService {
          @Autowired
          private MyRepository repository;
      }
      ```
      在这种方式中，Spring 会自动通过反射为 `repository` 字段赋值。

### 依赖注入在Spring中的实现：
Spring 框架是依赖注入的典型实现者，它使用**控制反转（IoC, Inversion of Control）**容器来管理对象的创建和依赖关系。开发者不需要自己管理对象的生命周期和依赖，Spring 容器会根据配置（例如注解或 XML）自动注入依赖。

#### 例子：
1. **构造函数注入**：
   ```java
   @Component
   public class MyService {
       private final MyRepository repository;

       @Autowired
       public MyService(MyRepository repository) {
           this.repository = repository;
       }
   }
   ```
   Spring 容器会自动找到 `MyRepository` 的具体实现，并通过构造函数注入给 `MyService`。

2. **Setter 方法注入**：
   ```java
   @Component
   public class MyService {
       private MyRepository repository;

       @Autowired
       public void setRepository(MyRepository repository) {
           this.repository = repository;
       }
   }
   ```

3. **字段注入**：
   ```java
   @Component
   public class MyService {
       @Autowired
       private MyRepository repository;
   }
   ```

### 总结：
依赖注入是一种简化对象之间关系的设计模式。它通过外部提供依赖对象，而不是在类内部创建依赖对象，减少类之间的耦合度，并且在测试和维护方面提供了极大的便利。Spring 框架通过 IoC 容器很好地实现了依赖注入，使得开发者可以专注于业务逻辑，而不用关心对象的创建和依赖关系的维护。
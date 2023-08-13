# Effective Java, Third Edition
![EJ3e Book Cover](https://www.pearsonhighered.com/assets/bigcovers/0/1/3/4/0134685997.jpg)
## Hot News! Source code finally available on GitHub. Happy Hacking!

## 注意：项目基于 Java9 运行，虽然大部分是关于 Java8 及以下的，若环境为纯 Java8，则需要对不少代码做调整。

## 具体条目
### 创建和销毁对象
1. 用静态工厂方法代替构造器  
优点：  
 1）使用静态工厂方法相比构造器而言可以共享之前创造的对象，而不是每次都创建一个新对象。
2. 遇到多个构造器参数时要考虑使用构建器
3. 用私有构造器或者枚举类型强化 Singleton 属性
4. 通过抛出异常的私有构造器强化不可实例化的能力
5. 优先考虑依赖注入来引用资源，而不要使用 Singleton 和 静态工具类 来实现依赖一个或多个底层资源的类。  
 1）将这些资源传给工厂或构造器（或构建器），通过它们来创建类，这个过程就叫依赖注入
6. 避免创建不必要的对象  
 1）在对于像数据库连接这样的大对象（创建它比较耗费性能和资源），重用是有意义的；  
 2）但是对于一些轻量级的且场景要求我们创建的新对象，也不要吝惜创建  
7. 消除过期的对象引用  
内存泄漏的来源：  
 1）类是自己管理内存，容易造成内存泄漏；  
 2）缓存的积累容易造成内存泄漏；  
 3）监听器和其他回调，如果不及时取消注册，会积累慢慢造成内存泄漏
8. 避免使用终结方法和清除方法
9. try-with-resources 优先于 try-finally

### 对于所有对象都通用的方法
10. 覆盖 equals 时请遵守通用约定  
 面向对象语言的关于等价关系的一个基本问题：  
  1）我们无法在扩展可实例化的类的同时，既增加新的值组件，同时又保留 equals 约定
11. 覆盖 equals 时总要覆盖 hashCode  
 1）如果两个对象调用 equals 相等，则对这两个对象调用 hashCode 所得的结果必须相等，反之不一定成立
12. 始终要覆盖 toString
13. 谨慎地覆盖 clone
14. 考虑实现 Comparable 接口  
 1）如果一个类已经实现了 Comparable 接口，请不要使用继承的方式扩展这个类，可以考虑使用聚合的方式，使这个类的对象作为另一个类的域，这样不影响新的类去实现 Comparable 接口

### 类和接口
15. 使类和成员的可访问性最小化
16. 要在共有类而非公有域中使用访问方法
 1）公有类永远都不应该暴露可变的域，不可变的域（final 的）最好也不要暴露，只不过不可变的域暴露了危害性小一点
17. 使可变性最小化  
 优点：  
  1）不可变对象本质上是线程安全的，它们不要求同步；  
  2）不可变对象可以被自由地共享，也不再需要对它们进行保护性拷贝  
 缺点：  
  1）不可变对象对于每个不同的值都需要创建一个单独的对象，创建这些对象的代价可能很高
18. 复合优先于继承  
 1）只有当子类和超类之间确实存在子类型关系时（is-a），使用继承才是恰当的，否则，为了程序的健壮性和降低对于实现细节的依赖，应该使用复合  
19. 要么设计继承并提供文档说明，要么禁止继承  
 1）好的 API 文档应该描述一个给定的方法做了什么工作，而不是描述它是如何做到的，但是在涉及到关于继承的文档的时候，我们必须描述清楚相应实现的细节，尤其是对于其中可覆盖方法的自用情况（自己调用了自己的可覆盖方法，在子类重写这些方法时，可能会对父类的调用它们的方法造成破坏）；  
 2）为了继承而设计的类，必须在发布之前先编写其子类对其进行测试；  
 3）父类的构造器决不能调用可被覆盖的方法
20. 接口优于抽象类  
 1）接口允许构造非层次结构的类型框架；  
 2）在设计类结构的时候可以考虑用一个抽象类去实现接口的一些方法，以获取继承的好处，这被称为“骨架实现类”  
21. 为后代设计接口
22. 接口只用于定义类型，而不应该用它来导出常量，即将公有的常量放在其中
23. 类层次优先于标签类，实际上就是用继承的方式来设计多种类型事物的代码，对其进行合理的抽象
24. 静态成员类优先于非静态成员类
25. 限制源文件为单个顶级类或接口，这么做可以确保编译时一个类不会多个定义

### 泛型
26. 请不要使用原生态类型  
 1）原生类型：不带任何实际类型参数的泛型名称
27. 消除非受检的警告（而非抑制）
28. 列表优于数组
29. 优先考虑泛型
30. 优先考虑泛型方法
31. 利用有限制的通配符来提升 API 的灵活性  
 1）为获得最大限度的灵活性，要在表示生产者或消费者的输入参数上使用通配符类型，如：<? extends E> 或 <? super E>；  
 2）PECS原则：procedure-extends, consumer-super。即：如果泛型的参数是作为数据的生产者，则对于这个参数的类型 T，使用<? extends T>；如果泛型的参数是作为数据的消费者，则对于这个参数的类型 T，使用 <? super T>；  
 3）上述规则以容器的泛型为例，本质上是父类的容器里可以放子类的对象，而从容器中拿出来的东西需要灵活地被另一个存放父类对象的容器接收；  
 4）不要使用通配符类型作为返回类型  
32. 谨慎并用泛型可变参数  
 1）对于每一个带有泛型可变参数或者参数化类型的方法，都要使用 @SafeVarargs 进行注解  
33. 优先考虑类型安全的异构容器  
 1）集合 API 限制每个容器只能有固定数目的类型参数，我们可以通过将类型参数放在键上而不是容器上来避开这一限制。对于这种类型安全的异构容器，可以用 Class 对象作为键，以这种方式使用的 Class 对象称为类型令牌

### 枚举和注解
34. 用 enum 代替 int 常量  
 1）枚举类型中的抽象方法必须被它的所有常量中的具体方法所覆盖；  
 2）每当需要一组固定常量，并且在编译时就知道成员的时候，就应该使用枚举  
35. 用实例域代替序数，就是代替由枚举类型的 ordinal() 导出的序数
36. 用 EnumSet 代替位域，主要用于在传递多组常量集时的操作
37. 用 EnumMap 代替序数索引（序数是使用枚举的 ordinal() 获得的）
38. 
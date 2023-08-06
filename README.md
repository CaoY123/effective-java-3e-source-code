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



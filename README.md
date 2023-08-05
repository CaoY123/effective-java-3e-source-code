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


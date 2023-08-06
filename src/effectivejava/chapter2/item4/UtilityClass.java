package effectivejava.chapter2.item4;

// Noninstantiable utility class (Page 19)

/**
 * 用抛出异常的私有构造器强化不可实例化的能力
 *
 * 有时会需要编写只包含静态域和静态方法的类（如：某些工具类），这时，我们没有必要对这样的类进行实例化，
 * 但是如果我们不提供任何构造器，编译器会为它们提供一个默认的无惨构造器以用于可能的实例化（事实上这是不需要的），
 * 所以我们需要提供一个私有的构造器来强化这样的类的不可实例化的能力（相当于占着茅坑不拉屎），而且可以直接让
 * 这个构造器直接抛出一个异常，这样避免了内部以及反射对它的调用，由此强化了不可实例化的能力。
 *
 * 上面这么做的弊端：使得使用了抛出异常的私有构造器不能被子类化，因为如果将这样的类作为父类，它的子类在
 * 实例化的时候会调用父类的构造器，而这显然是行不通的。
 *
 * 我们不应该在抽象类中实现所谓的“不可实例化”的目标，
 * 因为超类会给人一种暗示：即必须实现它的子类，实际上
 * 我们并不是这个意思。
 */
public class UtilityClass {
    // Suppress default constructor for noninstantiability
    private UtilityClass() {
        throw new AssertionError();
    }

    // Remainder omitted
}

package effectivejava.chapter2.item2.hierarchicalbuilder;
import java.util.*;

// Builder pattern for class hierarchies (Page 14)

// Note that the underlying "simulated self-type" idiom  allows for arbitrary fluid hierarchies, not just builders

/**
 * 这个 Builder 类原作者写的太好了，太精巧了。他用了一个泛型，其中的类型还是继承自自己的 Builder 类型。
 * 这样边可以在抽象类 Pizza 的 Builder 类中写出可以供后续继承类使用的方法 addTopping() 和搭
 * 出供继承类实现的方法 self() 的框架，值得我学习。
 *
 * Builder 模式可能会比重叠构造器模式书写的代码更加冗长，但是它更适用于参数
 * 更多的情况，如 4 个及以上的参数个数，而且最好一开始就使用 Builder 来
 * 构建类，而不是等参数逐渐增加后再修改，那样会很麻烦，故这需要我们对自己的类
 * 的未来可能参数数量的变化有一个简单的预计。
 */
public abstract class Pizza {
    public enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE }// 配料枚举
    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        // Subclasses must override this method to return "this"
        protected abstract T self();
    }
    
    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone(); // See Item 50
    }
}

package effectivejava.chapter2.item3.enumtype;

// Enum singleton - the preferred approach (Page 18)

/**
 * 单元素枚举实现单例
 * 这种方法简洁、无偿提供了序列化机制，而且绝对能防止使用反射破坏单例（至少之前的反射可以防止），
 * 大佬前辈说它是实现单例的最好的方法，但是如果当我们的单例必须扩展一个超类而非一个 Enum 的时候，
 * 则不应该使用这个方法。
 */
public enum Elvis {
    INSTANCE;

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    // This code would normally appear outside the class!
    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();

        Elvis elvis1 = Elvis.INSTANCE;
        System.out.println("是否为同一个对象：" + (elvis == elvis1 ? "是" : "否"));
    }
}

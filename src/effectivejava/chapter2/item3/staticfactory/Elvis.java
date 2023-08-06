package effectivejava.chapter2.item3.staticfactory;

// Singleton with static factory (Page 17)

/**
 * 静态工厂实现单例
 * 这种方式比用 公有域实现单例 更清晰，让人更容易看出这是单例，虽然也无法抵御反射机制对于
 * 单例的破坏，但是却不是将用户往那个方向引导，一般来讲我们获取单例的实例是通过 getInstance()
 */
public class Elvis {
    private static final Elvis INSTANCE = new Elvis();
    private Elvis() { }
    public static Elvis getInstance() { return INSTANCE; }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    // This code would normally appear outside the class!
    public static void main(String[] args) {
        Elvis elvis = Elvis.getInstance();
        elvis.leaveTheBuilding();
    }
}

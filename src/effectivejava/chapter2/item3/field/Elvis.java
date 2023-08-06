package effectivejava.chapter2.item3.field;

// Singleton with public final field  (Page 17)

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 公有域实现单例
 * 对于下面的单例类，可以通过反射机制调用私有构造器来破坏单例。
 */
public class Elvis {
    public static final Elvis INSTANCE = new Elvis();

    private Elvis() { }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    // This code would normally appear outside the class!
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();

        Elvis elvis1 = Elvis.INSTANCE;
        System.out.println("是否为同一个对象：" + (elvis == elvis1 ? "是" : "否"));

        // 通过使用反射机制破坏单例
        Class<Elvis> elvisClass = Elvis.class;
        Constructor<Elvis> constructor = elvisClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        Elvis elvis2 = constructor.newInstance();
        System.out.println("反射构造的 Elvis 对象");
        elvis2.leaveTheBuilding();
        System.out.println("是否为同一个对象：" + (elvis == elvis2 ? "是" : "否"));
    }
}
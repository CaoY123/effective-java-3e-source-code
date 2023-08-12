package effectivejava.chapter5.item28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

// List-based Chooser - typesafe (Page 129)

/**
 * 数组是协变的，列表是可变的
 * 1. 即若 Sub 为 Super 的子类型，则数组 Sub[] 也是 Super[] 的子类型；
 * 而 List<Sub> 不是 List<Super> 的子类型。
 * 2. 基于 1 中的特点，数组提供了运行时的类型安全，但却没有提供编译时的类型安全（有相应错误不能在编译期发现，
 * 而要等到运行期才能发现）；而泛型则是提供了编译时的类型安全，却没有提供运行时的类型安全（运行时会进行类型擦除）。
 * 3. 当混用数组和列表收到编译警告或是有错误时，考虑用列表代替数组，损失一些性能，但却可以收获安全性。
 */
public class Chooser<T> {
    private final List<T> choiceList;

    public Chooser(Collection<T> choices) {
        choiceList = new ArrayList<>(choices);
    }

    public T choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceList.get(rnd.nextInt(choiceList.size()));
    }

    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 4, 5, 6);

        Chooser<Integer> chooser = new Chooser<>(intList);

        for (int i = 0; i < 10; i++) {
            Number choice = chooser.choose();
            System.out.println(choice);
        }
    }
}

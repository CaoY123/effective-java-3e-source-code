package effectivejava.chapter5.item28;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CaoY
 * @date 2023-08-12 11:34
 * @description 数组和泛型不能很好地混用
 * 原因：数组是具体化的，数组会在运行时知道和强化它们的元素类型；相比之下，泛型则是通过擦除（erasure）实现的，
 * 这意味着，泛型只在编译时强化它们的类型信息，并在运行时丢弃（或擦除）它们的元素类型信息。擦除就是使泛型可以与
 * 没有使用泛型的代码随意进行互用，以保证对前面 JDK 版本代码的互操作性。
 */
public class Test1 {
    public static void main(String[] args) {
        // 下面的表达式非法
//        List<String> [] lists = new List<String>[];
    }

    private static <E> void func(E e) {
        List<E> list = new ArrayList<>();
        list.add(e);
        // 下面的表达式非法
//        List<E> [] lists = new List<E>[];
//        E[] es = new E[];
    }
}

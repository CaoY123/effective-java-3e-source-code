package effectivejava.chapter5.item26;

import java.util.Set;

/**
 * @author CaoY
 * @date 2023-08-12 3:07
 * @description 使用通配符定义泛型方法
 */
public class Test1 {
    // Set<?> 为“摸个类的集合”，? 表示无限制类型的通配符
    private static void numElementsInCommon(Set<?> set1, Set<?> set2) {
        System.out.println("成功地调用了这个方法");
        System.out.println(set1);
        System.out.println(set2);
    }

    public static void main(String[] args) {
        Set<Integer> set1 = Set.of(1, 2, 3, 4, 5);
        Set<String> set2 = Set.of("Today", "is", "a", "good", "day");
        numElementsInCommon(set1, set2);

        Set set3 = Set.of(1, 1.05, "abc");
        numElementsInCommon(set1, set3);
    }
}

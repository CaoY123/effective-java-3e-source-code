package effectivejava.chapter5.item26;

import java.util.List;
import java.util.Set;

/**
 * @author CaoY
 * @date 2023-08-12 3:15
 * @description
 * 例外：
 * 1. 必须在类文字（涉及 class 的时候）使用原生类型
 * 2. 关于 instanceof 的使用，也应该使用原生类型（测试发现使用 ? 的通配符类型也可以）
 */
public class Test2 {
    public static void main(String[] args) {
        // 合法表示
        System.out.println(List.class);
        System.out.println(String[].class);
        System.out.println(int.class);

        // 非法表示，会报错
//        System.out.println(List<String>.class);
//        System.out.println(List<?>.class);
        Set<String> set1 = Set.of("Today", "is", "good");
        System.out.println(func(set1));
    }

    private static boolean func(Object obj) {
        if (obj instanceof Set<?>) {// 这里可以用 ? 通配符或者原生泛型，但是不能用具体的参数泛型
            Set<?> set = (Set<?>) obj;// 可以进行强制转换，也可以用 Set<String> 强转
            System.out.println(set);
            return true;
        }
        return false;
    }
}

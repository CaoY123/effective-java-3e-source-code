package effectivejava.chapter5.item32;

import java.util.List;

// It is unsafe to store a value in a generic varargs array parameter (Page 146)
// 当一个参数化类型的变量指向一个不是该类型的对象时，会产生堆污染，
// 它导致编译器的自动生成转换失败，破坏了泛型系统的基本保证
public class Dangerous {
    // Mixing generics and varargs can violate type safety!
    // 混合使用泛型和变量会违反类型安全!
    static void dangerous(List<String>... stringLists) {
        List<Integer> intList = List.of(42);
        Object[] objects = stringLists;
        objects[0] = intList; // Heap pollution
        String s = stringLists[0].get(0); // ClassCastException
    }

    public static void main(String[] args) {
        dangerous(List.of("There be dragons!"));
    }
}

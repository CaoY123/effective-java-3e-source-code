package effectivejava.chapter5.item26;
import java.util.*;

// Fails at runtime - unsafeAdd method uses a raw type (List)!  (Page 119)
// List<String> 是 List 的子类，但不是 List<Object> 的子类
public class Raw {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, Integer.valueOf(42));
        String s = strings.get(0); // Has compiler-generated cast
    }

    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }

    // 使用 List<Object> 无法通过编译
//    private static void unsafeAdd(List<Object> list, Object o) {
//        list.add(o);
//    }
}


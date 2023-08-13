package effectivejava.chapter5.item31;
import java.util.*;

// Using a recursive type bound with wildcards (Page 143)
public class RecursiveTypeBound {
    // Comparable 是消费者，List 相当于生产者，
    // 所以应用 PECS(procedure-extends, consumer-super) 原则如下
    public static <E extends Comparable<? super E>> E max(
        List<? extends E> list) {
        if (list.isEmpty())
            throw new IllegalArgumentException("Empty list");

        E result = null;
        for (E e : list)
            if (result == null || e.compareTo(result) > 0)
                result = e;

        return result;
    }

    public static void main(String[] args) {
        List<String> argList = Arrays.asList(args);
        System.out.println(max(argList));
    }
}
package effectivejava.chapter5.item30;
import java.util.*;

// Using a recursive type bound to express mutual comparability (Pages 137-8)
// 使用递归类型绑定来表示相互的可比性
public class RecursiveTypeBound {
    // Returns max value in a collection - uses recursive type bound
    // 返回集合中的最大值-使用递归类型绑定
    // E extends Comparable<E> 表示针对可以与自身进行比较的每个类型 E
    public static <E extends Comparable<E>> E max(Collection<E> c) {
        if (c.isEmpty())
            throw new IllegalArgumentException("Empty collection");

        E result = null;
        for (E e : c)
            if (result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);

        return result;
    }

    public static void main(String[] args) {
        List<String> argList = Arrays.asList(args);
        System.out.println(max(argList));
    }
}
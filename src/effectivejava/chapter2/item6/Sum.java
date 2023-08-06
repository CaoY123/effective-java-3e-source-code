package effectivejava.chapter2.item6;

import java.util.Comparator;

// Hideously slow program! Can you spot the object creation? (Page 24)

/**
 * 基本类型参与运算比装箱后参与运算快多了，所以要优先使用基本类型，避免不必要的装箱。
 */
public class Sum {
    private static long sum() {
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        return sum;
    }

    public static void main(String[] args) {
        int numSets = 6;
        long x = 0;

        for (int i = 0; i < numSets; i++) {
            long start = System.nanoTime();
            x += sum();
            long end = System.nanoTime();
            System.out.println((end - start) / 1_000_000. + " ms.");
        }

        // Prevents VM from optimizing away everything.
        if (x == 42)
            System.out.println();
    }
}
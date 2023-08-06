package effectivejava.chapter2.item6;
import java.util.regex.Pattern;

// Reusing expensive object for improved performance (Pages 22 and 23)
public class RomanNumerals {
    // Performance can be greatly improved! (Page 22)
    static boolean isRomanNumeralSlow(String s) {
        /**
         * 下面的正则 matches() 可以用于判断一个字符串是否与正则表达式匹配，
         * 可是 matches() 的每次调用都会生成一个 Pattern 对象，创建这个 Pattern
         * 对象的成本很高，它需要将正则表达编译成一个有限状态机
         */
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
                + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    // Reusing expensive object for improved performance (Page 23)
    /**
     * 对于上面因不能重用 Pattern 对象而导致的性能问题的改进，缓存了 Pattern 对象，
     * 大大提升了性能。当然如果下面的 isRomanNumeralFast() 写出来后没有被调用过，
     * 还可以考虑延迟初始化 Pattern 对象 ROMAN，但是没有必要这样做，这样会使代码变复杂，
     * 从而会使得第一次的性能受影响，本来是为了解决性能问题，反而有点得不偿失了。
     */
    private static final Pattern ROMAN = Pattern.compile(
            "^(?=.)M*(C[MD]|D?C{0,3})"
                    + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    static boolean isRomanNumeralFast(String s) {
        return ROMAN.matcher(s).matches();
    }

    public static void main(String[] args) {
        int numSets = Integer.parseInt(args[0]);
        int numReps = Integer.parseInt(args[1]);
        boolean b = false;

        for (int i = 0; i < numSets; i++) {
            long start = System.nanoTime();
            for (int j = 0; j < numReps; j++) {
                b ^= isRomanNumeralSlow("MCMLXXVI");  // Change Slow to Fast to see performance difference
            }
            long end = System.nanoTime();
            System.out.println(((end - start) / (1_000. * numReps)) + " μs.");
        }

        // Prevents VM from optimizing away everything.
        if (!b)
            System.out.println();
    }
}


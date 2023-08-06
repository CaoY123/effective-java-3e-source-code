package effectivejava.chapter2.item7;
import java.util.*;

// Can you spot the "memory leak"?  (Pages 26-27)

/**
 * 下面的栈有内存泄漏的风险，即当实际放数据的数组 elements 越来越大，但是实际的有效数据部分就是
 * 下标小于 size 的部分，那么下标大于等于 size 的就是无效的数据部分，这些虽然会随着所谓的 pop
 * 从理论上“被弹出”，可依然会被引用持有着，无法被垃圾回收掉，只有在放入的数据躲过 elements 的极限
 * 才会在把它们拷贝到新空间，此时才会垃圾回收旧空间，但是新空间又发生了类似的情况。而且若数据规模不断
 * 扩大，可能会发生内存分配不足的情况（无效数据区域太大了），这些区域无法被垃圾回收掉，发生内存泄漏，
 * 虽然这个概率很小。
 */
public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        return elements[--size];
    }

    /**
     * Ensure space for at least one more element, roughly
     * doubling the capacity each time the array needs to grow.
     */
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

//    // Corrected version of pop method (Page 27)

    /**
     * 改进的 pop() 版本
     * 每弹出一个对象，就解除一个引用（将引用置为 null），这样可以保证弹出的对象及时被垃圾回收掉
     */
//    public Object pop() {
//        if (size == 0)
//            throw new EmptyStackException();
//        Object result = elements[--size];
//        elements[size] = null; // Eliminate obsolete reference
//        return result;
//    }

    /**
     * 可是也没有必要遇到一个没用的对象引用，就把它清空。清除对象引用应该是一种例外，而不是一种规范。
     * 消除过期的对象引用最好的方式就是包含该引用的变量结束生命周期。
     *
     * 之所以 Stack 类会有内存泄漏的问题，是因为 Stack 是自己管理内存的。因为 elements 分为有效数据部分
     * 和无效数据部分，而垃圾回收器并不知道这个区分。所以：只要类是自己管理内存，我们就应该警惕内存泄漏问题。
     */
    public static void main(String[] args) {
        Stack stack = new Stack();
        for (String arg : args)
            stack.push(arg);

        while (true)
            System.err.println(stack.pop());
    }
}

package effectivejava.chapter7.item45;

/**
 * @author CaoY
 * @date 2023-08-14 20:23
 * @description Stream 支持三种基本类型：int、long、double
 * 最好避免利用 Stream 处理 char 值
 */
public class Test {
    public static void main(String[] args) {
        // "Hello world!".chars() 得到的是 IntStream
        "Hello world!".chars().forEach(System.out::print);
        System.out.println();
        // 利用强制转换可解决上面的问题
        "Hello world!".chars().forEach(x -> System.out.print((char) x));
    }
}

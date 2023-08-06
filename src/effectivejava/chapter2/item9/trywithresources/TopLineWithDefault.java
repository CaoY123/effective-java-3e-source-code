package effectivejava.chapter2.item9.trywithresources;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 使用 try-with-resources 时，针对关闭资源过程中可能出现的异常，可以直接使用一套 catch 块
 * 捕获处理即可，无需再像在 try-finally 的 finally 块中需要再捕获异常。
 */
public class TopLineWithDefault {
    // try-with-resources with a catch clause  (Page 36)
    static String firstLineOfFile(String path, String defaultVal) {
        try (BufferedReader br = new BufferedReader(
                new FileReader(path))) {
            return br.readLine();
        } catch (IOException e) {
            return defaultVal;
        }
    }

    public static void main(String[] args) throws IOException {
        String path = args[0];
        System.out.println(firstLineOfFile(path, "Toppy McTopFace"));
    }
}

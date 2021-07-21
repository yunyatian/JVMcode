package chapter3.code;
/**
 * 用来体会栈溢出并且设置栈大小的尝试
 * 不断尝试调用自身，从而导致StackOverflowError栈溢出异常
 * 默认栈的大小可以输出count：11413
 * 修改栈大小-Xss256k后count：2460
 * */
public class StackDeepTest {
    private static int count = 1;

    public static void main(String[] args) {
        System.out.println(count);
        count++;
        main(args);
    }
}

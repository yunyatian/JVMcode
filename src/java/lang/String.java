package java.lang;
/**
 * 在加载器时，因为是java.lang.String，所以使用的是启动类（引导类）加载器，而该加载器调用的是核心代码库，核心代码库没有main方法，所以报错
 * 报错内容为：在类 java.lang.String 中找不到 main 方法
 * */
public class String {
    public static void main(String[] args) {
        System.out.println("Hello!");
    }
}

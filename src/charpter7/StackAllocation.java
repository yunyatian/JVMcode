package charpter7;
/**
 * 栈上分配测试
 * -Xms1G -Xmx1G -XX:-DoEscapeAnalysis -XX:+PrintGCDetails
 * 不使用逃逸分析时运行时间为115ms，使用逃逸分析时运行时间为5ms
 *
 * 可以试试将-Xms1G和-Xmx1G换为-Xms256m和-Xmx256m，会发现逃逸分析不会发生GC，而不使用逃逸分析会发生GC
 * */
public class StackAllocation {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 10000000; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println("花费时间为"+ (end-start) + "ms");
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void alloc() {
        User user = new User();
    }

    static class User{}
}

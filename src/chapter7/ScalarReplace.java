package chapter7;
/**
 * -Xms100m -Xmx100m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:-EliminateAllocations
 * 不使用标量替换的情况下，花费时间为93ms，有GC，情况如下：
 * [GC (Allocation Failure)  25600K->768K(98304K), 0.0016925 secs]
 * [GC (Allocation Failure)  26368K->720K(98304K), 0.0010964 secs]
 * [GC (Allocation Failure)  26320K->704K(98304K), 0.0012586 secs]
 * [GC (Allocation Failure)  26304K->704K(98304K), 0.0011101 secs]
 * [GC (Allocation Failure)  26304K->736K(98304K), 0.0010242 secs]
 * [GC (Allocation Failure)  26336K->736K(101376K), 0.0008840 secs]
 * [GC (Allocation Failure)  32480K->652K(101376K), 0.0011627 secs]
 * [GC (Allocation Failure)  32396K->652K(101376K), 0.0007146 secs]
 * 花费的时间为：93ms
 *
 * 使用标量替换的情况下：花费时间为5ms，无GC，情况如下：
 * 花费的时间为：5ms
 * */
public class ScalarReplace {
    public static class User{
        public int id;
        public String name;
    }

    public static void alloc(){
        User user = new User();
        user.id = 1213;
        user.name = "JK";
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为："+ (end - start) + "ms");
    }
}

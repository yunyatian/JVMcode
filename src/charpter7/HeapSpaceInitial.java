package charpter7;

/**
 * 1.-Xms 用来设置初始化堆空间（年轻代+老年代）的大小
 *       -X 是JVM的运行参数
 *       ms 是memory start
 *   -Xmx 用来设置堆空间（年轻代+老年代）最大内存的大小
 *
 * 2.默认情况下：堆空间的初始化的内存大小：物理电脑内存内存/64
 *             堆空间的最大的内存大小：物理电脑内存内存/4
 *
 * 3.手动设置：-Xms600m -Xmx600m
 *      一般在开发过程中会将堆内存大的初始化大小和最大内存大小设置为一致的，避免过于频繁的动态分配空间和GC操作，降低工作效率
 *      为什么堆内存空间设置为600M，程序运行时显示结果确为575M？
 *      答：因为新生代中的幸存者0区（S0区）和幸存者1区（S1区），两个区只有一个会被使用，所以统计的时候只统计其中一个
 *
 * 4.产看设置的参数：方式一：jps：获取所有进程的进程id
 *                       jstat -gc 进程id：获取该进程的堆空间使用情况
 *                 方式二：-XX:+PrintGCDetails
 * */
public class HeapSpaceInitial {
    public static void main(String[] args) {
        // 获取JVM初始化堆的大小
        long initialMemory = Runtime.getRuntime().totalMemory()/1024/1024;
        // 获取JVM堆空间最大空间
        long maxMemory = Runtime.getRuntime().maxMemory()/1024/1024;
        System.out.println("initialMemory:"+initialMemory+"M");
        System.out.println("maxMemory:"+maxMemory+"M");

//        System.out.println("系统空间为："+initialMemory*64/1024+"G");
//        System.out.println("系统空间为："+maxMemory*4/1024+"G");

//        try {
//            Thread.sleep(1000000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}

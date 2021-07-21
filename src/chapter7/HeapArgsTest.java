package chapter7;
/**
 * 测试堆空间的JVM参数：
 * -XX:+PrintFlagsInitial:查看所有参数的默认配置
 * -XX:+PrintFlagsFinal：产看所有的参数最终值（可能存在修改，不再是初始值）
 * 查看某个进程单个信息的方法：
 *              jps 获取当前所有进程的进程号
 *              jinfo -flag 查看信息 进程id，例如：jinfo -flag NewRatio 进程id
 * -Xms:初始堆空间内存（默认为物理内存的1/64）
 * -Xmx:最大堆内存空间（默认为物理内存的1/4）
 * -Xmn:设置新生代的大小（初始值及最大值）
 * -XX:NewRatio:配置新生代和老年代的在堆空间结构的占比
 *
 * -XX:SurvivorRatio:设置新生代中Eden和S0/S1空间的比例
 *
 *     Eden区过大的话会导致S0区和S1区过小，要不了多久就有可能会导致一些对象直接存储到老年代，
 * 且会让Minor GC失去部分意义，因为Minor GC除了会处理Eden区，也会处理S0区和S1区，而Eden区
 * 过大，导致直接存储到老年代，Minor GC无法处理到这部分对象
 *     Eden区过小会导致Minor GC过于频繁，而GC时会使得用户进程停止运行，这是很不好的体验
 *
 * -XX:MaxTenuringThreshold:设置新生代垃圾的最大年龄（即S0/S1区内的对象进入老年代的阈值）
 * -XX:PrintGCDetails:输出详细的GC处理日志
 * 打印gc简要信息：①-XX:PrintGC ②-verbose:gc
 * -XX:HandlePromotionFailure:是否设置空间分配担保
 * */
public class HeapArgsTest {
}

package chapter8;
/**
 * -Xms200m -Xmx200m -XX:MetaspaceSize=300m -XX:MaxMetaspaceSize=300m -XX:+PrintGCDetails
 *
 * Heap
 *  PSYoungGen      total 59904K, used 5179K [0x00000000fbd80000, 0x0000000100000000, 0x0000000100000000)
 *   eden space 51712K, 10% used [0x00000000fbd80000,0x00000000fc28ee78,0x00000000ff000000)
 *   from space 8192K, 0% used [0x00000000ff800000,0x00000000ff800000,0x0000000100000000)
 *   to   space 8192K, 0% used [0x00000000ff000000,0x00000000ff000000,0x00000000ff800000)
 *  ParOldGen       total 136704K, used 102400K [0x00000000f3800000, 0x00000000fbd80000, 0x00000000fbd80000)  new的100M的byte数组存在老年代
 *   object space 136704K, 74% used [0x00000000f3800000,0x00000000f9c00010,0x00000000fbd80000)
 *  Metaspace       used 3303K, capacity 4496K, committed 4864K, reserved 1056768K
 *   class space    used 359K, capacity 388K, committed 512K, reserved 1048576K
 * */
public class StaticFieldTest {
    private static byte[] arr = new byte[1024*1024*100];//100MB

    public static void main(String[] args) {
        System.out.println(StaticFieldTest.arr);

//        try{
//            Thread.sleep(10000000);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
    }
}

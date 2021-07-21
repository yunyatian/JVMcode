package charpter7;

import java.util.ArrayList;
import java.util.List;
// TODO GC尚未学习，可能存在一些未知的知识点，留待以后解决
/**
 * [GC (Allocation Failure) [PSYoungGen: 1992K->504K(2560K)] 1992K->830K(9728K), 0.0018391 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
 * //TODO 或者说为什么第一次GC之后的堆空间的大小要比年轻代要大？如果说存储在老年代，那为什么？超大对象存储进老年代？首先326K算不上超大对象，Eden区一定存储的下，另外如果是超大对象，因为举例的特殊性，之后的对象都应该是超大对象，都应该存储在老年代，但从下面的数据可以很明显的看出，之后的对象存储在年轻代
 * [GC (Allocation Failure) [PSYoungGen: 2008K->504K(2560K)] 2334K->1950K(9728K), 0.0009011 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * [GC (Allocation Failure) [PSYoungGen: 2439K->504K(2560K)] 7534K->6238K(9728K), 0.0010942 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * [GC (Allocation Failure) [PSYoungGen: 504K->504K(2560K)] 6238K->6270K(9728K), 0.0005343 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * [Full GC (Allocation Failure) [PSYoungGen: 504K->0K(2560K)] [ParOldGen: 5766K->4276K(7168K)] 6270K->4276K(9728K), [Metaspace: 3211K->3211K(1056768K)], 0.0074447 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
 * [GC (Allocation Failure) [PSYoungGen: 72K->128K(2560K)] 6781K->6836K(9728K), 0.0005969 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * [Full GC (Ergonomics) [PSYoungGen: 128K->0K(2560K)] [ParOldGen: 6708K->5474K(7168K)] 6836K->5474K(9728K), [Metaspace: 3250K->3250K(1056768K)], 0.0037888 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * [GC (Allocation Failure) [PSYoungGen: 0K->0K(1536K)] 5474K->5474K(8704K), 0.0004966 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * [Full GC (Allocation Failure) [PSYoungGen: 0K->0K(1536K)] [ParOldGen: 5474K->5443K(7168K)] 5474K->5443K(8704K), [Metaspace: 3250K->3250K(1056768K)], 0.0071913 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
 * */
public class GCTest {
    public static void main(String[] args) {
        int i = 0;

        try {
            List<String> list = new ArrayList<>();
            String string = "JsYuan is handsome";
            while (true) {
                System.out.println(String.format("第%d次",i+1));
                list.add(string);
                string += " " + string;
                i++;
            }
        }catch (Exception e){
            System.out.println("遍历次数为："+i);
            e.printStackTrace();
        }
    }
}

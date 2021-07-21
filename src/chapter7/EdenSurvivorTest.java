package chapter7;
/**
 * -Xms600m -Xmx600m
 * -XX:NewRatio:配置老年代与新生代的比例，默认值为2
 * -XX:SurvivorRatio:配置新生代中Eden和Survivor0和Survivor1区的比例，一般默认为8，注意，这里官方文档和检测的结果都是8：1：1，但实际看空间分配为6：1；1，所以一般最好更改设置为-XX:SurvivorRatio=8
 * -XX:-UseAdaptiveSizePolicy:关闭默认配置，一般不用
 * -Xmn：设置新生代的具体大小(一般不使用，但如果和-XX:NewRatio一起使用，生效的是-Xmn)
 * jinfo -flag NewRatio/SurvivorRatio 进程id
 * */
public class EdenSurvivorTest {
    public static void main(String[] args) {
        System.out.println("start......");
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package chapter8;

import java.io.Serializable;
/**
 * javap -v -p .class文件，可以使得被定义为private在字节码文件中仍会反编译显示的展示
 * javap -v -p .class > 文件地址/文件名 可以将反编译的字节码文件放到指定位置
 * */
public class MethodInnerStructTest extends Object implements  Comparable<String>, Serializable {
    public int num = 10;
    private static String string = "hello";


    public void test1(){
        int count = 20;
        System.out.println("count= "+count);
    }

    public static int test2(int val){
        int result = 30;
        try{
            int x= 40;
            result = val/x;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


    @Override
    public int compareTo(String o) {
        return 0;
    }
}

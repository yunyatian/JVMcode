package chapter5;

import java.util.Date;

/**
 * 字节码文件中startPC代表的是该属性生效的位置，即存入栈之后的下一行，而不是从定义的位置开始算起的，
 * */
public class LocalVariableTest {
    public static int m = 1;
    public static void main(String[] args) {
        LocalVariableTest localVariableTest = new LocalVariableTest();
        Date date = new Date();
        int count = 10;
        System.out.println(count);
    }

    public void test1(){
        int i = 0;
        double j = 2.0;//从字节码文件中可以看出double类型的j占据了2和3两个Slot
        int x = 0;
    }
    public static void test2(){
        int k = 0;
        //以下代码报错，因为static修饰的方法中局部变量表中不存储this，也就是当前类的信息，故查找不到，报错
        //this.m++;
    }

    public void test3(){
        int x  = 1;
        int z = 3;
        //以下为局部变量，当使用完毕以后会释放之前所占用的Slot，这时后面到来的变量会占用该释放Slot，从而实现Slot的复用
        {
            int y = 2;
        }
        int m = 10;

    }

}

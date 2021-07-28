package chapter8;

import org.omg.CORBA.ObjectHolder;

/**
 * 在JDK7环境下staticObj随着Test的类型信息存放在方法区，instanceObj随着Test的对象实例存放在Java堆，
 * LocalObject则是存放在foo（）方法栈则的局部变量表中。但是new的内容都会存放在Java堆中进行分配。
 * */
public class StaticObjTest {
    static class Test{
        static ObjectHolder staticObj = new ObjectHolder();
        ObjectHolder instanceObj = new ObjectHolder();

        void foo(){
            ObjectHolder localObj = new ObjectHolder();
            System.out.println("done");
        }
    }

    public static void main(String[] args) {
        Test test = new StaticObjTest.Test();
        test.foo();
    }
}

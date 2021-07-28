package chapter8;

public class MethodAreaTest {
    public static void main(String[] args) {
        Order order = null;
        //静态变量和静态方法即使实例对象是null，也能调用
        order.test();
        System.out.println(order.count);
    }
}

/**
 * 设置静态（static）变量count在编译时并不会赋值，赋值会发生在<clinit>
 * public static int count;
 *     descriptor: I
 *     flags: ACC_PUBLIC, ACC_STATIC
 *
 * 设置常量（static final）val在编译时就已经进行了赋值
 *   public static final int val;
 *     descriptor: I
 *     flags: ACC_PUBLIC, ACC_STATIC, ACC_FINAL
 *     ConstantValue: int 2
 * */
class Order{
    public static int count = 1;
    public static final int val = 2;
    public static void test(){
        System.out.println("test");
    }
}


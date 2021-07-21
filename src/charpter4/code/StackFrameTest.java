package charpter4.code;
/**
 * javap -v StackFrameTest.class查看编译后文件
 * */
public class StackFrameTest {
    public static void main(String[] args) {
        methodA();
    }
    public static void methodA(){
        System.out.println("methodA开始执行");
        methodB();
//        System.out.println(10/0);//一旦出现异常如果本级别没有捕获，则直接抛给上级，不进行之后的操作
        System.out.println("methodA正常结束");
    }
    public static int methodB(){
        System.out.println("methodB开始执行");
        int i = 10;
        int j = (int) methodC();
        System.out.println("methodB即将结束");
        return i+j;
    }

    public static double methodC() {
        System.out.println("methodC开始执行");
        double i = 10.0;
        System.out.println("methodC即将结束");
        return i;
    }
}

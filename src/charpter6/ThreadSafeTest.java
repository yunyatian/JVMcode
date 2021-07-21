package charpter6;
/**
 * 线程安全需要数据在方法内诞生，在方法结束的时候数据会随着方法的结束而销毁。
 * */
public class ThreadSafeTest {
    // stringBuilder线程安全：因为stringBuilder在methodA方法产生，且随着methodA的结束而销毁
    public static void methodA(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("a");
        stringBuilder.append("b");
    }

    // stringBuilder线程不安全：因为stringBuilder是从外界传参进入methodB中的，methodB方法结束，该参数并不会销毁
    public static void methodB(StringBuilder stringBuilder){
        stringBuilder.append("a");
        stringBuilder.append("b");
    }

    // stringBuilder线程不安全：虽然stringBuilder是在methodC内部诞生，
    // 但返回时却将stringBuilder传了出去，导致stringBuilder并不会随着方法的结束而销毁
    public static StringBuilder methodC(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("a");
        stringBuilder.append("b");
        return stringBuilder;
    }

    // stringBuilder线程安全：因为stringBuilder在方法内部诞生，且返回的值是String，并不是StringBuilder，
    // 所以stringBuilder进行了一次toString加工，toString方法会new一个新的String返回，原先的stringBuilder会随着方法的结束而销毁
    public static String methodD(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("a");
        stringBuilder.append("b");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();

        new Thread(()->{
            stringBuilder.append("a");
            stringBuilder.append("b");
        }).start();

        methodB(stringBuilder);
    }
}

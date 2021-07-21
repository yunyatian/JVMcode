package charpter7;

public class SimpleHeap {
    private int id;

    public SimpleHeap(int id) {
        this.id = id;
    }

    public void show(){
        System.out.println(this.id);
    }
    /**
     * 字节码文件中使用到new的都是在构造对象，会将对象的引用放入虚拟机栈中的局部变量表，对象的内容放入堆中
     * */
    public static void main(String[] args) {
        SimpleHeap s1 = new SimpleHeap(1);
        SimpleHeap s2 = new SimpleHeap(2);

        int[] arr = new int[6];
        Object[] objects = new Object[2];
    }
}

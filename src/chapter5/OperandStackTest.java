package chapter5;

public class OperandStackTest {
    public int getSum(){
        int i = 10;
        int j = 20;
        int k = i+j;
        return k;
    }

    public void TestGetSum(){
        int x = getSum();
    }
/**
 * 综合以下情况可理解：
 * i++：是先将局部变量表中的i值取出到操作数栈（如果后续没有什么需要i的操作，取出到操作数栈这一步可省略），再对局部变量表中的i进行+1
 * ++i: 是将局部变量表中的i值进行+1操作，然后再留待后续操作
 * i++中iload在先，iinc在后，++i中iinc在前，iload在后（iload可以不存在）
 * */
    public static void add(){
        //第一类问题
        int i1 = 1;
        i1++;//2
        int i2 = 1;
        ++i2;//2

        //第二类问题
        int i3 = 1;
        int i4 = i3++;
        int i5 = 1;
        int i6 = ++i5;

        //第三类问题
        /**
         * iconst_1
         * istore 6
         * iload 6
         * iinc 6 by 1
         * istore 6
         * 个人理解：iload将栈帧中局部变量表中栈位置为6的值取出放入操作数栈，此时局部变量表中为1，iinc 6 by 1是将局部变量表中的栈位置为6内的值进行加1操作，此时局部变量表中的值2
         *         istore 6将操作数栈的内容存入局部变量表中栈位置为6的地方，对局部变量表中的值进行覆盖，改为1。
         * 结合以上理解可以得出操作数栈内的内容并没有进行加1操作，所以istore时会将已经过+1操作的局部变量表的内容进行覆盖
         */
        int i7 = 1;
        i7 = i7++;//i7=1

        /**
         *  iconst_1
         *  istore 7
         *  iinc 7 by 1
         *  iload 7
         *  istore 7
         *  结合之前的逻辑，这里是先将局部变量表中元素进行+1，此时局部变量表中的值为2
         *  之后再取出局部变量表中的元素放入操作数栈，才是操作数栈中的值为2
         *  然后再将操作数栈的元素存入局部变量表中，存入局部变量表中的是2
         */

        int i8 = 1;
        i8 = ++i8;

        //第四类问题
        /**
         *  iconst_1
         *  istore 8
         *  iload 8
         *  iinc 8 by 1
         *  iinc 8 by 1
         *  iload 8
         *  iadd
         *  istore 9
         *  i9++ + ++i9因为是有加法操作的，所以i9++会先将局部变量表中i9取出到操作数栈中，该数字是1，然后对局部变量表中的i9进行+1操作，局部变量表中数字为2
         *  之后执行++9，这会先将局部变量表中i9进行+1操作，此时局部变量表中的i9为3，然后再取出到操作数栈中，此时存入操作数栈中的数据是3
         *  在这之后对放入操作数栈中两个数字进行加法操作，可得1+3=4，将操作数栈中的4存入局部变量表中
         * */
        int i9 = 1;
        int i10 = i9++ + ++i9;//从字节码文件解析的话得出结果应该是1+3得出的

        //以下代码会用到操作数栈深度为3
        System.out.println("i1:"+i1);
        System.out.println("i2:"+i2);
        System.out.println("i3:"+i3);
        System.out.println("i4:"+i4);
        System.out.println("i5:"+i5);
        System.out.println("i6:"+i6);
        System.out.println("i7:"+i7);
        System.out.println("i8:"+i8);
        System.out.println("i9:"+i9);
        System.out.println("i10:"+i10);
    }
    public static void main(String args[]){
        add();
    }
}

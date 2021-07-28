package chapter8;

/**
 * main方法的部分字节码文件：
 * Code:
 *       stack=3, locals=5, args_size=1
 *          0: sipush        500  将数据500放入操作数栈（操作数栈深度为1，存储500）
 *          3: istore_1    将操作数栈中的数据存入局部变量表中1的位置（操作数栈深度为0）（局部变量表中0位置存储着main方法参数args，如果没有static修饰，0位置应该存放着this）
 *          4: bipush        100  将数据100放入操作数栈（操作数栈深度为1，存储100）
 *          6: istore_2    将操作数栈中的数据存入局部变量表中2的位置（操作数栈深度为0）
 *          7: iload_1     取出局部变量表中1位置的数字放入操作数栈中（操作数栈深度为1，存储500）
 *          8: iload_2     取出局部变量表中2位置的数字放入操作数栈中（操作数栈深度为2，存储100，500）
 *          9: idiv        将操作数栈中两个数取出执行除法操作后将结果压入操作数栈（操作数栈深度为1，存储5）
 *         10: istore_3    将操作数栈中的数字存入局部变量表中的3位置（操作数栈栈深度为0）
 *         11: bipush        50 将数据50放入操作数栈中（操作数栈深度为1，存储50）
 *         13: istore        4       将操作数栈中的数据取出存入局部变量表中4位置（操作数栈深度为0）
 *         15: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;  获取类或接口的操作数值并将其压入操作数栈（操作数栈深度为1，存储着必要的操作数值）
 *         18: iload_3     取出局部变量表中位置3的数据放入操作数栈中（操作数栈深度为2，存储着5，必要的操作数）
 *         19: iload         4  取出局部变量表中位置为4的数据放入操作数栈中，（操作数栈深度为3，存储着50，5，必要的操作数）
 *         21: iadd         将操作数栈中的数据数据取出执行加法操作，并将所得结果压入栈中（操作数栈深度为2，存储着55，必要的操作数）
 *         22: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V   执行虚方法，打印输出55，
 *         25: return       main方法出栈
 * */
public class MethodAreaDemo {
    public static void main(String[] args) {
        int x = 500;
        int y = 100;
        int a = x/y;
        int b = 50;
        System.out.println(a+b);
    }
}

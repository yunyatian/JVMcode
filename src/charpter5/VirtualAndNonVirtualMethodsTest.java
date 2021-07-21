package charpter5;

/**
 * invokestatic指令和invokespecial指令调用的方法称为非虚方法
 * */
public class VirtualAndNonVirtualMethodsTest {
    static class Father{
        public Father(){
            System.out.println("父类构造方法");
        }

        public void showCommon(){
            System.out.println("父类Common");
        }

        public static void showStatic(){
            System.out.println("父类Static");
        }

        public final void showFinal(){
            System.out.println("父类Final");
        }
    }

    static class Son extends Father{
        public Son(){
            super();
        }
        public Son(String name){
            System.out.println(name);
        }

        @Override
        public void showCommon(){
            System.out.println("子类Common");
        }

        //父类的static方法不能进行覆写
        public static void showStatic(){
            System.out.println("子类Son");
        }

        private void showPrivate(){
            System.out.println("子类Private");
        }

        public void show(){
            //invokespecial：调用父类方法所以是非虚方法
            super.showCommon();
            //invokespecial
            super.showFinal();
            //invokespecial：调用私有方法所以是非虚方法
            showPrivate();
            //invokestatic：调用静态方法所以是非虚方法
            showStatic();
            //invokevirtual
            showCommon();
            //invokevirtual:由于是用final修饰，即使是invokevirtual修饰，仍然是非虚方法
            showFinal();
        }
    }

    public static void main(String[] args) {
        Son son = new Son();
        son.show();
    }
}

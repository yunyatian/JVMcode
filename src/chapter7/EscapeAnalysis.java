package chapter7;

/**
 * 逃逸分析
 *
 * 如何快速的判断是否发生了逃逸分析，就看new的对象是否有可能在方法外被调用
 * */
public class EscapeAnalysis {
    public EscapeAnalysis obj;

    /**
     * 方法返回escapeAnalysis对象，发生逃逸
     * */
    public EscapeAnalysis getInstance(){
        return obj == null?new EscapeAnalysis():obj;
    }

    /**
     * 为成员属性赋值，发生逃逸，因为在这里赋的值有可能会在其他地方被调用
     * */
    public void setObj(){
        this.obj = new EscapeAnalysis();
    }
    //如果当前的obj引用声明为static，仍然会发生逃逸

    /**
     * 对象的作用域仅在当前方法中有效，没有的发生逃逸
     * */
    public void useEscapeAnalysis(){
        EscapeAnalysis e = new EscapeAnalysis();
    }

    /**
     * 引用成员变量的值，发生逃逸。因为该成员变量可能会被其他引用进行修改
     * */
    public void useEscapeAnalysis2(){
        EscapeAnalysis e = getInstance();
    }

}

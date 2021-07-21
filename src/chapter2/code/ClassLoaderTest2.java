package chapter2.code;

import sun.security.ec.point.Point;

import java.net.URL;
import java.security.Provider;

public class ClassLoaderTest2 {
    public static void main(String[] args) {
        System.out.println("-------------启动类（引导类）加载器-----------------");
        //获取bootstrapClassLoader能够加载的所有Api路径
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL element:urls) {
            System.out.println(element.toExternalForm());
        }

        //以上jar包任取一个解压，获取其中某一类的加载器
        ClassLoader classLoader = Provider.class.getClassLoader();
        System.out.println(classLoader);//null
        System.out.println();

        System.out.println("-------------扩展类加载器-----------------");
        //获取扩展类加载器能够加载的所有API路径
        String extDirs = System.getProperty("java.ext.dirs");
        for (String path:extDirs.split(";")) {
            System.out.println(path);
        }

        //以上jar包任取一个解压，获取其中某一类的加载器
        ClassLoader classLoader1 = Point.class.getClassLoader();
        System.out.println(classLoader1);//sun.misc.Launcher$ExtClassLoader@3af49f1c
    }
}

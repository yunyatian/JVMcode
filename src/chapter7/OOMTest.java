package chapter7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OOMTest {
    static class Picture{
        private int[] arr;

        public Picture(int length) {
            this.arr = new int[length];
        }
    }

    public static void main(String[] args) {
        List<Picture> pictures = new ArrayList<>();
        while (true) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pictures.add(new Picture(new Random().nextInt(1024*1024)));
        }
    }
}

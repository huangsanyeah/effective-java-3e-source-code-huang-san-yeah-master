package effectivejava.chapter9.item59;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

// Random number generation is hard! - Page 215

/**
 * 这个示例目的是告诉我们要要学会使用java既有的API 同时过时的API要摒弃
 * util lang io里面的API要熟知
 */
public class RandomBug {
    // Common but deeply flawed!
    static Random rnd = new Random();

    static int random(int n) {
        return Math.abs(rnd.nextInt()) % n;
    }

    public static void main(String[] args) {
        //1.错误的方式
       /* //int MAX_VALUE = 2147483647
        int n = 2 * (Integer.MAX_VALUE / 3);
        int low = 0;
        for (int i = 0; i < 1000000; i++) {
            //n/2=715827882
            if (random(n) < n / 2) {
                low++;
                //它输出一个接近 666666 的数字。随机方法生成的数字中有三分之二落在其范围的下半部分
            }
        }
        System.out.println(low);*/


        //2.正确但是不推荐的方式，性能差，rnd.nextInt(n)
       /* //int MAX_VALUE = 2147483647
        int n = 2 * (Integer.MAX_VALUE / 3);
        int low = 0;
        for (int i = 0; i < 1000000; i++) {
            if (rnd.nextInt(n) < n / 2) {
                low++;
            }
        }
        System.out.println(low);*/


        //3.从 Java 7 开始，就不应该再使用 Random。在大多数情况下，选择的随机数生成器现在是 ThreadLocalRandom。
        // 它能产生更高质量的随机数，而且速度非常快。在我的机器上，它比 Random 快 3.6 倍。对于 fork 连接池和并行流，使用 SplittableRandom
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        int n = 2 * (Integer.MAX_VALUE / 3);
        int low = 0;
        for (int i = 0; i < 1000000; i++) {
            if (threadLocalRandom.nextInt(n) < n / 2) {
                low++;
            }
        }
        System.out.println(low);
    }
}

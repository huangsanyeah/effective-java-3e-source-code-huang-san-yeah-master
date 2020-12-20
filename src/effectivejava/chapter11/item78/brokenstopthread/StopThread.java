package effectivejava.chapter11.item78.brokenstopthread;

import java.util.concurrent.TimeUnit;

// Broken! - How long would you expect this program to run?  (Page 312)
public class StopThread {
    /**
     * 错误的示例，可能不会停
     * 你可能认为这个程序运行大约一秒钟，之后主线程将 stopRequested 设置为 true，从而导致后台线程的循环终止。
     * 然而，在我的机器上，程序永远不会终止：后台线程永远循环！
     * 问题在于在缺乏同步的情况下，无法保证后台线程何时（如果有的话）看到主线程所做的 stopRequested 值的更改。
     * 在缺乏同步的情况下，虚拟机可以很好地转换这段代码：
     * while (!stopRequested)
     * i++;
     * into this code:
     * if (!stopRequested)
     * while (true)
     * i++;
     */

//    private static boolean stopRequested;

    //加volatile确保内存可见性即可解决此问题
    private static volatile boolean stopRequested;

    public static void main(String[] args)
            throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested) {
                i++;
            }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}

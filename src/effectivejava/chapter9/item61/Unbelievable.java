package effectivejava.chapter9.item61;

// What does this program do? - Page 274

/**
 * 程序员忽略了基本类型和包装类型之间的区别，并承担了恶果。在前两个项目中，结果是彻底的失败；第三个例子还产生了严重的性能问题。
 */
public class Unbelievable {
    static Integer i;

    public static void main(String[] args) {
        //示例2：程序员忽略了基本类型和包装类型之间的区别，不可预期的报错 NPE
       /* if (i == 42) {
            System.out.println("Unbelievable");
        }*/


        //示例3：用包装类型 性能极差
        long begin=System.currentTimeMillis();
//        Long sum = 0L;
        long sum = 0;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        long end=System.currentTimeMillis();
        System.out.println(sum);
        // Long sum = 0L; 性能差 8174
        System.out.println(end-begin);
        //long sum = 0;性能好 1419
        System.out.println(end-begin);
    }
}

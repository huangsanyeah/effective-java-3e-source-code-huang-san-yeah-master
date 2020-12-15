package effectivejava.chapter9.item61;

import java.util.Comparator;


/**
 * 尽量用基本类型 不要使用包装类型
 * 什么时候应该使用包装类型呢？
 * 它们有几个合法的用途。
 * 第一个是作为集合中的元素、键和值。不能将基本类型放在集合中，因此必须使用包装类型。这是一般情况下的特例。
 * 在参数化类型和方法（Chapter 5）中，必须使用包装类型作为类型参数，因为 Java 不允许使用基本类型。例如，不能将变量声明为 ThreadLocal<int> 类型，因此必须使用 ThreadLocal<Integer>。
 * 最后，在进行反射方法调用时，必须使用包装类
 */
public class BrokenComparator {
    public static void main(String[] args) {

        /**
         * 示例1：比较器将错误地返回 1
         * 计算表达式 i < j 会使 i 和 j 引用的 Integer 实例自动拆箱；
         * 也就是说，它提取它们的基本类型值。计算的目的是检查得到的第一个 int 值是否小于第二个 int 值。
         * 但假设它不是。然后，下一个测试计算表达式 i==j，该表达式对两个对象引用执行标识比较。
         * 如果 i 和 j 引用表示相同 int 值的不同 Integer 实例，这个比较将返回 false，比较器将错误地返回 1，表明第一个整型值大于第二个整型值。
         * 将 == 操作符应用于包装类型几乎都是错误的
         * 修复办法：i == j 改为equals()
         */
//        Comparator<Integer> naturalOrder =
//                (i, j) -> (i < j) ? -1 : (i == j ? 0 : 1);

        // Fixed Comparator - Page 274
        Comparator<Integer> naturalOrder = (iBoxed, jBoxed) -> {
            int i = iBoxed, j = jBoxed;
            // Auto-unboxing
            //return Integer.compare(i, j);
            return i < j ? -1 : (i == j ? 0 : 1);
        };

        int result = naturalOrder.compare(new Integer(42), new Integer(42));
        System.out.println(result);
    }
}

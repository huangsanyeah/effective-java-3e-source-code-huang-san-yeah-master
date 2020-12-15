package effectivejava.chapter9.item63;

/**
 * @author huangweiyue
 * @description 源码并没有此章节，自己创建的
 * 不要使用字符串连接操作符合并多个字符串，除非性能无关紧要。
 * 否则使用 StringBuilder 的 append 方法。或者，使用字符数组，再或者一次只处理一个字符串，而不是组合它们。
 * @date Created in 2020-12-15
 */
public class StringConcat {
    //String concatenation 性能差
    /*public String statement() {
        String result = "";
        for (int i = 0; i < numItems(); i++) {
            result += lineForItem(i);
        }
        return result;
    }*/

    //性能好
   /* public String statement() {
        StringBuilder b = new StringBuilder(numItems() * LINE_WIDTH);
        for (int i = 0; i < numItems(); i++) {
            b.append(lineForItem(i));
        }
        return b.toString();
    }*/
}

package effectivejava.chapter9.item60;

/**
 * huangweiyue
 * float和double会造成精度缺失
 * 不声明的时候，默认小数都用double来表示，所以如果要用float的话，则应该在其后加上f
 */
public class FloatOrDoubleWrongExample {
    public static void main(String[] args) {
        System.out.println(1.03-0.42);
        System.out.println(1.00-9*0.10);
    }
}

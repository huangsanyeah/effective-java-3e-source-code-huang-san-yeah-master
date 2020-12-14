package effectivejava.chapter9.item60;

/**
 * huangweiyue
 * float和double会造成精度缺失
 */
public class FloatOrDoubleWrongExample {
    public static void main(String[] args) {
        System.out.println(1.03-0.42);
        System.out.println(1.00-9*0.10);
    }
}

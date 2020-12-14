package effectivejava.chapter9.item58;

import java.util.*;

// Same bug as NestIteration.java (but different symptom)!! - Page 213

/**
 * 预期输出36种，实际输出6种
 */
public class DiceRolls {
    public static void main(String[] args) {
        // Same bug, different symptom!
        Collection<Face> faces = EnumSet.allOf(Face.class);

        //错误的方式 这里程序并不会抛出异常，只是单纯的因为i.next()每次都会取下一个值，所以就出现了只会返回6个值的情况
        //如果外部集合(Suit)的大小是内部集合(Rank)大小的几倍（可能因为它们是相同的集合），循环将正常终止，但是它不会执行你想要的操作
        for (Iterator<Face> i = faces.iterator(); i.hasNext(); ) {
            //这个只会输出六个数值的原因是因为 共用一个faces.iterator(),内层循环不断next循环结束后,外层的i.hasNext没有值了
            for (Iterator<Face> j = faces.iterator(); j.hasNext(); ) {
                System.out.println(i.next() + " " + j.next());
            }
        }

        System.out.println("***************************");

        //正确但不优雅
        for (Iterator<Face> i = faces.iterator(); i.hasNext(); ) {
            Face face=i.next();
            for (Iterator<Face> j = faces.iterator(); j.hasNext(); ) {
                System.out.println(face + " " + j.next());
            }
        }

        System.out.println("***************************");
        //正确的方式
        for (Face f1 : faces) {
            for (Face f2 : faces) {
                System.out.println(f1 + " " + f2);
            }
        }
    }

    enum Face {ONE, TWO, THREE, FOUR, FIVE, SIX}
}

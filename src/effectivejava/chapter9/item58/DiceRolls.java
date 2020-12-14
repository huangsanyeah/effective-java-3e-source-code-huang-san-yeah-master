package effectivejava.chapter9.item58;

import java.util.*;

// Same bug as NestIteration.java (but different symptom)!! - Page 213

/**
 * 预期输出36种
 */
public class DiceRolls {
    public static void main(String[] args) {
        // Same bug, different symptom!
        Collection<Face> faces = EnumSet.allOf(Face.class);

        //错误的方式 这里程序并不会抛出异常，只是单纯的因为i.next()每次都会取下一个值，所以就出现了只会返回6个值的情况
        for (Iterator<Face> i = faces.iterator(); i.hasNext(); ) {
            for (Iterator<Face> j = faces.iterator(); j.hasNext(); ) {
                System.out.println(i.next() + " " + j.next());
            }
        }

        System.out.println("***************************");

        for (Iterator<Face> i = faces.iterator(); i.hasNext(); ) {
            Face face=i.next();
            for (Iterator<Face> j = faces.iterator(); j.hasNext(); ) {
                System.out.println(face + " " + j.next());
            }
        }

        System.out.println("***************************");

        for (Face f1 : faces) {
            for (Face f2 : faces) {
                System.out.println(f1 + " " + f2);
            }
        }
    }

    enum Face {ONE, TWO, THREE, FOUR, FIVE, SIX}
}

package org.eitorresmendoza.java8.lambda;

import org.eitorresmendoza.java8.lambda.models.Usuario;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class EjemploPredicate {
    public static void main(String[] args) {

        Predicate<Integer> test1 = num -> num > 10;
        boolean rt1 = test1.test(5);
        System.out.println(rt1);
        rt1 = test1.test(11);
        System.out.println(rt1);

        Predicate<String> test2 = role -> role.equals("ADMIN");
        System.out.println(test2.test("USER"));
        System.out.println(test2.test("ADMIN"));

        BiPredicate<String, String> test3 = String::equals; // (a, b) -> a.equals(b);
        System.out.println(test3.test("enrique", "torres"));
        System.out.println(test3.test("enrique", "enrique"));

        BiPredicate<Integer, Integer> test4 = (i, j) -> i < j;
        boolean rt4 = test4.test(10, 5);
        System.out.println(rt4);
        rt4 = test4.test(5, 10);
        System.out.println(rt4);

        Usuario a = new Usuario();
        Usuario b = new Usuario();
        a.setNombre("maria");
        b.setNombre("cata");
        BiPredicate<Usuario, Usuario> test5 = (ua, ub) -> ua.getNombre().equals(ub.getNombre());
        System.out.println(test5.test(a, b));
        b.setNombre("maria");
        System.out.println(test5.test(a, b));
    }
}

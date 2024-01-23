package org.eitorresmendoza.ejemplos.set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class EjemploTreeSet {
    public static void main(String[] args) {
        Set<String> treeSetString = new TreeSet<>((a, b) -> b.compareTo(a));
        treeSetString.add("uno");
        treeSetString.add("dos");
        treeSetString.add("tres");
        treeSetString.add("tres");
        treeSetString.add("cuatro");
        treeSetString.add("cinco");

        System.out.println("treeSetString = " + treeSetString);

        Set<Integer> treeSetInteger = new TreeSet<>(Comparator.reverseOrder());
        treeSetInteger.add(1);
        treeSetInteger.add(2);
        treeSetInteger.add(3);
        treeSetInteger.add(4);
        treeSetInteger.add(5);
        treeSetInteger.add(10);

        System.out.println("treeSetInteger = " + treeSetInteger);

    }
}

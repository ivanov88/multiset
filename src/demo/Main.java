package demo;

import datastructure.HashMultiSetImpl;
import datastructure.MultiSet;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        MultiSet<Integer> multiSet = new HashMultiSetImpl<>();
        multiSet.add(1);
        multiSet.add(1);
        multiSet.add(1);
        multiSet.add(2);
        multiSet.add(2);
        multiSet.add(3);

        Iterator<Integer> iterator = multiSet.iterator();
        while (iterator.hasNext()) {
            int next = iterator.next();
            System.out.println(next);
        }
    }
}

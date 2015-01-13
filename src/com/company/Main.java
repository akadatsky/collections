package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    private static final int COUNT = 50000;

    public static void main(String[] args) {
        System.out.println("HashSet");
        Set<Person> hashSet = new HashSet<Person>(16);
        testCollection(hashSet);
        System.out.println("======================================================");
        System.out.println("TreeSet");
        Set<Person> treeSet = new TreeSet<Person>();
        testCollection(treeSet);
        System.out.println("======================================================");
        System.out.println("ArrayList");
        List<Person> arrayList = new ArrayList<Person>();
        testCollection(arrayList);
    }

    private static void testCollection(Collection<Person> persons) {
        testAddTime(persons);
        testCheckElementTime(persons);
    }

    private static void testAddTime(Collection<Person> persons) {
        long t = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            Person tmp = PersonFactory.createPerson();
            persons.add(tmp);
        }
        System.out.println("Size:" + persons.size());
        t = System.currentTimeMillis() - t;
        System.out.println("Add time:" + t / 1000.0);
    }

    private static void testCheckElementTime(Collection<Person> persons) {
        long t = System.currentTimeMillis();
        int existPersons = 0;
        for (int i = 0; i < COUNT; i++) {
            Person tmp = PersonFactory.createPerson();
            if (persons.contains(tmp)) {
                existPersons++;
            }

        }
        System.out.println("Exist persons: " + existPersons);
        t = System.currentTimeMillis() - t;
        System.out.println("Check time:" + t / 1000.0);
    }
}

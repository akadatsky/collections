package com.company;

import java.util.Random;

public class PersonFactory {

    private static final String[] FIRST_NAMES = {"Иванов", "Петров", "Сидоров", "Смирнов", "Волков"};
    private static final String[] LAST_NAMES = {"Иван", "Петр", "Сидор", "Олег", "Владимир"};

    private static Random rand = new Random();

    public static Person createPerson() {
        int height = rand.nextInt(200);
        int weight = rand.nextInt(120);
        String fullName = FIRST_NAMES[rand.nextInt(FIRST_NAMES.length)] + " " + LAST_NAMES[rand.nextInt(LAST_NAMES.length)];
        return new Person(height, weight, fullName);
    }

}

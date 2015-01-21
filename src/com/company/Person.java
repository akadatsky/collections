package com.company;

public class Person implements Comparable<Person> {

    private int height;
    private int weight;
    private String fullName;

    public Person(int height, int weight, String fullName) {
        this.height = height;
        this.weight = weight;
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (height != person.height) return false;
        if (weight != person.weight) return false;
        if (!fullName.equals(person.fullName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = height;
        result = 31 * result + weight;
        result = 31 * result + fullName.hashCode();
        return result;
    }

    @Override
    public int compareTo(Person o) {
        int result = fullName.compareTo(o.fullName);
        if (result == 0) {
            result = Integer.compare(height, o.height);
        }
        if (result == 0) {
            result = Integer.compare(weight, o.weight);
        }
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "height=" + height +
                ", weight=" + weight +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}

package com.packt.learnjava.ch02_oop;
import java.util.Objects;

public class RecordPattern {
    public static void main(String[] args) {
        Object obj = new Person(35, "Bill");
        printObjectPropertiesBeforeJava21(obj);

        obj = new PersonR(23, "Jill");
        printObjectPropertiesBeforeJava21(obj);
        printObjectPropertiesAfterJava21_b(obj);

        printObjectPropertiesAfterJava21_a(obj);
        printObjectPropertiesAfterJava21_c(obj);

        Mammal m1 = new Human(38, "Bob", "diver");
        Mammal m2 = new Human(32, "John", "biologist");
        Mammal m3 = new Whale(53, "Iceberg");
        Mammal m4 = new Whale(60, "Big Ocean");
        printFriendsUsingInstanceofBeforeJava21(new Friends(m1, m2));
        printFriendsUsingInstanceofBeforeJava21(new Friends(m1, m3));
        printFriendsUsingInstanceofBeforeJava21(new Friends(m3, m1));
        printFriendsUsingInstanceofBeforeJava21(new Friends(m3, m4));

        printFriendsUsingRecordPatternAfterJava21(new Friends(m1, m2));
        printFriendsUsingRecordPatternAfterJava21(new Friends(m1, m3));
        printFriendsUsingRecordPatternAfterJava21(new Friends(m3, m1));
        printFriendsUsingRecordPatternAfterJava21(new Friends(m3, m4));
    }

    private static void printObjectPropertiesBeforeJava21(Object obj){
        if (obj instanceof Person p) {
            System.out.printf("This is Person obj: %s, age %s\n", p.name(), p.age());
        } else if (obj instanceof PersonR p) {
            System.out.printf("This is PersonR obj: %s, age %s\n", p.name(), p.age());
        } else {
            System.out.printf("Unexpected object: %s\n", obj);
        }
    }

    private static void printObjectPropertiesAfterJava21_a(Object obj){
        switch (obj) {
            case Person p  -> System.out.printf("This is Person obj: %s, age %s\n", p.name(), p.age());
            case PersonR p -> System.out.printf("This is PersonR obj: %s, age %s\n", p.name(), p.age());
            default         -> System.out.printf("Unexpected object: %s\n", obj);
        }
    }

    private static void printObjectPropertiesAfterJava21_b(Object obj){
        if (obj instanceof Person p) {
            System.out.printf("This is Person obj: %s, age %s\n", p.name(), p.age());
        } else if (obj instanceof PersonR(int age, String name)) {
            System.out.printf("This is PersonR obj: %s, age %s\n", name, age);
        } else {
            System.out.printf("Unexpected object: %s\n", obj);
        }
    }

    private static void printObjectPropertiesAfterJava21_c(Object obj){
        switch (obj) {
            case Person p  -> System.out.printf("This is Person obj: %s, age %s\n", p.name(), p.age());
            case PersonR(int age, String name) -> System.out.printf("This is PersonR obj: %s, age %s\n", name, age);
            default         -> System.out.printf("Unexpected object: %s\n", obj);
        }
    }

    private record PersonR(int age, String name){}

    private static final class Person{
        private int age;
        private String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int age() { return age; }
        public String name() { return name; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age && Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(age, name);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public sealed interface Mammal permits Whale, Human {}

    public record Whale(int age, String name) implements Mammal {}

    public record Human(int age, String name, String profession) implements Mammal {}

    public record Friends<M extends Mammal>(M f1, M f2) {}

    static void printFriendsUsingInstanceofBeforeJava21(Object obj){
        switch (obj) {
            case Friends f when f.f1() instanceof Human f1
                    && f.f2() instanceof Human f2 ->
                    System.out.printf("Friends: human %s, age %s, %s and human %s, age %s, %s\n",
                            f1.name(), f1.age(), f1.profession(),
                            f2.name(), f2.age(), f2.profession());
            case Friends f when (f.f1() instanceof Human f1
                    && f.f2() instanceof Whale f2) ->
                    System.out.printf("Friends: human %s, age %s, %s and whale %s, age %s\n",
                            f1.name(), f1.age(), f1.profession(),
                            f2.name(), f2.age());
            case Friends f when (f.f1() instanceof Whale f1
                    && f.f2() instanceof Human f2) ->
                    System.out.printf("Friends: human %s, age %s, %s and whale %s, age %s\n",
                            f2.name(), f2.age(), f2.profession(),
                            f1.name(), f1.age());
            default -> System.out.printf("Unexpected: %s\n", obj);
        }
    }

    static void printFriendsUsingRecordPatternAfterJava21(Object obj){
        switch (obj) {
            case Friends(Human f1, Human f2) ->
                    System.out.printf("Friends: human %s, age %s, %s and human %s, age %s, %s\n",
                            f1.name(), f1.age(), f1.profession(),
                            f2.name(), f2.age(), f2.profession());
            case Friends(Human f1, Whale f2) ->
                    System.out.printf("Friends: human %s, age %s, %s and whale %s, age %s\n",
                            f1.name(), f1.age(), f1.profession(),
                            f2.name(), f2.age());
            case Friends(Whale f1, Human f2) ->
                    System.out.printf("Friends: human %s, age %s, %s and whale %s, age %s\n",
                            f2.name(), f2.age(), f2.profession(),
                            f1.name(), f1.age());
            default -> System.out.printf("Unexpected: %s\n", obj);
        }
    }
}

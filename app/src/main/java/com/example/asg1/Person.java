package com.example.asg1;

public class Person {
    private String Name;
    private int Age;
    private String Address;

    public Person(String name, int age, String address) {
        Name = name;
        Age = age;
        Address = address;
    }

    public String getName() {
        return Name;
    }

    public int getAge() {
        return Age;
    }

    public String getAddress() {
        return Address;
    }

    @Override
    public String toString() {
        return "Person {" +
                "Name='" + Name  +
                ", Age=" + Age +
                ", Address='" + Address +
                " }";
    }
}

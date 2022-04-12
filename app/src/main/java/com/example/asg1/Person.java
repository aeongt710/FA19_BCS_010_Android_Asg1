package com.example.asg1;

public class Person {
    private String Name;
    private int Age;
    private String Address;
    private String Email;

    public Person(String name, int age, String address,String email) {
        Name = name;
        Age = age;
        Address = address;
        Email = email;
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
        return "Person{" +
                "Name='" + Name +
                ", Age=" + Age +
                ", Address='" + Address +
                ", email='" + Email  +
                " }";
    }
}

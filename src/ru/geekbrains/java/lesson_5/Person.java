package ru.geekbrains.java.lesson_5;

import sun.util.resources.cldr.sah.CalendarData_sah_RU;

public class Person {
    private String name;
    private String position;
    private String email;
    private String tel;
    private int salary;
    private int age;

    public Person(String name, String position, String email, String tel, int salary, int age) {
        this.name=name;
        this.position=position;
        this.email=email;
        this.tel=tel;
        this.salary=salary;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void aboutPerson() {
        System.out.println("Name: " + this.name +"\nPosition: " + this.position + "\nE-mail: " + this.email + "\nTelephone number: "
                            + this.tel + "\nSalary: " + this.salary + "\nAge: " + this.age);
    }
}

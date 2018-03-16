package ru.geekbrains.java.lesson_6;

public class Cat extends Animal {
    protected Cat(int routeLength, int jumpHigh) {
        super(routeLength, jumpHigh);
    }
    protected void run() {
        System.out.println("The cat is running");
    }
    protected void jump() {
        System.out.println("The cat is jumping");
    }
    protected void swim() {
        System.out.println("The cat drowned! It's not able to swim!");
    }

}

package ru.geekbrains.java.lesson_6;

public class Dog extends Animal {

    protected Dog(int routeLength, int jumpHigh, int lineLength) {
        super(routeLength, jumpHigh, lineLength);
    }

    protected void run() {
        System.out.println("The dog is running");
    }

    protected void jump() {
        System.out.println("The dog is jumping");
    }

    protected void swim() {
        System.out.println("The dog is swimming");
    }
}

package ru.geekbrains.java.lesson_7;

public class Plate {
    private int amountOfFood=0;

    public int getAmountOfFood() {
        return amountOfFood;
    }

    public void addFood(int food) {
        amountOfFood+=food;
        System.out.printf("Now, there is more food in plate: %d\n", amountOfFood);
    }

    public void decreaseFood(int food) {
        amountOfFood-=food;
        System.out.printf("Now, there is less food in plate: %d\n", amountOfFood);
    }
}

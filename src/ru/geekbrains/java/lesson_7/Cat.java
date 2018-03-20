package ru.geekbrains.java.lesson_7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety=false;

    public Cat(String name, int appetite) {
        this.name=name;
        this.appetite=appetite;
    }
    public void getFood(Plate plate) {
        if (satiety) {
            System.out.printf("The cat %s is age, cat does not want to eat, thanks!", name);
        }
        else if (plate.getAmountOfFood()<appetite) {
            appetite-=plate.getAmountOfFood();
            plate.decreaseFood(plate.getAmountOfFood());
            System.out.printf("The plate is empty. The cat %s is still hungry. Please, give the cat some more food, " +
                    "like a: %d\n", name, appetite);
        }
        else {
            plate.decreaseFood(appetite);
            appetite=0;
            satiety=true;
            System.out.printf("The cat %s is well-food, thanks!\n", name);
        }
    }

    public void info() {
        System.out.printf("The appetite of cat %s is: %d\n", name, appetite);
        if (!satiety) {
            System.out.println("The cat is still hungry");
        }
        else {
            System.out.println("The cat is age");
        }
    }
}

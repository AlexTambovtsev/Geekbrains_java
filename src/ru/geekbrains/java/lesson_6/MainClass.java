package ru.geekbrains.java.lesson_6;

public class MainClass {
    private static void animalRun(Animal animal, int routeLength) {
        if (routeLength<0 || routeLength>animal.getRouteLength()) {
            System.out.println("The route length is too high for this animal, or negative!");
        }
        else {
            animal.run();
        }
    }

    private static void animalSwim(Animal animal, int lineLength) {
        if (animal instanceof Cat) {
            animal.swim();
        }
        else if (lineLength < 0 || lineLength > animal.getLineLength()) {
                System.out.println("The line length is too high for this animal, or negative!");
            }
        else {
            animal.swim();
        }
    }

    private static void animalJump(Animal animal, int jumpHigh) {
        if (jumpHigh<0 || jumpHigh>animal.getJumpHigh()) {
            System.out.println("The high is too big for this animal, or negative!");
        }
        else {
            animal.jump();
        }
    }

    public static void main(String[] args) {
        Animal barsik=new Cat(200, 200);
        Animal sharik=new Dog(400, 1, 100);
        System.out.println(sharik.getRouteLength());
        System.out.println(sharik.getJumpHigh());
        System.out.println(sharik.getLineLength());
        animalRun(barsik, 50);
        animalSwim(barsik, 100);
        animalSwim(sharik, 50);
        animalJump(sharik, 4);
    }
}

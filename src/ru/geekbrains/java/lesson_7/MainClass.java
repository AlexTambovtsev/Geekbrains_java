package ru.geekbrains.java.lesson_7;

public class MainClass {
    public static void main(String[] args) {
        Plate plate_1=new Plate();
        Cat[] arrOfCats={new Cat("Barsik", 36), new Cat("Boris", 100),
                new Cat("Kolobok", 117), new Cat("Murka", 15),
                new Cat("Tigr", 255)};
        plate_1.addFood(700);
        for (int i = 0; i < arrOfCats.length; i++) {
            arrOfCats[i].getFood(plate_1);
        }
        arrOfCats[3].info();
        arrOfCats[3].getFood(plate_1);
    }
}

package ru.geekbrains.java.lesson_5;

public class MainClass {
    public static void main(String[] args) {
        Person[] tabel=new Person[5];
        tabel[0] = new Person("Ivanov Ivan Ivanovich", "Director", "ivanov-sobaka",
                "+32549990909", 9999, 46);
        tabel[1] = new Person("Petrov Petr Petrovich", "Zam po kotam", "petrov-kot",
                "+32549990910", 9998, 41);
        tabel[2] = new Person("Sidorova Sidora Sidorovna", "Master na vse ruki", "sidorova-rab",
                "+32549990911", 89, 30);
        tabel[3] = new Person("Gavkina Ludmila Reksovna", "Zam po sobakam", "gavkina-sobaka",
                "+32549990912", 3998, 33);
        tabel[4] = new Person("Murzilkin Oleg Vasil'ich", "Martovskiy voi", "murzilkin-kot",
                "+32549990914", -25, 19);

        for (int i = 0; i < tabel.length; i++) {
            if (tabel[i].getAge()>40) {
                tabel[i].aboutPerson();
            }
        }
    }
}

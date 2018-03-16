package ru.geekbrains.java.lesson_3;

import java.util.Random;
import java.util.Scanner;

public class MainClass {
    public static Scanner console = new Scanner(System.in);
    public static void guessNumber() {
        int number=-1;
        Random randNum=new Random();
        int step=1+randNum.nextInt(8);
        System.out.println(step);
        int i=0;
        while (i<=2) {
            if (i==0) System.out.println("Введите число от 1 до 9: ");
            while(true) {
                if (console.hasNextInt()) {
                    number=console.nextInt();
                    if (number>0 && number<9) break;
                }
                else console.nextLine();
            }
            if (step==number) {
                System.out.println("Вы победили!!! Хотите сыграть ещё раз? \n0-нет, 1-да");
                number=console.nextInt();
                if (number==1) {
                    i=-1;
                    step=randNum.nextInt(9);
                }
                else break;
            }
            if (number<step && i!=-1) System.out.println("Вы ввели число меньше загаданного!!! Осталось "+ (2-i) + " попыток!");
            else if (number>step && i!=-1) System.out.println("Вы ввели число больше загаданного!!! Осталось "+(2-i)+ " попыток!!!");
            if (i==2) {
                System.out.println("Вы проиграли!!! Хотите попробовать ещё??? \n0-нет, 1-да");
                number=console.nextInt();
                if (number==1) i=-1;
            }
            i++;
        }
    }
    public static void main(String[] args) {
        guessNumber();
        guessWord();
    }

    public static void guessWord() {
        String[] arrOfWords={"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random wordIndex = new Random();
        int index=wordIndex.nextInt(25);
        System.out.println(arrOfWords[index]);
        System.out.println("Введите название плода:");
        while (true) {
            String result="";
            String word=console.next();
            if (word.equals(arrOfWords[index])) {
                System.out.println("Угадал!");
                break;
            }
            else {
                for (int i = 0; i < Math.min(word.length(), arrOfWords[index].length()); i++) {
                    if (word.charAt(i) == arrOfWords[index].charAt(i)) result += word.charAt(i);
                    else result += "#";
                }
                if (result.equals(word)) {
                    System.out.println("Угадал!!!");
                    break;
                }
                else {
                    int endOfWord=result.length();
                    for (int i = 0; i < 15 - endOfWord; i++) result += "#";
                    System.out.println("Пока не все буквы угаданы! \n" + result);
                }
            }
        }
    }
}

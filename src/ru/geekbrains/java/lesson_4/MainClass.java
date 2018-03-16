package ru.geekbrains.java.lesson_4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MainClass {
    public static Scanner console=new Scanner(System.in);
    public static final char first='X';
    public static final char second='O';
    public static final char empty='-';
    public static char[][] map;
    public static int razm=3;
    public static int x;
    public static int y;
    public static int oldX;
    public static int oldY;
    public static int initMap() {
        int numberOfDots=-1;
        map = new char[razm][razm];
        for (int i = 1; i < razm+1; i++) {
            System.out.print("  ");
            System.out.print(i);
        }
        System.out.println();
        for (int i = 0; i < razm; i++) {
            System.out.print(i+1 + " ");
            for (int j = 0; j < razm; j++) {
                map[i][j]=empty;
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }
        if (razm==3) numberOfDots=3;
        else if (razm>4 && razm<8) numberOfDots=4;
        else if (razm>=8) numberOfDots=5;
        System.out.println("\nКоличество необходимых для победы фишек подряд = " + numberOfDots);
        return numberOfDots;
    }

    public static void printMap() {
        for (int i = 0; i < razm; i++) {
            System.out.print(i+1 + " ");
            for (int j = 0; j < razm; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static boolean checkWin(int numberOfDots, int x, int y, char who) {
        int result=1;
        boolean theEnd=false;
        while(!theEnd) {
            int i=1;
            while (x - i >= 0 && map[x - i][y] == who) {
                result++;
                i++;
            }
            i=1;
            while (x + i <map.length && map[x + i][y] == who) {
                result++;
                i++;
            }
            if (result>=numberOfDots) {
                break;
            }
            else {
                result=1;
            }
            i=1;

            while (y - i >= 0 && map[x][y-i] == who) {
                result++;
                i++;
            }
            i=1;
            while (y + i <map.length && map[x][y+i] == who) {
                result++;
                i++;
            }
            if (result>=numberOfDots) {
                break;
            }
            else {
                result=1;
            }
            i=1;

            while (x - i >= 0 && y - i >= 0 && map[x - i][y - i] == who) {
                result++;
                i++;
            }
            i=1;
            while (x + i <map.length && y + i < map.length && map[x + i][y + i] == who) {
                result++;
                i++;
            }
            if (result>=numberOfDots) {
                break;
            }
            else {
                result=1;
            }
            i=1;

            while (x - i >= 0 && y + i < map.length && map[x - i][y + i] == who) {
                result++;
                i++;
            }
            i=1;
            while (x + i <map.length && y - i >=0 && map[x + i][y - i] == who) {
                result++;
                i++;
            }
            if (result>=numberOfDots) {
                break;
            }
            else {
                result=1;
            }
            theEnd=true;
        }
        return !theEnd;
    }

    public static boolean isEmpty(int x, int y) {
        if (map[x][y]!=empty) {
            return false;
        }
        return true;
    }

    public static boolean humanTurn(int numberOfDots) {
        boolean isCorrect=false;
        System.out.println("Введите координаты Вашего хода:");
        while(!isCorrect) {
            while (true) {
                if (!console.hasNextInt()) {
                    console.next();
                } else {
                    y = console.nextInt();
                    if (y <= 0 || y > razm) {
                        console.next();
                    } else {
                        break;
                    }
                }
            }
            while (true) {
                if (!console.hasNextInt()) {
                    console.next();
                } else {
                    x = console.nextInt();
                    if (x <= 0 || x > razm) {
                        console.next();
                    } else {
                        break;
                    }
                }
            }
            isCorrect=isEmpty(x-1, y-1);
            if (isCorrect==false) {
                System.out.println("Ячейка не пуста!!!");
            }
        }
        map[x-1][y-1]=first;
        return checkWin(numberOfDots, x-1, y-1, first);
    }
    public static boolean compTurn(int numberOfDots) {
        int comp_x=0;
        int comp_y=0;
        if (x-1>oldX && y-1>oldY && x<map.length && y<map.length && isEmpty(x, y)) {
            map[x][y]=second;
            comp_x=x;
            comp_y=y;
        }
        else if (x-1>oldX && y-1>oldY && (x==map.length || y==map.length || !isEmpty(x, y))) {
            for (int i = 2; i < numberOfDots+1; i++) {
                if (x-i>=0 && y-i>=0 && isEmpty(x-i, y-i)) {
                    map[x-i][y-i]=second;
                    comp_x=x-i;
                    comp_y=y-i;
                    break;
                }
            }
        }
        else if (x-1>oldX && y-1==oldY && x<map.length && isEmpty(x,y-1)) {
            map[x][y-1]=second;
            comp_x=x;
            comp_y=y-1;
        }
        else if (x-1>oldX && y-1==oldY && (x==map.length || !isEmpty(x,y-1))) {
            for (int i = 2; i < numberOfDots+1; i++) {
                if (x-i>=0 && isEmpty(x-i, y-1)) {
                    map[x-i][y-1]=second;
                    comp_x=x-i;
                    comp_y=y-1;
                    break;
                }
            }
        }
        else if (x-1>oldX && y-1<oldY && x<map.length && y-2>=0 && isEmpty(x,y-2)) {
            map[x][y-2]=second;
            comp_x=x;
            comp_y=y-2;
        }
        else if (x-1>oldX && y-1<oldY && (x==map.length || y-2<0 || !isEmpty(x,y-2))) {
            for (int i = 2; i < numberOfDots+1; i++) {
                if (x-i>=0 && y+i-2<map.length && isEmpty(x-i, y+i-2)) {
                    map[x-i][y+i-2]=second;
                    comp_x=x-i;
                    comp_y=y+i-2;
                    break;
                }
            }
        }
        else if (x-1==oldX && y-1<oldY && y-2>=0 && isEmpty(x-1,y)) {
            map[x-1][y]=second;
            comp_x=x-1;
            comp_y=y;
        }
        else if (x-1==oldX && y-1<oldY && (y-2<0 || !isEmpty(x-1,y))) {
            for (int i = 0; i < numberOfDots-1; i++) {
                if (y+i<map.length && isEmpty(x-1, y+i)) {
                    map[x-1][y+i]=second;
                    comp_x=x-1;
                    comp_y=y+i;
                    break;
                }
            }
        }
        else if (x-1==oldX && y-1>oldY && y<map.length && isEmpty(x-1,y)) {
            map[x-1][y]=second;
            comp_x=x-1;
            comp_y=y;
        }
        else if (x-1==oldX && y-1>oldY && (y==map.length || !isEmpty(x-1,y))) {
            for (int i = 2; i < numberOfDots+1; i++) {
                if (y-i>=0 && isEmpty(x-1, y-i)) {
                    map[x-1][y-i]=second;
                    comp_x=x-1;
                    comp_y=y-i;
                    break;
                }
            }
        }
        else if (x-1<oldX && y-1==oldY && x-2>=0 && isEmpty(x-2,y-1)) {
            map[x-2][y-1]=second;
            comp_x=x-2;
            comp_y=y-1;
        }
        else if (x-1<oldX && y-1==oldY && (x-2<0 || !isEmpty(x-2,y-1))) {
            for (int i = 0; i < numberOfDots-1; i++) {
                if (x+i<map.length && isEmpty(x+i, y-1)) {
                    map[x+i][y-1]=second;
                    comp_x=x+i;
                    comp_y=y-1;
                    break;
                }
            }
        }
        else if (x-1<oldX && y-1<oldY && x-2>=0 && y-2>=0 && isEmpty(x-2,y-2)) {
            map[x-2][y-2]=second;
            comp_x=x-2;
            comp_y=y-2;
        }
        else if (x-1<oldX && y-1<oldY && (x-2<0 || y-2<0 || !isEmpty(x-2,y-2))) {
            for (int i = 0; i < numberOfDots-1; i++) {
                if (x+i<map.length && y+i<map.length && isEmpty(x+i, y+i)) {
                    map[x+i][y+i]=second;
                    comp_x=x+i;
                    comp_y=y+i;
                    break;
                }
            }
        }
        else if (x-1<oldX && y-1>oldY && x-2>=0 && y<map.length && isEmpty(x-2,y)) {
            map[x-2][y]=second;
            comp_x=x-2;
            comp_y=y;
        }
        else if (x-1<oldX && y-1>oldY && (x-2<0 || y==map.length || !isEmpty(x-2,y))) {
            for (int i = 0; i < numberOfDots-1; i++) {
                if (x+i<map.length && y-i-2>=0 && isEmpty(x+i, y-2-i)) {
                    map[x+i][y-2-i]=second;
                    comp_x=x+i;
                    comp_y=y-2-i;
                    break;
                }
            }
        }
        else {
                Random rand = new Random();
                comp_x = rand.nextInt(map.length);
                comp_y = rand.nextInt(map.length);
                while (map[comp_x][comp_y] != empty) {
                    comp_x = rand.nextInt(map.length);
                    comp_y = rand.nextInt(map.length);
                }
                map[comp_x][comp_y] = second;
                }
        oldX=x-1;
        oldY=y-1;
        return checkWin(numberOfDots, comp_x, comp_y, second);
    }
    public static String game(int numberOfDots) {
        boolean isNotEmty=false;
        if (razm < 3) return ("Поле слишком мало!!!");
        else {
            while(!isNotEmty) {
                System.out.println("Ход игрока:");
                if (humanTurn(numberOfDots) == true) {
                    printMap();
                    return ("Вы победили!!!");
                }
                else {
                    if (compTurn(numberOfDots) == true) {
                        printMap();
                        return ("Вы проиграли!!!");
                    }
                }
                printMap();
                isNotEmty=noEmpty();
            }
            return ("Ничья!!! Некуда ходить!!!");
        }
    }

    public static boolean noEmpty() {
        int i=-1;
        int j;
        do {
            i++;
            j=0;
            while (j < map.length-1) {
                if (map[i][j] == empty) {
                    break;
                }
                j++;
            }
        }
        while (i< map.length-1 && map[i][j]!=empty);
        if (i==map.length-1 && j==map.length-1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int numberOfDots=initMap();
        System.out.println(game(numberOfDots));
    }
}

package ru.geekbrains.java.lesson_1;

// Что за модуль подгрузился?
import com.sun.org.apache.xpath.internal.SourceTree;

public class MainClass {
    public static void main(String[] args) {
        //2
        byte byteVar=127;
        short shortVar=128;
        int intVar=-789;
        long longVar=1001;
        float floatVar=5.3f;
        double doubleVar=-87.48923468;
        boolean boolVar=false;
        char charVar_1= 116; //Код переменной
        char charVar_2= 'q';

        String strVar = "Very long string";

        System.out.println(formula(12.2, 34.2, 54.987, 33));
        System.out.println(inOrOut(5, 10));
        plusOrMinus(-90);
        System.out.println(negative(-1));
        hiHuman("Alexander");
        leapYear(1100);
    }
    //3
    public static double formula(double a, double b, double c, double d) {
        return (a*(b+(c/d)));
    }
    //4
    //Поясниния по типу входных чисел нет, сначала делал с double типом входных чисел, сравнивать их напрямую нельзя! 0_0
    //Расскажите, плз, как делать с типом double, (float). Можно ли так:

    /*
    public static boolean inOrOut(double firstNum, double secondNum) {
        double sum =firstNum+secondNum;
        if ((int)sum<10 || (int)sum>20 || ((int)sum==20 && sum-(int)sum>0)) {
            return false;
        }
        return true;
    }
    */
    public static boolean inOrOut(int firstNum, int secondNum) {
        return (firstNum+secondNum>=10 && firstNum+secondNum<=20);
    }
    //5
    public static void plusOrMinus(int number) {
        String result;
        if (number<0) {
            result="The number is negative";
        }
        else {
            result="The number is positive, or zero";
        }
        System.out.println(result);
    }
    //6
    public static boolean negative(int number) {
        return (number<0);
    }
    //7
    public static void hiHuman(String name) {
        System.out.println("Hi, mister (missis? miss? or, third?), "+name);
    }
    //8
    public static void leapYear(int year) {
        String result;
        if ((year)%400==0 || ((year)%4==0) && !((year)%100==0)) {
            result="Yes, this year is a leap year.";
        }
        else {
            result = "No, this year is not a leap.";
        }
        System.out.println(result);
    }
}

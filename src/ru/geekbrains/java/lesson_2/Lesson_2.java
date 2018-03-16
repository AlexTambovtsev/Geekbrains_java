package ru.geekbrains.java.lesson_2;

import java.util.Arrays;

import static java.lang.Math.abs;

public class Lesson_2 {

    public static boolean arrLengthNoZeroOrOne(int[] arr) {
        return arr.length<=1;
    }
    //6
    public static boolean arrSum(int[] arr) {
        if (arrLengthNoZeroOrOne(arr)) {
            return false;
        }
        int r_sum=arr[0];
        int l_sum=arr[arr.length-1];
        int i=0;
        int j=arr.length-1;
        while (i+1!=j) {
            if (((r_sum>=l_sum) && (arr[j-1]>=0)) || (r_sum<l_sum) && (arr[j-1]<0)) {
                j--;
                l_sum+=arr[j];
            }
            else {
                i++;
                r_sum+=arr[i];
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("r_sum = " + r_sum +"\nl_sum = " + l_sum);
        return r_sum == l_sum;
    }

    //7 var_1
    public static void arrShift_1(int[] arr, int n) {
        if (arrLengthNoZeroOrOne(arr)) {
            System.out.println("The Array arr_7 is too small!!!");
        }
        else if (abs(n)%arr.length==0){
            System.out.println("All elements arr_7 are stay in their places!");
        }
        else {
            int shift;
            if (abs(n)>arr.length) {
                int i=n/arr.length;
                shift=n-i*arr.length;
            }
            else {
                shift=n;
            }
            if (shift<0) {
                shift+=arr.length;
            }
            for (int j=1; j<=shift; j++) {
                int b1=arr[arr.length-1];
                for (int i=arr.length-1; i>0; i--) {
                    arr[i]=arr[i-1];
                }
                arr[0]=b1;
            }
        }
    }

    //7 var_2
    public static void arrShift_2(int[] arr, int n) {
        if (arrLengthNoZeroOrOne(arr)) {
            System.out.println("The Array arr_7 is too small!!!");
        }
        else if (abs(n)%arr.length==0){
            System.out.println("All elements arr_7 are stay in their places!");
        }
        else {
            int shift;
            if (abs(n)>arr.length) {
                int i=n/arr.length;
                shift=n-i*arr.length;
            }
            else {
                shift=n;
            }
            if (shift<0) {
                shift+=arr.length;
            }
            int index=arr.length/shift;
            if (arr.length%shift==0) {
                for (int j = 1; j <= index; j++) {
                    for (int i = 0; (i < shift && j * shift + i < arr.length); i++) {
                        int b = arr[shift * j + i];
                        arr[shift * j + i] = arr[i];
                        arr[i] = b;
//                    lastStep=i+1;
                    }
                }
            }
            else {
                int lastStep = 0;
                for (int j = 1; j <= index; j++) {
                    for (int i = 0; (i < shift && j * shift + i < arr.length); i++) {
                        int b = arr[shift * j + i];
                        arr[shift * j + i] = arr[i];
                        arr[i] = b;
                        lastStep = i + 1;
                    }
                }
                System.out.println(lastStep);
                for (int k = 1; k <= shift - lastStep; k++) {
                    int b = arr[shift - 1];
                    for (int l = shift - 1; l > 0; l--) {
                        arr[l] = arr[l - 1];
                    }
                    arr[0] = b;
                }
            }
        }
    }

    public static void main(String[] args) {

        //1
        int[] arr_1 = {0, 1, 0, 1, 1, 1, 0, 0, 1};
        for (int i=0; i<arr_1.length; i++) {
            if (arr_1[i]==0) {
                arr_1[i]=1;
            }
            else {
                arr_1[i]=0;
            }
        }
        System.out.println(Arrays.toString(arr_1));

        //2
        int[] arr_2 = new int[8];
        for (int i=1; i<arr_2.length; i++) {
            arr_2[i]=i*3;
        }
        System.out.println(Arrays.toString(arr_2));

        //3
        int[] arr_3 = {1,5,3,2,11,4,5,2,4,8,9,1};
        for (int i=0; i<arr_3.length; i++) {
            if (arr_3[i]<6) {
                arr_3[i]*=2;
            }
        }
        System.out.println(Arrays.toString(arr_3));

        //4
        int [][] arr_4=new int[10][10];
        if (arr_4.length==0) {
            System.out.println("The Array arr_4 is too small!!!");
        }
        else {
            for (int i = 0; i < arr_4.length; i++) {
                arr_4[i][i] = 1;
            }
        }
        System.out.println(Arrays.deepToString(arr_4));

        //5
        int[] arr_5 = {2,4,5,7,3,1,0,-7,-9,-56,45,-100,20,7};
        if (arrLengthNoZeroOrOne(arr_5)) {
            System.out.println("The array arr_5 is too small!!!");
        }
        else {
            int max = arr_5[0];
            int min = arr_5[arr_5.length-1];
            for (int i = 0; i < arr_5.length - 1; i++) {
                max = max > arr_5[i + 1] ? max : arr_5[i + 1];
                min = min < arr_5[arr_5.length - i - 1] ? min : arr_5[arr_5.length - i - 1];
            }
            System.out.println(Arrays.toString(arr_5));
            System.out.println("max = " + max + "\nmin = " + min);
        }

        //6
        int[] arr_6={1,1,2,1,2,3,5,3,2,4,-9,7};
        arrSum(arr_6);

        //7
        int[] arr_7={-1,0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,};
//        arrShift_1(arr_7, 63);
//        System.out.println(Arrays.toString(arr_7));
        arrShift_2(arr_7, 7);
        System.out.println(Arrays.toString(arr_7));
    }
}

package boj.array;

import java.util.Scanner;

public class BOJ2941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int sum = str.length();
        String[] arr = new String[] {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        for (int i = 0; i < arr.length; i++) {
            int start = 0;
            while((start = str.indexOf(arr[i], start)) >= 0) {
                start++;
                sum--;
            }

        }

        System.out.println(sum);
    }
}
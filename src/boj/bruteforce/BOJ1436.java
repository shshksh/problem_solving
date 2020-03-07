package boj.bruteforce;

import java.util.Scanner;

public class BOJ1436 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int k = 0;
        int num = 0;
        for (int i = 666; k<n ; i++) {
            num = i;
            if(isTripleSix(i))
                k++;
        }
        System.out.println(num);
    }

    private static boolean isTripleSix(int i) {
        String str = String.valueOf(i);
        return str.contains("666");
    }
}
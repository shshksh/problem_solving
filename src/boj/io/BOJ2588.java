package boj.io;

import java.util.Scanner;

public class BOJ2588 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = a*b;
        System.out.println(a*(b%10));
        b/=10;
        System.out.println(a*(b%10));
        b/=10;
        System.out.println(a*b);
        System.out.println(c);
    }
}

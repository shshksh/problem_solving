package boj.math1;

import java.util.Scanner;

public class BOJ2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 1;
        while(n > 3*i*(i-1) +1)  {
            i++;
        }
        System.out.println(i);
    }
}
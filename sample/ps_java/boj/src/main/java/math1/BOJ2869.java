package math1;

import java.util.Scanner;

public class BOJ2869 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), v = sc.nextInt();
        System.out.println((int) (Math.ceil((double) (v - a) / (a - b)) + 1));
    }
}

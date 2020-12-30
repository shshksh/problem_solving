package algorithm.boj.dp1;

import java.util.Scanner;

public class Fibonacci2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        if(n == 1 || n ==2)
            System.out.println(1);
        else {
            long fibo = 0;
            long num1 = 1, num2 = 1;
            for (int i = 2; i < n; i++) {
                fibo = num1 + num2;
                num1 = num2;
                num2 = fibo;
            }
            System.out.println(fibo);
        }
    }
}
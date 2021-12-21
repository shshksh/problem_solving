package recursion;

import java.util.Scanner;

public class BOJ10870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibo(n));
    }

    private static int fibo(int n) {
        if (n == 1 || n == 2)
            return 1;
        if (n == 0)
            return 0;
        return fibo(n - 1) + fibo(n - 2);
    }
}

package math2;

import java.util.Scanner;

public class BOJ1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        for (int i = n1; i <= n2; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isPrime(int num) {
        if (num == 1)
            return false;
        int k = (int) Math.sqrt(num);
        for (int i = 2; i <= k; i++) {
            if ((num % i) == 0)
                return false;
        }
        return true;
    }
}

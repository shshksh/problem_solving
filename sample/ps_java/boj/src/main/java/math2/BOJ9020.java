package math2;

import java.util.Scanner;

public class BOJ9020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            printPrime(num);
        }
    }

    private static void printPrime(int num) {
        for (int i = num / 2; i > 1; i--) {
            if (isPrime(i) && isPrime(num - i)) {
                System.out.println(i + " " + (num - i));
                break;
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

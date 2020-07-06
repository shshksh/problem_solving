package algorithm.boj.math2;

import java.util.Scanner;

public class BOJ1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), cnt = 0;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if(isPrime(num))
                cnt++;
        }
        System.out.println(cnt);
    }

    private static boolean isPrime(int num) {
        if(num == 1)
            return false;
        int k = (int)Math.sqrt(((double)num));
        for (int i = 2; i <= k; i++) {
            if((num % i) == 0)
                return false;
        }
        return true;
    }
}
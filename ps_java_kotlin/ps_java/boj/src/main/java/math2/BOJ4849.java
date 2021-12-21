package math2;

import java.util.Scanner;

public class BOJ4849 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int num = sc.nextInt(), cnt = 0;
            if (num == 0)
                break;
            for (int i = num + 1; i <= num * 2; i++) {
                if (isPrime(i))
                    cnt++;
            }
            System.out.println(cnt);
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

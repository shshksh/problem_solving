package function;

import java.util.Scanner;

class BOJ1065 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 99;
        if (n < 100)
            System.out.println(n);
        else {
            for (int i = 100; i <= n; i++) {
                if (isValid(i)) {
                    cnt++;
                }
            }
            if (n == 1000)
                cnt--;
            System.out.println(cnt);
        }
    }

    private static boolean isValid(int i) {
        int k = i % 10;
        i /= 10;
        k = k - i % 10;
        if (i % 10 - (i / 10) % 10 != k)
            return false;
        return true;
    }
}

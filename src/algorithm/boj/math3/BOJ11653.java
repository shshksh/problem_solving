package algorithm.boj.math3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n != 1)
            printN(n, 2);
    }

    private static void printN(int n, int k) {
        if (n == 1)
            return;
        for (int i = k; i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i);
                printN(n / i, i);
                break;
            }
        }
    }
}

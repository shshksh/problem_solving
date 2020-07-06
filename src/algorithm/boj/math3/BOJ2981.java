package algorithm.boj.math3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2981 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int gcd = commonGcdOf(arr);
        printN(gcd);
    }

    private static void printN(int n) {
        for (int i = 2; i <= n; i++) {
            if (n % i == 0)
                System.out.print(i + " ");
        }
    }

    private static int commonGcdOf(int[] arr) {
        int gcd = arr[0] - arr[1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                gcd = gcd(gcd, Math.abs(arr[i] - arr[j]));
            }
        }
        return gcd;
    }

    private static int gcd(int i, int j) {
        if (j == 0)
            return i;
        return gcd(j, i % j);
    }
}
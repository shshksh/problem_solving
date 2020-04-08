package boj.math3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3036 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            print(arr[0], arr[i]);
        }
    }

    private static void print(int i, int j) {
        int gcd = gcd(i, j);
        int gcm = i*j/gcd;
        System.out.println(gcm/j+"/"+gcm/i);
    }

    private static int gcd(int i, int j) {
        if (j == 0)
            return i;
        return gcd(j, i % j);
    }
}
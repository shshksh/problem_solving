package boj.unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, k;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int t = n-k;

        int a = fiveCount(n);
        int b = fiveCount(t);
        int c = fiveCount(k);

        int f = a-b-c;

        a = twoCount(n);
        b = twoCount(t);
        c = twoCount(k);

        f = Math.min(f, a-b-c);

        System.out.println(f);
    }

    public static int twoCount(int n) {
        int sum = 0;
        for (long i = 2; i <= n; i*=2) {
            sum += n/i;
        }
        return sum;
    }

    public static int fiveCount(int n) {
        int sum = 0;
        for (long i = 5; i <= n; i*=5) {
            sum += n/i;
        }
        return sum;
    }
}
package algorithm.boj.math3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int fact = 1, cnt = 0;
        for (int i = 1; i <= t; i++) {
            fact *= i;
            while (fact % 10 == 0) {
                fact /= 10;
                cnt++;
            }
            while (fact > 100000)
                fact -= fact/100000 * 100000;
        }

        System.out.println(cnt);
    }
}
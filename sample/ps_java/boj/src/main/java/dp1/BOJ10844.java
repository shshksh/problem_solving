package dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10844 {
    static long[][] arr;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new long[n + 1][10];
        for (int i = 1; i < 10; i++)
            arr[1][i] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0)
                    arr[i][j] = arr[i - 1][1];
                else if (j == 9)
                    arr[i][j] = arr[i - 1][8];
                else
                    arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j + 1]) % 1000000000;
            }

        }
        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += arr[n][i];
        }

        System.out.println(sum % 1000000000);
    }
}

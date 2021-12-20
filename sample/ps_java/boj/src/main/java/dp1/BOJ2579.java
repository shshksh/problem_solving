package dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2579 {
    static int[] arr;
    static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        result = new int[n + 1][2];
        result[1][0] = arr[1];
        result[1][1] = arr[1];

        for (int i = 2; i <= n; i++) {
            result[i][0] = result[i - 1][1] + arr[i];
            result[i][1] = Math.max(result[i - 2][0], result[i - 2][1]) + arr[i];
        }

        System.out.println(Math.max(result[n][0], result[n][1]));
    }
}

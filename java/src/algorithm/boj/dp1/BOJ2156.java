package algorithm.boj.dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2156 {
    static int[] data;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        data = new int[n+1];
        for (int i = 1; i <= n; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }
        int[][] arr = new int[n+1][2];
        arr[1][0] = data[1];
        arr[1][1] = data[1];
        int max = 0;
        for (int i = 2; i <= n; i++) {
            max = Math.max(max, Math.max(arr[i-2][0], arr[i-2][1]));
            arr[i][0] = arr[i-1][1] + data[i];
            arr[i][1] = max + data[i];
        }
        int i = Math.max(arr[n-1][0], arr[n-1][1]);
        int j = Math.max(arr[n][0], arr[n][1]);
        max = Math.max(max, Math.max(i,j));

        System.out.println(max);
    }
}
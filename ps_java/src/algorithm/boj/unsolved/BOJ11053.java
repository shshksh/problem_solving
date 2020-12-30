package algorithm.boj.unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
기존의 접근법.
감소하는 경우를 처리하는데 실패했다.
public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] data = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        int[][] arr = new int[n + 1][n + 1];
        for (int i = n - 1; i > 0; i--) {
            for (int j = i + 1; j <= n; j++) {
                if (j == i + 1) {
                    arr[i][j] = data[j] > data[i] ? 2 : 1;
                    System.out.print(arr[i][j] + " ");
                } else {
                    arr[i][j] = arr[i + 1][j];
                    if (arr[i][j - 1] == arr[j - 1][j])
                        arr[i][j]++;
                }
            }
        }
        System.out.println(arr[1][n]);
    }
 */

public class BOJ11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] data = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+1];
        dp[1] = 1;
        int max = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if(data[i] > data[j])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}

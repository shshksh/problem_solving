package algorithm.boj.dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] data = new int[501];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            data[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        int[] dp = new int[501];
        for (int i = 1; i <= 500; i++) {
            dp[i] = 1;
            if(data[i] != 0)
                for (int j = 1; j < i; j++) {
                    if(data[j] != 0 && data[j] < data[i])
                        dp[i] = Math.max(dp[i], dp[j]+1);
                }
            cnt = Math.max(cnt, dp[i]);
        }
        System.out.println(n-cnt);
    }
}

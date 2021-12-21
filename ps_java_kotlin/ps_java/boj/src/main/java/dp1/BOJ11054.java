package dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] data = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        int[] LDS = new int[n + 1];
        int[] LIS = new int[n + 1];
        int max = 0;

        for (int i = 1; i <= n; i++) {
            LIS[i] = 1;
            for (int j = 1; j < i; j++) {
                if (data[j] < data[i])
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
            }
            LDS[n - i + 1] = 1;
            for (int j = 1; j < i; j++) {
                if (data[n - j + 1] < data[n - i + 1])
                    LDS[n - i + 1] = Math.max(LDS[n - i + 1], LDS[n - j + 1] + 1);
            }
        }
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, LIS[i] + LDS[i] - 1);
        }

        System.out.println(max);
    }
}

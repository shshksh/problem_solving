package boj.dp1;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] tri = new int[n][n];
        StringTokenizer st;

        tri[0][0] = Integer.parseInt(br.readLine());
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                if (j == 0 ) {
                    tri[i][j] = tri[i-1][j] + Integer.parseInt(st.nextToken());
                } else if (j == i) {
                    tri[i][j] = tri[i-1][i-1] + Integer.parseInt(st.nextToken());
                } else {
                    tri[i][j] = Math.max(tri[i-1][j-1], tri[i-1][j]) + Integer.parseInt(st.nextToken());
                }
            }
        }
        int max = tri[n-1][0];
        for (int i = 1; i < n ; i++) {
            max = Math.max(max, tri[n-1][i]);
        }
        System.out.println(max);
    }
}


package algorithm.boj.dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] table = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int smallIndex = -1, midValue = 0;
        for (int i = 0; i < n-1; i++) {
            if(table[i][0] < table[i][1]) {
                smallIndex = 0;
                midValue = table[i][1];
                if(table[i][2] < table[i][0]) {
                    smallIndex = 2;
                    midValue = table[i][0];
                } else if (table[i][2] <= table[i][1]) {
                    midValue = table[i][2];
                }
            } else {
                smallIndex = 1;
                midValue = table[i][0];
                if(table[i][2] < table[i][1]) {
                    smallIndex = 2;
                    midValue = table[i][1];
                } else if (table[i][2] <= table[i][0]) {
                    midValue = table[i][2];
                }
            }

            for (int j = 0; j < 3; j++) {
                if(j != smallIndex)
                    table[i+1][j] += table[i][smallIndex];
                else
                    table[i+1][j] += midValue;
            }
        }

        System.out.println(Math.min(Math.min(table[n - 1][0], table[n - 1][1]), table[n - 1][2]));
    }
}

/* 깔끔한 풀이 - xadmksh
import java.io.*;
import java.util.*;

public class Main {

	static final int R = 0, G = 1, B = 2;
	static int[][] D;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		D = new int[N + 1][3];
		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			D[n][R] = Math.min(D[n - 1][G], D[n - 1][B]) + Integer.parseInt(st.nextToken());
			D[n][G] = Math.min(D[n - 1][R], D[n - 1][B]) + Integer.parseInt(st.nextToken());
			D[n][B] = Math.min(D[n - 1][R], D[n - 1][G]) + Integer.parseInt(st.nextToken());
		}

		int ret = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			ret = Math.min(ret, D[N][i]);
		}
		System.out.println(ret);

	}

}
 */
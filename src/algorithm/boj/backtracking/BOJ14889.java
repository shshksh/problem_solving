package algorithm.boj.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14889 {
    static int n = 0;
    static int[][] arr = null;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] used = new int[n/2];
        used[0] = 1;

        bt(used, 0,  1);

        System.out.println(min);
    }

    private static void bt(int[] used, int index, int level) {
        if (level == n / 2) {
            min = Math.min(min, calc(used));
            return;
        }
        for (int i = used[index]+1; i <= n ; i++) {
            used[index+1] = i;
            bt(used, index+1, level+1);
        }
    }

    private static int calc(int[] used) {
        int[] unused = new int[n/2];
        for (int i = 1, j = 0, k = 0; i <= n; i++) {
            if(j >= n/2 || used[j] != i) {
                unused[k++] = i;
            } else
                j++;
        }
        return Math.abs(sumOf(used)-sumOf(unused));
    }

    private static int sumOf(int[] used) {
        int sum = 0;
        for (int i = 0; i < n/2; i++) {
            for (int j = i+1; j < n/2; j++) {
                sum += arr[used[i]-1][used[j]-1];
                sum += arr[used[j]-1][used[i]-1];
            }
        }
        return sum;
    }
}

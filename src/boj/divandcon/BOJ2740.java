package boj.divandcon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2740 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] matrix1 = input(br);
        int[][] matrix2 = input(br);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                int sum = 0;
                for (int k = 0; k < matrix1[0].length; k++) {
                    sum += matrix1[i][k] * matrix2[k][j];
                }
                sb.append(sum).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static int[][] input(BufferedReader br) throws IOException {
        int[][] matrix = null;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        matrix = new int[n][m];
        for (int j = 0; j < n; j++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < m; k++) {
                matrix[j][k] = Integer.parseInt(st.nextToken());
            }
        }
        return matrix;
    }
}
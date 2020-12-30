package algorithm.boj.divandcon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10830 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int[][] matrix = input(n, br);

        int[][] result = fastExpo(matrix, b);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j]%1000 + " ");
            }
            System.out.println();
        }
    }

    private static int[][] fastExpo(int[][] matrix, long b) {
        if (b == 1)
            return matrix;
        int[][] result = fastExpo(matrix, b/2);
        if (b % 2 == 1) {
            return mulMatrix(mulMatrix(result, result), matrix);
        } else {
            return mulMatrix(result, result);
        }
    }

    private static int[][] mulMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix1.length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                int sum = 0;
                for (int k = 0; k < matrix1[0].length; k++) {
                    sum += matrix1[i][k] * matrix2[k][j] % 1000;
                }
                result[i][j] = sum % 1000;
            }
        }
        return result;
    }

    private static int[][] input(int n, BufferedReader br) throws IOException {
        int[][] matrix = null;
        matrix = new int[n][n];
        for (int j = 0; j < n; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int k = 0; k < n; k++) {
                matrix[j][k] = Integer.parseInt(st.nextToken());
            }
        }
        return matrix;
    }
}
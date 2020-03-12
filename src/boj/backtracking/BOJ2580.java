package boj.backtracking;

import java.io.*;

public class BOJ2580 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] table = new int[9][9];
    static boolean hasBlank = true;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 9; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < 9; j++)
                table[i][j] = Integer.parseInt(tmp[j]);
        }
        backtracking(0, 0);
        printTable();
    }

    private static void backtracking(int row, int col) {
        for (int i = row; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(i == row && j < col)
                    j = col;
                if (table[i][j] == 0) {
                    for (int k = 1; k <= 9 && hasBlank; k++) {
                        if (isCorrectNumber(k, i, j)) {
                            table[i][j] = k;
                            backtracking(i, j);
                        }
                    }
                    if(!hasBlank)
                        return;
                    table[i][j] = 0;
                    return;
                }
            }
        }
        hasBlank = false;
    }

    private static boolean isCorrectNumber(int k, int row, int col) {
        //row
        for (int i = 0; i < 9; i++) {
            if (table[row][i] == k && i != col)
                return false;
        }
        //col
        for (int i = 0; i < 9; i++) {
            if (table[i][col] == k && i != row)
                return false;
        }
        //matrix
        row /= 3;
        col /= 3;
        row *= 3;
        col *= 3;
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (table[i][j] == k)
                    return false;
            }
        }
        return true;
    }

    private static void printTable() throws IOException {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                bw.write(table[i][j] + " ");
            }
            bw.newLine();
        }
        bw.flush();
    }

}

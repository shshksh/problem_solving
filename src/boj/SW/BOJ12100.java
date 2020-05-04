package boj.SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12100 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(largestNum(board, 0, 0, ""));
    }

    private static int largestNum(int[][] board, int max, int k, String sequence) {
        if (k == 5) {
//            System.out.println(sequence);
            int currMax = 0;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    currMax = Math.max(currMax, board[i][j]);
//                    System.out.print(board[i][j] + " ");
                }
//                System.out.println();
            }
//            System.out.println();
            return currMax;
        }
        for (int i = 0; i < 4; i++) {
//            System.out.println(sequence);
//            for (int m = 0; m < board.length; m++) {
//                for (int n = 0; n < board.length; n++) {
//                    System.out.print(board[m][n] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
            max = Math.max(max, largestNum(mergeBoard(board, i), max, k + 1, sequence+(i+6)));
        }

        return max;
    }

    private static int[][] mergeBoard(int[][] board, int index) {
        int n = board.length;
        int[][] merged = new int[n][n];
        boolean isMerged = false;

        switch (index) {
            case 0:
                for (int i = 0; i < n; i++) {
                    for (int j = 0, k = 0; j < n; j++) {
                        if (board[j][i] != 0)
                            if (k != 0 && board[j][i] == merged[k-1][i] && !isMerged) {
                                merged[k-1][i] += board[j][i];
                                isMerged = true;
                            } else {
                                merged[k++][i] = board[j][i];
                                isMerged = false;
                            }
                    }
                }
                break;
            case 1:
                for (int i = 0; i < n; i++) {
                    for (int j = 0, k = 0; j < n; j++) {
                        if (board[i][j] != 0)
                            if (k != 0 && board[i][j] == merged[i][k-1] && !isMerged) {
                                merged[i][k-1] += board[i][j];
                                isMerged = true;
                            } else {
                                merged[i][k++] = board[i][j];
                                isMerged = false;
                            }
                    }
                }
                break;
            case 2:
                for (int i = 0; i < n; i++) {
                    for (int j = n - 1, k = n - 1; j >= 0; j--) {
                        if (board[j][i] != 0)
                            if (k != n-1 && board[j][i] == merged[k+1][i] && !isMerged) {
                                merged[k+1][i] += board[j][i];
                                isMerged = true;
                            } else {
                                merged[k--][i] = board[j][i];
                                isMerged = false;
                            }
                    }
                }
                break;
            case 3:
                for (int i = 0; i < n; i++) {
                    for (int j = n - 1, k = n - 1; j >= 0; j--) {
                        if (board[i][j] != 0)
                            if (k != n-1 && board[i][j] == merged[i][k+1] && !isMerged) {
                                merged[i][k+1] += board[i][j];
                                isMerged = true;
                            } else {
                                merged[i][k--] = board[i][j];
                                isMerged = false;
                            }
                    }
                }
                break;
        }

        return merged;
    }
}
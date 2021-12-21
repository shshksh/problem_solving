package Level2;

import java.util.LinkedList;
import java.util.Queue;

public class ColoringBook {
    public static int[] solution(int m, int n, int[][] picture) {
        int[][] offset = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int[] answer = new int[2];
        boolean[][] chk = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!chk[i][j] && picture[i][j] != 0) {
                    answer[0]++;
                    answer[1] = Math.max(answer[1], blobSize(picture, i, j, chk, offset));
                }
            }
        }
        return answer;
    }

    private static int blobSize(int[][] picture, int i, int j, boolean[][] chk,
                                int[][] offset) {
        int sum = 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        chk[i][j] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int nextX, nextY;
            for (int k = 0; k < 4; k++) {
                nextX = curr[0] + offset[k][0];
                nextY = curr[1] + offset[k][1];
                if (isValid(picture, nextX, nextY, chk) && picture[curr[0]][curr[1]] == picture[nextX][nextY]) {
                    chk[nextX][nextY] = true;
                    sum++;
                    q.offer(new int[]{nextX, nextY});
                }
            }
        }

        return sum;
    }

    private static boolean isValid(int[][] picture, int i, int j, boolean[][] chk) {
        if (i < 0 || j < 0 || i >= picture.length || j >= picture[0].length || chk[i][j]) {
            return false;
        }
        return true;
    }
}

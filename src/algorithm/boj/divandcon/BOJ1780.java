package algorithm.boj.divandcon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1780 {
    static int[] pieces = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] paper = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cutPaper(paper, n, 0, 0);
        for (int piece : pieces) {
            System.out.println(piece);
        }
    }

    private static void cutPaper(int[][] paper, int size, int x, int y) {
        int status = isCut(paper, size, x, y);
        if(status >= 0) {
            pieces[status]++;
            return;
        }
        size /= 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cutPaper(paper, size, x+size*i, y+size*j);
            }
        }
    }

    private static int isCut(int[][] paper, int size, int x, int y) {
        int color = paper[x][y];
        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y + size; j++) {
                if(paper[i][j] != color)
                    return -1;
            }
        }
        return color + 1;
    }
}
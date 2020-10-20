package algorithm.boj.divandcon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2630 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] paper = new String[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = st.nextToken();
            }
        }

        System.out.println(cntOfPiece(paper, n, 0, 0, "0"));
        System.out.println(cntOfPiece(paper, n, 0, 0, "1"));
    }

    private static int cntOfPiece(String[][] paper, int size, int x, int y, String target) {
        if(size == 0)
            return 0;
        if(isPiece(paper,size,x,y,target))
            return 1;
        int sum = 0;
        size /= 2;
        sum += cntOfPiece(paper, size, x, y, target);
        sum += cntOfPiece(paper, size, x+size, y, target);
        sum += cntOfPiece(paper, size, x, y+size, target);
        sum += cntOfPiece(paper, size, x+size, y+size, target);

        return sum;
    }

    private static boolean isPiece(String[][] paper, int size, int x, int y, String target) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y+size; j++) {
                if(!paper[i][j].equals(target))
                    return false;
            }
        }
        return true;
    }
}
package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1211 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            br.readLine();
            test(br, i + 1);
        }
    }

    private static void test(BufferedReader br, int t) throws IOException {
        int[][] ladder = new int[100][100];
        for (int i = 0; i < 100; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 100; j++) {
                ladder[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = 10000, index = -1;
        for (int i = 0; i < 100; i++) {
            if (ladder[0][i] == 1) {
                int result = run(ladder, 0, i);
                if (result < min) {
                    min = result;
                    index = i;
                }
            }
        }

        System.out.println("#" + t + " " + index);
    }

    private static int run(int[][] ladder, int x, int y) {
        if(x == 99)
            return 1;
        ladder[x][y] = -1;
        int cnt = 0;
        if(y < 99 && ladder[x][y+1] == 1)
            cnt = run(ladder, x, y+1) +1;
        else if (y > 0 && ladder[x][y-1] == 1)
            cnt = run(ladder, x, y-1) +1;
        else
            cnt = run(ladder, x + 1, y) +1;
        ladder[x][y] = 1;
        return cnt;
    }
}
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
            if (ladder[i][0] == 1) {
                int result = run(ladder, i);
                if (result < min) {
                    min = result;
                    index = i;
                }
            }
        }

        System.out.println("#" + t + " " + index);
    }

    private static int run(int[][] ladde, int start) {
        int cnt = 0;
        int x = 0, y = start;
        while (x < 100) {
            if (y == 0) {

            }
        }

        return cnt;
    }
}
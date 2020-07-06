package algorithm.boj.divandcon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1992 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] image = new String[n][n];
        for (int i = 0; i < n; i++) {
            image[i] = br.readLine().split("");
        }
        System.out.println(quadTree(image, n, 0, 0));
    }

    private static String quadTree(String[][] image, int size, int x, int y) {
        String color = isFull(image, size, x, y);
        if (!color.equals("-1"))
            return color;
        size /= 2;
        return "(" +
                quadTree(image, size, x, y) +
                quadTree(image, size, x, y + size) +
                quadTree(image, size, x + size, y) +
                quadTree(image, size, x + size, y + size) +
                ")";
    }

    private static String isFull(String[][] image, int size, int x, int y) {
        String color = image[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (!image[i][j].equals(color))
                    return "-1";
            }
        }
        return color;
    }
}
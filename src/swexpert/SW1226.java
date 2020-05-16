package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW1226 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 16;
        for (int i = 0; i < 10; i++) {
            br.readLine();
            int[][] maze = new int[16][16];
            int x = 0, y = 0;
            for (int j = 0; j < 16; j++) {
                String tmp = br.readLine();
                for (int k = 0; k < 16; k++) {
                    maze[j][k] = tmp.charAt(k) - 48;
                    if (maze[j][k] == 2) {
                        x = j;
                        y = k;
                    }
                }
            }

            System.out.println("#" + (i + 1) + " " + mazeRun(maze, x, y));
        }
    }

    public static int mazeRun(int[][] maze, int x, int y) {
        if (!isValid(maze, x, y))
            return 0;
        if (maze[x][y] == 3)
            return 1;
        maze[x][y] = 1;
        if (mazeRun(maze, x - 1, y) == 1 || mazeRun(maze, x, y + 1) == 1 || mazeRun(maze, x + 1, y) == 1 || mazeRun(maze, x, y - 1) == 1)
            return 1;
        maze[x][y] = 0;
        return 0;
    }

    private static boolean isValid(int[][] maze, int x, int y) {
        if (x <= 0 || y <= 0 || x >= maze.length || y >= maze.length || maze[x][y] == 1)
            return false;
        return true;
    }
}
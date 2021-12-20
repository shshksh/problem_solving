package pa2;

import java.util.Scanner;

public class Assign2 {
    final static int WALL = 1;
    final static int VISITED = 2;

    static int n, k;
    static int[][] maze;
    static int[][] offset = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        maze = new int[n][n];
        initMaze(sc);
        if (mazeRun(0, 0, 0))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    private static void initMaze(Scanner sc) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
    }

    private static boolean mazeRun(int x, int y, int dir) {
        if (!isValidPosition(x, y))
            return false;
        maze[x][y] = VISITED;
        while (isValidPosition(x + offset[dir][0], y + offset[dir][1])) {
            maze[x][y] = VISITED;
            x += offset[dir][0];
            y += offset[dir][1];
        }
        if (x == n - 1 && y == n - 1)
            return true;
        boolean result = false;
        for (int i = 0; i < 4; i++) {
            result = result || mazeRun(x + offset[i][0], y + offset[i][1], i);
        }
        return result;
    }

    private static boolean isValidPosition(int x, int y) {
        return !(x < 0 || y < 0 || x >= n || y >= n || maze[x][y] == WALL || maze[x][y] == VISITED);
    }
}

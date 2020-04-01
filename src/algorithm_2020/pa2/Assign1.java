package algorithm_2020.pa2;

import java.util.Scanner;

public class Assign1 {
    final static int PATH = 0;
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
        k = sc.nextInt();
        System.out.println(mazeRun(0, 0, 0));
    }

    private static void initMaze(Scanner sc) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
    }

    private static int mazeRun(int x, int y, int cnt) {
        if (!isValidPosition(x, y, cnt))
            return 0;
        if (x == n - 1 && y == n - 1)
            return 1;
        maze[x][y] = VISITED;
        int pathCnt = 0;
        for (int i = 0; i < 4; i++) {
            pathCnt += mazeRun(x + offset[i][0], y + offset[i][1], cnt + 1);
        }
        maze[x][y] = PATH;
        return pathCnt;
    }

    private static boolean isValidPosition(int x, int y, int cnt) {
        return !(cnt > k || x < 0 || y < 0 || x >= n || y >= n || maze[x][y] == WALL || maze[x][y] == VISITED);
    }
}
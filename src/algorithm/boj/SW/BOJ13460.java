package algorithm.boj.SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ13460 {
    static int[][] offset = new int[][]{
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };

    static class Position {
        int redX;
        int redY;
        int blueX;
        int blueY;
        int exitX;
        int exitY;
        boolean redExit = false;
        boolean blueExit = false;

        public Position() {
        }

        public Position(Position curr, int x, int y) {
            this.redX = curr.redX + x;
            this.redY = curr.redY + y;
            this.blueX = curr.blueX + x;
            this.blueY = curr.blueY + y;
            this.exitX = curr.exitX;
            this.exitY = curr.exitY;
        }
    }

    static String[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new String[n];

        Position pos = new Position();
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine();
            if (board[i].contains("B")) {
                pos.blueX = i;
                pos.blueY = board[i].indexOf("B");
            }
            if (board[i].contains("R")) {
                pos.redX = i;
                pos.redY = board[i].indexOf("R");
            }
            if (board[i].contains("O")) {
                pos.exitX = i;
                pos.exitY = board[i].indexOf("O");
            }
        }

        System.out.println(findExit(pos));
    }

    private static int findExit(Position pos) {
        int k = 0;
        Queue<Position> q = new LinkedList<>();
        q.offer(pos);

        while (!q.isEmpty() && k < 10) {
            k++;
            int t = q.size();

            while (t-- > 0) {
                Position curr = q.poll();
                for (int i = 0; i < 4; i++) {
                    Position next = null;
                    if (isMovable(curr, offset[i], 1) || isMovable(curr, offset[i], 2))
                        next = moved(curr, offset[i], k);
                    if (next == null || next.blueExit)
                        continue;
                    if (next.redExit)
                        return k;
                    q.offer(next);
                }
            }
        }
        return -1;
    }

    private static Position moved(Position curr, int[] offset, int k) {
        Position moved = new Position(curr, 0, 0);

        while (isMovable(moved, offset, 1)) {
            moved.redX += offset[0];
            moved.redY += offset[1];
            if(moved.redX == moved.exitX && moved.redY == moved.exitY)
                moved.redExit = true;
        }
        while (isMovable(moved, offset, 2)) {
            moved.blueX += offset[0];
            moved.blueY += offset[1];
            if(moved.blueX == moved.exitX && moved.blueY == moved.exitY)
                moved.blueExit = true;
        }
        while (isMovable(moved, offset, 1)) {
            moved.redX += offset[0];
            moved.redY += offset[1];
            if(moved.redX == moved.exitX && moved.redY == moved.exitY)
                moved.redExit = true;
        }

        return moved;
    }

    private static boolean isMovable(Position curr, int[] offset, int c) {
        int x = -1, y = -1;
        int otherX = -1, otherY = -1;
        switch (c) {
            case 1:
                x = curr.redX;
                y = curr.redY;
                otherX = curr.blueX;
                otherY = curr.blueY;
                break;
            case 2:
                x = curr.blueX;
                y = curr.blueY;
                otherX = curr.redX;
                otherY = curr.redY;
                break;
        }
        x += offset[0];
        y += offset[1];

        if (board[x].charAt(y) == 'O')
            return true;
        if (board[x].charAt(y) == '#')
            return false;
        if (x == otherX && y == otherY)
            return false;
        return true;
    }
}
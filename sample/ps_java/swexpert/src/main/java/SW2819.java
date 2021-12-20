import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SW2819 {
    static int[][] offset = new int[][]{
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };
    static int[][] board;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            board = new int[4][4];
            init(sc);
            Set<String> check = new HashSet<>();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    backtracking(0, i, j, "", check);
                }
            }
            System.out.println("#" + test_case + " " + check.size());
        }
    }

    private static void backtracking(int index, int x, int y, String num,
                                     Set<String> check) {
        if (!isValid(x, y))
            return;
        if (index == 7) {
            if (num.length() == 7) {
                check.add(num);
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            backtracking(index + 1, x + offset[i][0], y + offset[i][1],
                    num + board[x][y], check);
        }
    }

    private static boolean isValid(int x, int y) {
        return (x >= 0 && x < 4 && y >= 0 && y < 4);
    }

    private static void init(Scanner sc) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j] = sc.nextInt();
            }
        }
    }
}

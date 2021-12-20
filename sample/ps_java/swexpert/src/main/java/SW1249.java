import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class SW1249 {
    static data[][] map;
    static int n;
    static int[][] offset = new int[][]{
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            map = new data[n][n];
            init(sc);

            System.out.println("#" + test_case + " " + shortPath(n));
        }
    }

    private static void init(Scanner sc) {
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = new data(line.charAt(j) - 48);
            }
        }
    }

    private static int shortPath(int n) {
        Set<pos> adj = new HashSet<>();

        adj.add(new pos(0, 0));

        for (int i = 0; i < n * n - 1; i++) {
            pos minPos = minOf(adj);
//            System.out.println("current position: " + minPos.i + " " + minPos.j);
            map[minPos.i][minPos.j].marked = true;

            adj.remove(minPos);

            update(minPos, adj);
//            for (pos pos : adj) {
//                System.out.print("(" + pos.i + "," + pos.j+"), ");
//            }
//            System.out.println();

//            printLog();
        }

        return map[n - 1][n - 1].depth;
    }

    private static void printLog() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j].depth + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void update(pos minPos, Set<pos> adj) {
        int i = minPos.i;
        int j = minPos.j;
        data curr = map[i][j];

        for (int k = 0; k < 4; k++) {
            if (isValid(i + offset[k][0], j + offset[k][1])) {
                pos added = new pos(i + offset[k][0], j + offset[k][1]);
                if (!adj.contains(added) && !map[added.i][added.j].marked) {
//                    System.out.println("adj position: " + added.i + " " + added.j);
                    map[added.i][added.j].depth += curr.depth;
                    adj.add(added);
                }
            }
        }
    }

    private static boolean isValid(int i, int j) {
        return (i >= 0 && i < n && j >= 0 && j < n);
    }

    private static pos minOf(Set<pos> adj) {
        pos min = null;
        for (pos pos : adj) {
            if (min == null)
                min = pos;

            if (map[min.i][min.j].depth > map[pos.i][pos.j].depth) {
                min = pos;
            }
        }

        return min;
    }

    static class data {
        int depth;
        boolean marked;

        public data(int i) {
            depth = i;
        }
    }

    static class pos {
        int i;
        int j;

        public pos(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            pos pos = (pos) o;
            return i == pos.i &&
                    j == pos.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }
}

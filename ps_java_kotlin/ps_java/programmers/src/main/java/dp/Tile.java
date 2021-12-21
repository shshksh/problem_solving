package dp;

public class Tile {
    public static long solution(int N) {
        long n1 = 1, n2 = 1, n3 = 1;
        if (N == 1)
            return 4;
        else if (N == 2)
            return 6;
        for (int i = 2; i < N; i++) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
        return (n2 * 2 + n1) * 2;
    }
}

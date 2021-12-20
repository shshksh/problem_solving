package dp;

public class SchoolRoad {
    static int[][] arr;

    public static int solution(int m, int n, int[][] puddles) {
        arr = new int[n + 1][m + 1];
        for (int[] puddle : puddles) {
            for (int i = 0; i < puddle.length; i++) {
                arr[puddle[1]][puddle[0]] = -1;
            }
        }
        arr[1][1] = 1;
        return dp(n, m);
    }

    private static int dp(int i, int j) {
        if (arr[i][j] < 0)
            return 0;
        else if (arr[i][j] > 0)
            return arr[i][j];
        if (i == 0 || j == 0)
            return 1;
        arr[i][j] = (dp(i - 1, j) + dp(i, j - 1)) % 1000000007;
        return arr[i][j];
    }
}

package dp;

public class IntegerTriangle {
    public static int solution(int[][] triangle) {
        int[][] arr = new int[triangle.length][triangle.length];
        arr[0][0] = triangle[0][0];
        int max = arr[0][0];
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0)
                    arr[i][j] = arr[i - 1][j] + triangle[i][j];
                else if (j == i)
                    arr[i][j] = arr[i - 1][j - 1] + triangle[i][j];
                else
                    arr[i][j] =
                            Integer.max(arr[i - 1][j - 1], arr[i - 1][j]) + triangle[i][j];
                if (i == triangle.length - 1)
                    max = Integer.max(max, arr[i][j]);
            }
        }
        return max;
    }
}

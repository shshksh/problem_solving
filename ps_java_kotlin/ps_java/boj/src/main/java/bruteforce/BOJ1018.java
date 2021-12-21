package bruteforce;

import java.util.Scanner;

public class BOJ1018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int min = 64;
        String[] arr = new String[m];
        for (int i = 0; i < m; i++) {
            arr[i] = sc.next();
        }
        for (int i = 0; i < m - 7; i++) {
            for (int j = 0; j < n - 7; j++) {
                int cnt = Math.min(bs(arr, i, j), ws(arr, i, j));
                min = Math.min(min, cnt);
            }
        }
        System.out.println(min);
    }

    private static int bs(String[] arr, int i, int j) {
        int cnt = 0;
        for (int p = i; p < i + 8; p++) {
            for (int q = j; q < j + 8; q++) {
                if ((p + q) % 2 == 0) {
                    if (arr[p].charAt(q) != 'B')
                        cnt++;
                } else if ((p + q) % 2 == 1) {
                    if (arr[p].charAt(q) != 'W')
                        cnt++;
                }
            }
        }
        return cnt;
    }

    private static int ws(String[] arr, int i, int j) {
        int cnt = 0;
        for (int p = i; p < i + 8; p++) {
            for (int q = j; q < j + 8; q++) {
                if ((p + q) % 2 == 0) {
                    if (arr[p].charAt(q) != 'W')
                        cnt++;
                } else if ((p + q) % 2 == 1) {
                    if (arr[p].charAt(q) != 'B')
                        cnt++;
                }
            }
        }
        return cnt;
    }
}

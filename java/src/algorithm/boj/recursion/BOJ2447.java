package algorithm.boj.recursion;

import java.util.Scanner;

public class BOJ2447 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        n = (int) (Math.log10(n) / Math.log10(3));
        String[] base = {"*"};
        String blank = " ";

        for (String s : makePattern(0, n, base, blank)) {
            System.out.println(s);
        }

    }

    private static String[] makePattern(int t, int n, String[] base, String blank) {
        if (t == n)
            return base;
        String[] next = new String[base.length*3];
        for (int j = 0; j < base.length; j++) {
            next[j] = base[j] + base[j] + base[j];
        }
        for (int i = base.length, j = 0; i < base.length*2; i++, j++) {
            next[i] = base[j] + blank + base[j];
        }
        for (int i = base.length*2, j = 0; i < base.length*3; i++, j++) {
            next[i] = next[j];
        }
        blank = blank + blank + blank;

        return makePattern(t + 1, n, next, blank);
    }
}

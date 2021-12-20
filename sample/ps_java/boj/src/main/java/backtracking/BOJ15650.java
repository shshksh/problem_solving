package backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ15650 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        solve(list, n, m);
    }

    private static void solve(ArrayList<Integer> list, int n, int m) {
        if (list.size() == m) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
            list.remove(m - 1);
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!list.contains(i)) {
                if (list.isEmpty() || list.get(list.size() - 1) < i) {
                    list.add(i);
                    solve(list, n, m);
                }
            }
        }
        if (list.size() != 0)
            list.remove(list.size() - 1);
    }
}

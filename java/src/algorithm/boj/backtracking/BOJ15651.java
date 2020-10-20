package algorithm.boj.backtracking;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BOJ15651 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        solve(list, n, m);
        bw.flush();
    }

    private static void solve(ArrayList<Integer> list, int n, int m) throws IOException {
        if(list.size() == m) {
            for (Integer integer : list) {
                bw.write(integer + " ");
            }
            bw.newLine();
            list.remove(m-1);
            return;
        }
        for (int i = 1; i <= n; i++) {
            list.add(i);
            solve(list, n , m);
        }
        if(list.size() != 0)
            list.remove(list.size()-1);
    }
}
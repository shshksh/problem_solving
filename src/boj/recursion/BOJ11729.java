package boj.recursion;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class BOJ11729 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = new Scanner(System.in).nextInt();
        Stack[] hanoi = new Stack[3];
        for (int i = 0; i < hanoi.length; i++) {
            hanoi[i] = new Stack<Integer>();
        }
        for (int i = 0; i < n; i++) {
            hanoi[0].push(n - i);
        }
        System.out.println(((int) Math.pow(2, n) - 1));
        HanoiTower(n, hanoi, 0, 2);
        bw.flush();
        bw.close();
    }

    public static void HanoiTower(int n, Stack[] hanoi, int from, int to) throws IOException {
        if (n == 0)
            return;
        int[] chk = new int[3];
        chk[from]++;
        chk[to]++;
        int tmp = -1;
        for (int i = 0; i < chk.length; i++) {
            if(chk[i] == 0)
                tmp = i;
        }
        HanoiTower(n-1, hanoi, from, tmp);
        move(hanoi, from, to);
        HanoiTower(n-1, hanoi, tmp, to);
    }

    private static void move(Stack[] hanoi, int from, int to) throws IOException {
        hanoi[to].push(hanoi[from].pop());
        String str = (from+1) + " " + (to+1) + "\n";
        bw.write(str);
    }
}

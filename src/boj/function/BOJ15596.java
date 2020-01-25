package boj.function;

public class BOJ15596 {
    long sum(int[] a) {
        long b = 0;
        for (int i : a) {
            b += i;
        }
        return b;
    }
}
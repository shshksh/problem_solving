package pa1;

import java.util.Scanner;

public class Assign4 {
    static int n, k;
    static int[] data;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        input();
        System.out.println(nearest(0, (n - 1) / 2, n - 1));
    }

    private static int nearest(int start, int mid, int end) {
        if (k > data[n - 1])
            return data[n - 1];
        if (k < data[0])
            return data[0];
        if (data[mid] == k)
            return k;
        if (start > end) {
            if (Math.abs(k - data[end]) <= Math.abs(k - data[start]))
                return data[end];
            else
                return data[start];
        } else if (data[mid] > k) {
            end = mid - 1;
            mid = (start + end) / 2;
        } else if (data[mid] < k) {
            start = mid + 1;
            mid = (start + end) / 2;
        }
        return nearest(start, mid, end);
    }

    private static void input() {
        n = sc.nextInt();
        data = new int[n];
        inputData(0);
        k = sc.nextInt();
    }

    private static void inputData(int i) {
        if (i == n)
            return;
        data[i] = sc.nextInt();
        inputData(i + 1);
    }

}

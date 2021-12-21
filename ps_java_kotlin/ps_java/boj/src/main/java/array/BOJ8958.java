package array;

import java.util.Scanner;

public class BOJ8958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String result = sc.next();
            int sum = 0;
            int k = 1;
            for (int j = 0; j < result.length(); j++) {
                if (result.charAt(j) == 'O') {
                    sum += k++;
                } else
                    k = 1;
            }
            System.out.println(sum);
        }
    }
}

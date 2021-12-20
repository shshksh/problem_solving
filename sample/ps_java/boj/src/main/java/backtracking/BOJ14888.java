package backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14888 {
    static int[] numbers;
    static int n;
    static int min = 1000000000;
    static int max = -1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        int[] operators = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < operators.length; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        bt(operators, 0, numbers[0]);
        bw.write(max + "\n" + min);
        bw.flush();
    }

    private static void bt(int[] operators, int level, int result) {
        if (level == n - 1) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }
        for (int i = 0; i < n - level - 1; i++) {
            int operator = chooseOper(operators, i);
            operators[operator]--;
            bt(operators, level + 1, calc(result, operator, level + 1));
            operators[operator]++;
        }
    }

    private static int calc(int result, int operator, int index) {
        switch (operator) {
            case 0:
                return result + numbers[index];
            case 1:
                return result - numbers[index];
            case 2:
                return result * numbers[index];
            case 3:
                return result / numbers[index];
            default:
                break;
        }
        return 0;
    }

    private static int chooseOper(int[] operators, int index) {
        for (int i = 0; i < operators.length; i++) {
            index -= operators[i];
            if (index < 0)
                return i;
        }
        return -1;
    }
}

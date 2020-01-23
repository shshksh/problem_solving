package programmers.sort;

import java.util.Arrays;

public class K_Number {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] tmp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(tmp);
            answer[i] = tmp[commands[i][2]-1];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] {
                {2,5,3},
                {4,4,1},
                {1,7,3}
        };
        int[] k = new int[] {1,5,2,6,3,7,4};
        int[] q = solution(k, arr);

        for (int i : q) {
            System.out.println(i);
        }
    }
}

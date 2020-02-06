package programmers.Level1;

import java.util.Arrays;

public class SecretMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        int[] sum = new int[arr1.length];
        for (int i = 0; i < sum.length; i++) {
            sum[i] = arr1[i]|arr2[i];
        }
        String[] answer = new String[arr1.length];
        Arrays.fill(answer, "");
        for (int i = 0; i < answer.length; i++) {
            for (int j = 1; j < 1 << arr1.length; j<<=1) {
                if((sum[i] & j) > 0)
                    answer[i] = "#" + answer[i];
                else
                    answer[i] = " " + answer[i];
            }
        }
        return answer;
    }
}
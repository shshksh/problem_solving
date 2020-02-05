package programmers.Level1;

import java.util.ArrayList;
import java.util.Arrays;

public class Divisible {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] % divisor == 0)
                list.add(arr[i]);
        }
        int[] answer;
        if(list.size() != 0) {
            answer = new int[list.size()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = list.get(i);
            }
            Arrays.sort(answer);
        } else
            answer = new int[] {-1};
        return answer;
    }
}
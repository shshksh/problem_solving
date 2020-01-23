package programmers.binarySearch;

import java.util.Arrays;

public class Budget {
    static int max;

    public static int solution(int[] budgets, int M) {
        int length = budgets.length;
        Arrays.sort(budgets);
        max = M/length;

        for (int budget : budgets) {
            if(budget < max) {
                M-=budget;
                length--;
            } else {
                max = M/length;
                if(budget < max) {
                    M-=budget;
                    length--;
                } else
                    break;
            }
        }

        return length==0?M:max;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1,2,3,4}, 485));
    }
}

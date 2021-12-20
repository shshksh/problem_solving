package stack_queue;

import java.util.Stack;

public class Price {
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int t = 0;
        Stack<Integer> s = new Stack<>();

        for (; t < prices.length; t++) {
            while (!s.isEmpty() && prices[t] < prices[s.peek()]) {
                answer[s.peek()] = t - s.pop();
            }
            s.push(t);
        }
        while (!s.isEmpty()) {
            answer[s.peek()] = t - s.pop() - 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        for (int i : solution(new int[]{3, 4, 5, 2, 3, 4, 1, 2, 3})) {
            System.out.println(i);
        }
    }
}

package Level2;

import java.util.Stack;

public class CoupleRemove {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (!stack.empty() && s.charAt(i) == stack.peek())
                stack.pop();
            else
                stack.push(s.charAt(i));
        }
        return stack.empty() ? 1 : 0;
    }
}

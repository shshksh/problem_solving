package algorithm.programmers.greedy;

class BiggestNumber {
    public static String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);
        for(int i = 0; k > 0 && i < sb.length(); i++)
            for (int j = i + 1; j < sb.length() && j <= i + k; j++)
                if (sb.charAt(i) < sb.charAt(j)) {
                    sb.deleteCharAt(i);
                    k--;
                    i--;
                    break;
                }
        sb.delete(sb.length()-k, sb.length());
        return sb.toString();
    }
}

/*
class Solution {
    public static String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);
        int i = 0;
        while(k > 0 && i < sb.length()) {
            if(isRemove(sb, i, i+k)) {
                sb.deleteCharAt(i);
                k--;
            } else {
                i++;
            }
        }
        sb.delete(sb.length()-k, sb.length());
        return sb.toString();
    }

    private static boolean isRemove(StringBuilder sb, int i, int j) {
        for (int k = i+1;k <sb.length() && k <= j; k++) {
            if(sb.charAt(i) < sb.charAt(k))
                return true;
        }
        return false;
    }
}
// 처음 짠 코드. 되려 메소드가 없을때보다 3배가량 빠른데 이유를 모르겠다.
 */

/*
import java.util.Stack;
class Solution {
    public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }
// 스택을 사용한 빠른 퍼포먼스
 */
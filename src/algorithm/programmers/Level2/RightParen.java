package algorithm.programmers.Level2;

public class RightParen {
    boolean solution(String s) {
        int sum = 0;
        for (int i = 0; i < s.length() && sum >= 0; i++) {
            if(s.charAt(i) == '(')
                sum++;
            if(s.charAt(i) == ')')
                sum--;
        }
        return sum==0;
    }
}
package algorithm.programmers.Level2;

public class JumpOrTeleport {
    int result = 0;
    public int solution(int n) {
        if(n==0)
            return result;
        if(n % 2 == 1) {
            result++;
            return solution(n-1);
        } else
            return solution(n/2);
    }
}
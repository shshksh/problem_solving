package programmers.Level2;

public class ExpressNumber {
    public int solution(int n) {
        int result = 0;
        for (int init = 1; init <= n/2; init++) {
            int sum = 0;
            int add = init;
            while(sum < n) {
                sum += add;
                add++;
            }
            if(sum == n)
                result++;
        }
        return result+1;
    }
}
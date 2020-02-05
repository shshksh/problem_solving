package programmers.Level1;

public class WaterMelon {
    public String solution(int n) {
        char[] arr = new char[]{'수', '박'};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i%2]);
        }
        return sb.toString();
    }
}
package algorithm.programmers.Level1;

public class Year2016 {
    public String solution(int a, int b) {
        int[] months = new int[] {31,29,31,30,31,30,31,31,30,31,30,31};
        String[] week = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int day = 0;
        for (int i = 0; i < a-1; i++) {
            day += months[i];
        }
        day += b;
        day -= 1;
        day %= 7;

        return week[day];
    }
}

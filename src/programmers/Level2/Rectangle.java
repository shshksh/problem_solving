package programmers.Level2;

public class Rectangle {
    public static long solution(int w, int h) {
        long sum = 0;
        for (int i = 0; i < w; i++) {
            sum += h-yPosition(w,h,i);
        }
        return sum*2;
    }

    private static int yPosition(int w, int h, int i) {
        return (int)Math.ceil((-1.0*i)*h/w)+h;
    }
}
package programers.bruteForce;

public class Carpet {
    public static int[] solution(int brown, int red) {
        int[] answer = new int[2];
        int size = brown + red;

        for (int i = 3; i<size; i++) {
            if(size % i == 0) {
                int row = i, col = size/i;
                if((row-2) * (col-2) == red) {
                    answer[0] = col;
                    answer[1] = row;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] t = solution(24,24);
        for (int i : t) {
            System.out.println(i);
        }
    }
}

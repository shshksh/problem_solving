package programmers.Level1;

public class DartGame {
    public static int solution(String dartResult) {
        int[] score = new int[3];
        int buffer = 0, index = 0;
        for (int i = 0; i < dartResult.length(); i++) {
            char currentLetter = dartResult.charAt(i);
            if (Character.isDigit(currentLetter)) {
                buffer *= 10;
                buffer += (currentLetter-'0');
            } else if (Character.isLetter(currentLetter)) {
                if (currentLetter == 'D') {
                    buffer = (int)Math.pow(buffer, 2);
                } else if (currentLetter == 'T') {
                    buffer = (int)Math.pow(buffer, 3);
                }
                score[index++] = buffer;
                buffer = 0;
            } else {
                if(currentLetter == '*') {
                    score[index-1] *=2;
                    if(index -1 > 0)
                        score[index-2] *=2;
                } else if (currentLetter == '#') {
                    score[index-1] *= -1;
                }
            }

        }
        return score[0] + score[1] + score[2];
    }

    public static void main(String[] args) {
        System.out.println(solution("1D2S#10S"));
    }
}
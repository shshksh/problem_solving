package programmers.bruteForce;

import java.util.ArrayList;
import java.util.List;

public class MockTest {

    static class Student {

        public Student(int[] solve) {
            this.solve = solve;
        }

        int[] solve;
        int score;
    }

    public static int[] solution(int[] answers) {

        Student st1 = new Student(new int[] {1,2,3,4,5});
        Student st2 = new Student(new int[] {2,1,2,3,2,4,2,5});
        Student st3 = new Student(new int[] {3,3,1,1,2,2,4,4,5,5});

        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == st1.solve[i%st1.solve.length])
                st1.score++;
            if(answers[i] == st2.solve[i%st2.solve.length])
                st2.score++;
            if(answers[i] == st3.solve[i%st3.solve.length])
                st3.score++;
        }
        int maxScore = Math.max(st1.score, st2.score);
        maxScore = Math.max(maxScore, st3.score);

        List<Integer> list = new ArrayList<>();
        if(st1.score == maxScore)
            list.add(1);
        if(st2.score == maxScore)
            list.add(2);
        if(st3.score == maxScore)
            list.add(3);

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] best = solution(new int[] {1,3,2,4,2});
        for (int i : best) {
            System.out.println(i);
        }
    }
}

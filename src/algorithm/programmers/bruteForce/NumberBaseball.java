package algorithm.programmers.bruteForce;

public class NumberBaseball {
    public static int solution(int[][] baseball) {
        int answer = 0;
        for (int i = 123; i < 988; i++)
            if (isAllMatch(i, baseball))
                answer++;

        return answer;
    }

    private static boolean isAllMatch(int i, int[][] baseball) {
        int[] flag = new int[10];
        for (int j = i; j > 0 ; j/=10) {
            if(j%10 == 0)
                return false;
            if(flag[j%10] == 0)
                flag[j%10]++;
            else
                return false;
        }
        for (int[] query : baseball)
            if (!isMatch(i, query))
                return false;
        return true;
    }

    private static boolean isMatch(int number, int[] query) {
        int scnt = 0, bcnt = 0;
        int[] flag = new int[10];
        for (int i = query[0]; i > 0; i/=10) {
            flag[i%10]++;
        }

        for (int i = number, j = query[0]; i > 0 && j>0; i/=10, j/=10) {
            if(i%10 == j%10) {
                scnt++;
            } else if(flag[i%10] != 0)
                bcnt++;
        }

        if(scnt != query[1] || bcnt != query[2])
            return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{123,1,1}, {356,1,0}, {327,2,0}, {489,0,1}}));
    }
}

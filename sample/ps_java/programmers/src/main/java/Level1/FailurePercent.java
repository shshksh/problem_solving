package Level1;

import java.util.Arrays;

public class FailurePercent {
    public int[] solution(int N, int[] stages) {
        int userNum = stages.length;
        data[] arr = new data[N + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new data(i);
        }
        for (int i = 0; i < stages.length; i++) {
            if (stages[i] <= N)
                arr[stages[i]].user++;
        }
        for (int i = 1; i < arr.length; i++) {
            arr[i].user += arr[i - 1].user;
            arr[i].failure = fp(arr, i, userNum);
        }
        Arrays.sort(arr, (o1, o2) -> Double.compare(o2.failure, o1.failure));
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        int[] answer = new int[N];
        for (int i = 0, j = 0; i < answer.length; i++, j++) {
            if (arr[j].stageNum == 0)
                j++;
            answer[i] = arr[j].stageNum;
        }
        return answer;
    }

    public double fp(data[] arr, int index, int k) {
        double result =
                (double) (arr[index].user - arr[index - 1].user) / (k - arr[index - 1].user);
        if (Double.isNaN(result))
            return 0;
        return result;
    }

    class data {
        int user;
        int stageNum;
        double failure;

        public data(int stageNum) {
            this.stageNum = stageNum;
        }

        @Override
        public String toString() {
            return "data{" +
                    "user=" + user +
                    ", stageNum=" + stageNum +
                    ", failure=" + failure +
                    '}';
        }
    }

}

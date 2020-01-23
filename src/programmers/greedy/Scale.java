package programmers.greedy;

import java.util.Arrays;

public class Scale {
     /*   public static int solution(int[] weight) {
        int answer = 1;
        Arrays.sort(weight);
        if(weight[0] > 1)
            return 1;

        while(true) {
            int target = answer;
            int floorIndex;
            if(target >= weight[weight.length-1])
                floorIndex = weight.length-1;
            else
                floorIndex = binaryFloor(weight, 0, weight.length/2, weight.length, answer, weight.length-1);

            while(floorIndex >=0) {
                if(weight[floorIndex] <= target)
                    target-=weight[floorIndex];
                floorIndex--;
            }
            if(target>0)
                break;

            answer++;
        }
        return answer;
    }

    private static int binaryFloor(int[] weight, int start, int mid, int end, int key, int max) {
        if (start > max)
            return weight.length-1;
        if (start > end)
            return start-1;
        if (weight[mid] > key)
            end = mid - 1;
        else if (weight[mid] <= key)
            start = mid + 1;
        return binaryFloor(weight, start, (start+end)/2, end, key, max);
    }
*/

    public static int solution(int[] weight) {
        Arrays.sort(weight);
        long[] arr= new long[weight.length];
        if(weight[0] > 1)
            return 1;
        arr[0] = weight[0];
        for (int i = 1; i < weight.length; i++) {
            if(weight[i] > arr[i-1]+1)
                return (int) (arr[i-1]+1);
            arr[i] = arr[i-1]+weight[i];
        }
        return (int)arr[arr.length-1]+1;
    }
}

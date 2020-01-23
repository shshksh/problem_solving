package programmers.sort;

import java.util.Arrays;

public class H_Index {
    public static int solution(int[] citations) {
        int answer = 0, index = 0;
        Arrays.sort(citations);

        for (int i = 1; i <= citations.length; i++) {
            index = floor(citations, 0, citations.length/2, citations.length-1, i, citations.length-1);
            if(index < 0)
                break;
            if(citations.length-index >= i)
                answer = i;
        }

        return answer;
    }

    static int floor(int data[], int start, int mid, int end, int k, int max)
    {
        if (start > max)
            return -1;
        if (start > end)
            return start;
        if (data[mid] > k)
            end = mid - 1;
        else if (data[mid] < k)
            start = mid + 1;
        else
            return mid;
        return floor(data, start, (start+end)/2, end, k, max);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {3,0,6,1,5}));
    }
}

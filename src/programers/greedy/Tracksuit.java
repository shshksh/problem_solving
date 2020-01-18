package programers.greedy;

public class Tracksuit {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] suitCnt = new int[n];
        int i = 0, j = 0;
        for (; i < lost.length && j < reserve.length; i++, j++) {
            suitCnt[lost[i]-1]--;
            suitCnt[reserve[j]-1]++;
        }
        while(i<lost.length) {
            suitCnt[lost[i]-1]--;
            i++;
        }
        while(j<reserve.length) {
            suitCnt[reserve[j]-1]++;
            j++;
        }
        for (int k = 0; k < suitCnt.length; k++) {
            if(suitCnt[k] < 0) {
                if(k!=0 && suitCnt[k-1] > 0){
                    suitCnt[k-1]--;
                } else if (k!=suitCnt.length-1 && suitCnt[k+1] > 0) {
                    suitCnt[k+1]--;
                } else {
                    answer--;
                }
            }
        }
        return answer;
    }
}

package algorithm.programmers.heap;

import java.util.PriorityQueue;

public class spicy {
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville)
            pq.offer(i);
        while(pq.size() > 1 && pq.peek() < K){
            answer++;
            pq.offer(pq.poll() + pq.poll()*2);
        }
        return pq.peek() < K ? -1 : answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1,2,3,9,10,12}, 7));
    }
}

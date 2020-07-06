package algorithm.programmers.stack_queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Develope {
    public static int[] solution(int[] progresses, int[] speeds) {
        int days = 0, sequence = 0;
        
        Queue<Integer> work = new LinkedList<Integer>();
        ArrayList<Integer> tmp = new ArrayList<>();
        for (int i : progresses) {
			work.offer(i);
		}
        
        while(!work.isEmpty()) {
        	days++;
        	int num = 0;
        	for (int i = sequence; i < speeds.length; i++) {
				if(work.peek() + speeds[i]*days >= 100) {
					sequence++;
					num++;
					work.poll();
				} else {
					break;
				}
			}
        	if(num != 0) {
        		tmp.add(num);
        	}
        }
        
        int[] answer = new int[tmp.size()];
        
        for (int i = 0; i < answer.length; i++) {
			answer[i] = tmp.get(i);
		}
        
        return answer;
    }
    
    public static void main(String[] args) {
		int[] rst = solution(new int[] {93, 30, 55}, new int[] {1, 30, 5});
		for (int i : rst) {
			System.out.println(i);
		}
	}
}

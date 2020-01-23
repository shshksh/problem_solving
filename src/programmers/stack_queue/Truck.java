package programmers.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class Truck {
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		int present_weight = 0, input_number = 0, output_number = 0;

		Queue<Integer> bridge = new LinkedList<>();

		while (true) {
			answer++;
			if(!bridge.isEmpty()) 
				if(bridge.peek() == answer) {
					bridge.poll();
					present_weight -= truck_weights[output_number++];
				}

			if(input_number < truck_weights.length)
				if(present_weight + truck_weights[input_number] <= weight) {
					bridge.offer(answer+bridge_length); // 현재 다리 하중이 충분할 때 다리에 트럭 가용 시간 추가
					present_weight += truck_weights[input_number++]; 
				}

			if(bridge.isEmpty())
				break;
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(100, 100, new int[] {10,10,10,10,10,10,10,10,10,10}));
	}
}

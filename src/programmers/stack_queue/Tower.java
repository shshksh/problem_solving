package programmers.stack_queue;

public class Tower {
    public static int[] solution(int[] heights) {
    	int[] answer = new int[heights.length];
    	answer[0] = 0;
    	for	(int i = 0; i < heights.length; i++) {
    		int j = i-1;
    		for (; j >= 0; j--) {
				if(heights[i]<heights[j]) {
					answer[i] = j+1;
					break;
				}
			}
    		if(j==-1)
    			answer[i] = 0;
    	}
    	
    	return answer;
    }
    
    public static void main(String[] args) {
    	for (int i : solution(new int[] {1,5,3,6,7,6,5})) {
			System.out.print(i+" ");
		}
	}
}

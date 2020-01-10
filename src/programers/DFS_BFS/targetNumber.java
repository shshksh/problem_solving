package programers.DFS_BFS;

public class targetNumber {
    static int cnt = 0;
    public static int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return cnt;
    }

    private static void dfs(int[] numbers, int index, int target, int sum) {
        if(index == numbers.length) {
            if(target == sum)
                cnt++;
            return;
        }
        dfs(numbers, index+1, target, sum+numbers[index]);
        dfs(numbers, index+1, target, sum-numbers[index]);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1,1,1,1,1}, 3));
    }
}

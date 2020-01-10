package programers.DFS_BFS;


import java.util.Arrays;

//backtracking
public class TravelPath {
    public static String[] solution(String[][] tickets) {
        int[] path = new int[tickets.length];
        int[] answer = new int[tickets.length];
        Arrays.fill(answer, -1);

        for (int i = 0; i < tickets.length; i++) {
            findPath(tickets, i, path, 0, answer);
        }

        String[] strArr = new String[tickets.length+1];
        strArr[0] = "ICN";
        for (int i = 0; i < answer.length; i++) {
            strArr[i+1] = tickets[answer[i]][1];
        }

        return strArr;
    }

    private static void findPath(String[][] tickets, int i, int[] path, int j, int[] answer) {
        if(!isValid(tickets, i, path, j))
            return;
        path[j] = i;
        if(j==tickets.length-1) {
            if(compare(path, answer, tickets) < 0)
                for (int k = 0; k < path.length; k++)
                    answer[k] = path[k];
            return;
        }
        for (int k = 0; k < tickets.length; k++) {
            findPath(tickets, k, path, j+1, answer);
        }
    }

    private static boolean isValid(String[][] tickets, int i, int[] path, int j) {
        for (int k = 0; k < j; k++) {
            if (path[k] == i)
                return false;
        }
        if(j==0) {
            if (!tickets[i][0].equals("ICN"))
                return false;
            return true;
        }

        return tickets[i][0].equals(tickets[path[j-1]][1]);
    }

    private static int compare(int[] path, int[] answer, String[][] tickets) {
        for (int i = 0; i < path.length; i++) {
            if(answer[i] == -1 || tickets[path[i]][1].compareTo(tickets[answer[i]][1]) < 0)
                return -1;
            else if (tickets[path[i]][1].compareTo(tickets[answer[i]][1]) > 0)
                return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[][]{
//                {"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}
                {"ICN", "ATL"}, {"ICN", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}
        })));
    }
}

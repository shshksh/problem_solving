package programmers.Level2;

public class MostBiggestSquare
{
    public static int solution(int[][] board)
    {
        int answer = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 1 && Math.pow(Math.min(board.length-i, board[0].length-j), 2) > answer)
                    answer = Math.max(answer, squareOf(board, i, j));
            }
        }
        return answer;
    }

    private static int squareOf(int[][] board, int i, int j) {
        int length = 1;
        while(i + length < board.length && j + length < board[0].length) {
            for (int p = i, q = j+length; p <= i+length; p++) {
                if(board[p][q] == 0)
                    return length*length;
            }
            for (int p = i+length, q = j; q <= j+length; q++) {
                if(board[p][q] == 0)
                    return length*length;
            }
            length++;
        }
        return length*length;
    }

    public static void main(String[] args) {
        int[][] arr = new int[1000][1000];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = 1;
            }
        }
        arr[1][1] = 0;
        System.out.println(solution(arr));
    }
}
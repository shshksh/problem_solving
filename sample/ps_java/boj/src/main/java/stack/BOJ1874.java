package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> st = new Stack<>();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 1, j = 0; i <= n; i++) {
            st.push(i);
            sb.append("+\n");
            if (st.peek() == arr[j]) {
                while (!st.isEmpty() && st.peek() == arr[j]) {
                    st.pop();
                    sb.append("-\n");
                    j++;
                }
            }
        }

        if (st.isEmpty())
            System.out.println(sb.toString());
        else
            System.out.println("NO");
    }
}

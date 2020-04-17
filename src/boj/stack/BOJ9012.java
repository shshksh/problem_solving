package boj.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            if(isVPS(br))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    private static boolean isVPS(BufferedReader br) throws IOException {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(br.readLine());
        for (int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == '(')
                stack.push(1);
            else if (sb.charAt(i)==')')
                if(stack.isEmpty())
                    return false;
                else
                    stack.pop();
        }
        return stack.isEmpty();
    }
}
package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        while (!line.equals(".")) {
            if (isBalance(line))
                System.out.println("yes");
            else
                System.out.println("no");
            line = br.readLine();
        }
    }

    private static boolean isBalance(String line) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(line);

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            switch (c) {
                case '[':
                    stack.push(1);
                    break;
                case '(':
                    stack.push(2);
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != 1)
                        return false;
                    stack.pop();
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != 2)
                        return false;
                    stack.pop();
                    break;
            }
        }
        return stack.isEmpty();
    }
}

package sort;

import java.io.*;
import java.util.Arrays;

public class BOJ10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Member[] arr = new Member[n];
        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split(" ");
            arr[i] = new Member(Integer.parseInt(tmp[0]), tmp[1], i);
        }
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            bw.write(arr[i].toString());
        }
        bw.flush();
    }

    static class Member implements Comparable<Member> {
        int age;
        String name;
        int index;

        public Member(int age, String name, int index) {
            this.age = age;
            this.name = name;
            this.index = index;
        }

        @Override
        public String toString() {
            return age + " " + name + "\n";
        }

        @Override
        public int compareTo(Member o) {
            if (age == o.age)
                return index - o.index;
            return age - o.age;
        }
    }
}

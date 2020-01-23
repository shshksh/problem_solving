package programmers.heap;

import java.util.ArrayList;
import java.util.List;

public class Factory {
    static class s implements Comparable<s>{
        int date;
        int supply;

        public s(int date, int supply) {
            this.date = date;
            this.supply = supply;
        }

        @Override
        public int compareTo(s o) {
            return Integer.compare(o.supply, supply);
        }
    }
    public static int solution(int stock, int[] dates, int[] supplies, int k) {
        List<s> list = new ArrayList<>();
        for (int i = 0; i < dates.length; i++) {
            list.add(new s(dates[i], supplies[i]));
        }
        list.sort(s::compareTo);

        int cnt = 0;
        while (stock < k) {
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i).date <= stock) {
                    stock+=list.get(i).supply;
                    cnt++;
                    list.remove(i);
                    break;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(solution(4, new int[] {4, 10, 15}, new int[] {20, 5, 10}, 30));
    }
}

package programers.hash;

import java.util.*;

public class BestAlbum {
    public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer[]> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            if(!map.containsKey(genres[i])) {
                map.put(genres[i], new Integer[] {i,null});
            } else {
                Integer[] tmp = map.get(genres[i]);
                if(plays[i] > plays[tmp[0]]) {
                    tmp[1] = tmp[0];
                    tmp[0] = i;
                    map.put(genres[i], tmp);
                } else if (tmp[1] == null || plays[i] > plays[tmp[1]]) {
                    tmp[1] = i;
                    map.put(genres[i], tmp);
                }
            }
        }

        List<Integer[]> list = new ArrayList<>();
        list.addAll(map.values());
        list.sort((o1, o2) -> sum(plays,o2)-sum(plays,o1));

        List<Integer> li = new ArrayList<>();
        for (Integer[] integers : list) {
            for (Integer integer : integers) {
                if(integer != null)
                    li.add(integer);
            }
        }

        int answer[] = new int[li.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = li.get(i);
        }

        return answer;
    }

    private static int sum(int[] plays, Integer[] o) {
        if(o[1] == null)
            return plays[o[0]];
        return plays[o[0]]+plays[o[1]];
    }

    public static void main(String[] args) {
        for (int i : solution(new String[]{"classic", "pop", "classic", "classic", "pop", "edm", "edm"}, new int[]{500, 600, 150, 800, 2500, 800, 700})) {
            System.out.println(i);
        }
    }
}

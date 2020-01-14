package programers.hash;

import java.util.*;

public class BestAlbum {
    public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer[]> map = new HashMap<>(100);
        for (int i = 0; i < genres.length; i++) {
            if(!map.containsKey(genres[i])) {
                map.put(genres[i], new Integer[] {i, null, plays[i]}); // size: 1
            } else {
                Integer[] tmp = map.get(genres[i]);
                tmp[2] += plays[i];
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
        list.sort((o1, o2) -> o2[2]-o1[2]);

        List<Integer> li = new ArrayList<>();
        for (Integer[] integers : list) {
            for (int i = 0; i < integers.length-1; i++) {
                if(integers[i] != null)
                    li.add(integers[i]);
            }
        }

        int answer[] = new int[li.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = li.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        for (int i : solution(new String[]{"classic", "pop", "classic", "classic", "pop", "edm", "edm"}, new int[]{500, 600, 150, 800, 2500, 800, 700})) {
            System.out.println(i);
        }
    }
}

/*
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
  public class Music implements Comparable<Music>{

    private int played;
    private int id;
    private String genre;

    public Music(String genre, int played, int id) {
      this.genre = genre;
      this.played = played;
      this.id = id;
    }

    @Override
    public int compareTo(Music other) {
      if(this.played == other.played) return this.id - other.id;
      return other.played - this.played;
    }

    public String getGenre() {return genre;}
  }

  public int[] solution(String[] genres, int[] plays) {
    return IntStream.range(0, genres.length)
    .mapToObj(i -> new Music(genres[i], plays[i], i))
    .collect(Collectors.groupingBy(Music::getGenre))
    .entrySet().stream()
    .sorted((a, b) -> sum(b.getValue()) - sum(a.getValue()))
    .flatMap(x->x.getValue().stream().sorted().limit(2))
    .mapToInt(x->x.id).toArray();
  }

  private int sum(List<Music> value) {
    int answer = 0;
    for (Music music : value) {
      answer+=music.played;
    }
    return answer;
  }
}
스트림을 사용한 풀이, 퍼포먼스는 10배정도 느리다.
 */

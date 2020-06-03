package algorithm_2020.pa11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class AreaFile {

    private HashMap<String, Area> AreaMap = new HashMap<>();

    public AreaFile() {
        init();
    }

    private void init() {
        try {
            addToMap();
            connectEdges();
        } catch (FileNotFoundException | CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println("Successfully connect all edges.");
    }

    private void addToMap() throws FileNotFoundException {
        String path = "algorithm/src/algorithm_2020/res/" + "alabama.txt";
        File file = new File(path);

        Scanner fileScanner = new Scanner(file);

        while (fileScanner.hasNextLine()) {
            String[] line = fileScanner.nextLine().split("\t");
            AreaMap.put(line[0], new Area(line[0], Double.parseDouble(line[1]), Double.parseDouble(line[2])));
        }
    }

    private void connectEdges() throws CloneNotSupportedException, FileNotFoundException {
        String path = "algorithm/src/algorithm_2020/res/" + "roadList2.txt";
        File file = new File(path);

        Scanner fileScanner = new Scanner(file);

        while (fileScanner.hasNextLine()) {
            String[] line = fileScanner.nextLine().split("\t");
            connect(AreaMap.get(line[0]), (Area) AreaMap.get(line[1]).clone());
            connect(AreaMap.get(line[1]), (Area) AreaMap.get(line[0]).clone());
        }
    }

    private void connect(Area header, Area target) {
        target.next = header.next;
        header.next = target;
        target.weigh = calDistance(header.latitude, header.longitude, target.latitude, target.longitude);
    }

    private double calDistance(double lat1, double lon1, double lat2, double lon2) {
        double theta, dist;
        theta = lon1 - lon2;
        dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
                + Math.cos(deg2rad(lat1))
                * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344; // 단위 mile 에서 km 변환.
        dist = dist * 1000.0; // 단위 km 에서 m 로 변환
        return dist;
    }

    private double deg2rad(double deg) {
        return deg * Math.PI / (double) 180;
    }

    private double rad2deg(double rad) {
        return rad * (double) 180 / Math.PI;
    }

    public void closeOf(String areaName) {
        if (!AreaMap.containsKey(areaName)) {
            System.out.println("Type as \"$ [command] [area name]\"");
            return;
        }

        HashMap<String, Boolean> hashChk = new HashMap<>();
        Queue<Area> q = new LinkedList<>();
        q.offer(AreaMap.get(areaName));
        hashChk.put(areaName, true);

        int t = 0;
        while (!q.isEmpty() && t <= 10) {
            int size = q.size();
            System.out.println("Hop " + t + ":");
            for (int i = 0; i < size; i++) {
                Area target = q.poll();
                System.out.println(target);
                offerAllAdjacentLocationOf(q, target, hashChk);
            }
            t++;
        }
    }

    private void offerAllAdjacentLocationOf(Queue<Area> q, Area target, HashMap<String, Boolean> hashChk) {
        while (target != null) {
            if (!hashChk.containsKey(target.name)) {
                q.offer(AreaMap.get(target.name));
                hashChk.put(target.name, true);
            }
            target = target.next;
        }
    }

    public void traversalOf(String areaName) {
        if (!AreaMap.containsKey(areaName)) {
            System.out.println("Type as \"$ [command] [area name]\"");
            return;
        }
        HashMap<String, Boolean> hashChk = new HashMap<>();
        System.out.println("Graph traversal:");
        DFS(AreaMap.get(areaName), hashChk);
    }

    private void DFS(Area start, HashMap<String, Boolean> hashChk) {
        System.out.println(start);
        hashChk.put(start.name, true);
        while (start != null) {
            if (!hashChk.containsKey(start.name)) {
                DFS(AreaMap.get(start.name), hashChk);
            }
            start = start.next;
        }
    }

    public void pathOf(String src, String dst) {
        if (!(AreaMap.containsKey(src) && AreaMap.containsKey(dst))) {
            System.out.println("Wrong Area");
            return;
        }
        HashMap<String, Area> chosen = shortestPathOf(AreaMap.get(src));
        printPath(chosen, dst);
    }

    private HashMap<String, Area> shortestPathOf(Area src) {
        HashMap<String, Area> chosen = new HashMap<>();
        PriorityQueue<Area> q = new PriorityQueue<>(Comparator.comparingDouble(o -> o.weigh));
        initialize(chosen, q, src);

        for (int i = 0; i < AreaMap.size() - 1; i++) {
            Area added = nextAreaOf(chosen, q);
            chosen.put(added.name, added);
            updateWeigh(chosen, q, added);
        }
        return chosen;
    }

    private void initialize(HashMap<String, Area> chosen, PriorityQueue<Area> q, Area src) {
        chosen.put(src.name, src);
        Area curr = AreaMap.get(src.name).next;
        while (curr != null) {
            if (!chosen.containsKey(curr.name)) {
                curr.prev = src;
                q.offer(curr);
                curr = curr.next;
            }
        }
    }

    private Area nextAreaOf(HashMap<String, Area> chosen, PriorityQueue<Area> q) {
        while (!q.isEmpty() && chosen.containsKey(q.peek().name))
            q.poll();
        return q.poll();
    }

    private void updateWeigh(HashMap<String, Area> chosen, PriorityQueue<Area> q, Area added) {
        Area adjacentArea = AreaMap.get(added.name).next;
        while (adjacentArea != null) {
            if (!chosen.containsKey(adjacentArea.name)) {
                adjacentArea.weigh += added.weigh;
                adjacentArea.prev = added;
                q.offer(adjacentArea);
            }
            adjacentArea = adjacentArea.next;
        }
    }

    private void printPath(HashMap<String, Area> chosen, String dst) {
        Area curr = chosen.get(dst);

        Stack<String> stack = new Stack<>();
        while (curr != null) {
            stack.push(curr.name);
            curr = curr.prev;
        }

        System.out.println("path size: " + (stack.size() - 1));
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}

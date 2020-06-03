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
        if(!(AreaMap.containsKey(src) && AreaMap.containsKey(dst))) {
            System.out.println("Wrong Area");
            return;
        }
        ArrayList<Area> result = shortestPathOf(AreaMap.get(src));
        printPath(result, AreaMap.get(dst));
    }

    private ArrayList<Area> shortestPathOf(Area src) {
        HashMap<String, Boolean> set = new HashMap<>();
        ArrayList<Area> adjList = new ArrayList<>();
        initialize(set ,adjList, src);

        while (set.size() != AreaMap.size()) {
            Area minimalWeigh = null;
            set.put(minimalWeigh.name, true);
            adjList.remove(minimalWeigh);
            updateWeigh(set, adjList, minimalWeigh);
        }
        return adjList;
    }

    private void initialize(HashMap<String, Boolean> set, ArrayList<Area> adjList, Area src) {
        set.put(src.name, true);
        Area curr = src.next;
        while (curr != null) {
            adjList.add(curr);
            curr.prev = src;
            curr = curr.next;
        }
    }

    private void updateWeigh(HashMap<String, Boolean> set, ArrayList<Area> list, Area added) {
        Area target = AreaMap.get(added.name);
        Area curr = target.next;
        while (curr != null) {
            if (!set.containsKey(curr.name)) {
                int index = getIndex(list, curr.name);
                if (index >= 0) {
                    double existingWeigh = list.get(index).weigh;
                    if (existingWeigh > added.weigh + curr.weigh) {
                        list.get(index).weigh = added.weigh+curr.weigh;
                        list.get(index).prev = target;
                    }
                } else {
                    list.add(curr);
                    curr.weigh += added.weigh;
                    curr.prev = target;
                }
            }
            curr = curr.next;
        }
    }

    private int getIndex(ArrayList<Area> list, String curr) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(1).name.equals(curr))
                return i;
        }
        return -1;
    }

    private void printPath(ArrayList<Area> list, Area dst) {
        Area curr = null;
        for (Area area : list) {
            if(area.name.equals(dst.name)) {
                curr = area;
                break;
            }
        }

        Stack<String> stack = new Stack<>();
        while (curr != null) {
            stack.push(curr.name);
            curr = curr.prev;
        }

        System.out.println("path size: " + (stack.size()-1));
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}

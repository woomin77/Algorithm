package bfs;

import java.util.ArrayList;
import java.util.HashMap;

public class Bfs {

    public void solution(HashMap<String, ArrayList<String>> graph, String data) {

        ArrayList<String> visited = new ArrayList<>();
        ArrayList<String> needVisit = new ArrayList<>();

        needVisit.add(data);


        while (needVisit.size() > 0) {

            String removeData = needVisit.remove(0);

            if (!visited.contains(removeData)) {
                visited.add(removeData);
                needVisit.addAll(graph.get(removeData));
            }
        }

        System.out.println(visited);

    }
}

package dikjstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DijkstraPath {

    public HashMap<String, Integer> solution(HashMap<String, ArrayList<Edge>> graph, String start) {

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        HashMap<String, Integer> distanceMap = new HashMap<>();
        String currentVertex, adjacentVertex;
        int currentWeight, adjacentWeight, totalWeight;

        for (String key : graph.keySet()) {
            distanceMap.put(key, Integer.MAX_VALUE);
        }

        distanceMap.put(start, 0);
        pq.add(new Edge(start, distanceMap.get(start)));

        while (pq.size() > 0) {

            Edge edge = pq.poll();
            currentVertex = edge.vertex;
            currentWeight = edge.weight;

            if (distanceMap.get(currentVertex) < currentWeight) {
                continue;
            }

            ArrayList<Edge> nodeList = graph.get(currentVertex);
            for (int i = 0; i < nodeList.size(); i++) {
                adjacentVertex = nodeList.get(i).vertex;
                adjacentWeight = nodeList.get(i).weight;

                totalWeight = adjacentWeight + currentWeight;

                if (totalWeight < distanceMap.get(adjacentVertex)) {
                    distanceMap.put(adjacentVertex, totalWeight);
                    pq.add(new Edge(adjacentVertex, totalWeight));
                }

            }

        }

        return distanceMap;
    }
}

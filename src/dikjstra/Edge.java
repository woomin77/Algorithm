package dikjstra;

public class Edge implements Comparable<Edge> {

    String vertex;
    int weight;

    public Edge(String vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "vertex='" + vertex + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Edge edge) {
        return this.weight - edge.weight;
    }


}

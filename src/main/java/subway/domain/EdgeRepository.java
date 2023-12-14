package subway.domain;

import java.util.*;

public class EdgeRepository {
    private static final List<Edge> edges = new ArrayList<>();

    public static List<Edge> edges() {
        return Collections.unmodifiableList(edges);
    }

    static {
        addEdge(new Edge("gyodae", "namteo", 3, 2));
        addEdge(new Edge("gyodae", "gangnam", 2, 3));
        addEdge(new Edge("namteo", "yangjae", 6, 5));
        addEdge(new Edge("gangnam", "yangjae", 2, 8));
        addEdge(new Edge("yangjae", "maebong", 1, 1));
        addEdge(new Edge("gangnam", "yeoksam", 2, 3));
        addEdge(new Edge("yangjae", "yangsoup", 10, 3));
    }

    public static void addEdge(Edge edge) {
        edges.add(edge);
    }

    public static boolean deleteEdgeByVertices(String vertex1, String vertex2) {
        return edges.removeIf(edge -> edge.getVertex1().equals(vertex1) && edge.getVertex2().equals(vertex2));
    }

    public static void deleteAll() {
        edges.clear();
    }

    public static Edge findEdgeByVertices(String vertex1, String vertex2) {
        return edges.stream()
                .filter(edge -> edge.getVertex1().equals(vertex1) && edge.getVertex2().equals(vertex2))
                .findAny()
                .orElse(null);
    }
}
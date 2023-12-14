package subway.domain;

import java.util.*;

public class EdgeRepository {
    private static final List<Edge> edges = new ArrayList<>();

    public static List<Edge> edges() {
        return Collections.unmodifiableList(edges);
    }

    static {
        addEdge(new Edge("교대역", "남부터미널역", 3, 2));
        addEdge(new Edge("교대역", "강남역", 2, 3));
        addEdge(new Edge("남부터미널역", "양재역", 6, 5));
        addEdge(new Edge("강남역", "양재역", 2, 8));
        addEdge(new Edge("양재역", "매봉역", 1, 1));
        addEdge(new Edge("강남역", "역삼역", 2, 3));
        addEdge(new Edge("양재역", "양재시민의숲역", 10, 3));
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
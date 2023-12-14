package subway.controller;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class shortestPath {
    public void test() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph
                = new WeightedMultigraph(DefaultWeightedEdge.class);
        graph.addVertex("gyodae");
        graph.addVertex("namteo");
        graph.addVertex("yangjae");
        graph.addVertex("gangnam");
        graph.setEdgeWeight(graph.addEdge("gyodae", "namteo"), 3);
        graph.setEdgeWeight(graph.addEdge("namteo", "yangjae"), 6);
        graph.setEdgeWeight(graph.addEdge("gyodae", "gangnam"), 2);
        graph.setEdgeWeight(graph.addEdge("gangnam", "yangjae"), 2);


        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<String> shortestPath = dijkstraShortestPath.getPath("gyodae", "yangjae").getVertexList();
        System.out.println(shortestPath);
    }
}

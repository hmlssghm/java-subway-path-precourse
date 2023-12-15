package subway.controller;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Edge;
import subway.domain.EdgeRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.List;

public class ShortestPath {
    public WeightedMultigraph<String, DefaultWeightedEdge> mapByDistance() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph
                = new WeightedMultigraph(DefaultWeightedEdge.class);

        List<Station> stations = StationRepository.stations();
        stations.forEach(station -> {
            graph.addVertex(station.getName());
        });

        List<Edge> edges = EdgeRepository.edges();
        edges.forEach(edge -> {
            graph.setEdgeWeight(graph.addEdge(edge.getVertex1(), edge.getVertex2()), edge.getDistance());
        });

        return graph;
    }

    public WeightedMultigraph<String, DefaultWeightedEdge> mapByTime() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph
                = new WeightedMultigraph(DefaultWeightedEdge.class);

        List<Station> stations = StationRepository.stations();
        stations.forEach(station -> {
            graph.addVertex(station.getName());
        });

        List<Edge> edges = EdgeRepository.edges();
        edges.forEach(edge -> {
            graph.setEdgeWeight(graph.addEdge(edge.getVertex1(), edge.getVertex2()), edge.getTime());
        });

        return graph;
    }

    public void findPath(String vertex1, String vertex2, String answer) {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = null;
        if (answer.equals("1")){
            graph = mapByDistance();
        }
        else if (answer.equals("2")){
            graph = mapByTime();
        }

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<String> shortestPath = dijkstraShortestPath.getPath(vertex1, vertex2).getVertexList();
        System.out.println(shortestPath);
    }
}

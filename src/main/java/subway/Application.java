package subway;


import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.*;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        Edge edge = EdgeRepository.findEdgeByVertices("교대역","강남역");
        System.out.println(edge.getDistance());
    }
}
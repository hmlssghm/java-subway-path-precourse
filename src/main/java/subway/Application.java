package subway;


import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.controller.FunctionOperation;
import subway.controller.ShortestPath;
import subway.domain.*;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        FunctionOperation functionOperation = new FunctionOperation();
        functionOperation.operator();
    }
}
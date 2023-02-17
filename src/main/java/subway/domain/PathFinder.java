package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class PathFinder {
    private static final String SAME_STATION_ERROR = "출발역과 도착역이 동일합니다.";
    private final WeightedMultigraph<Station, DefaultWeightedEdge> distanceGraph
            = new WeightedMultigraph<>(DefaultWeightedEdge.class);

    private final WeightedMultigraph<Station, DefaultWeightedEdge> timeGraph
            = new WeightedMultigraph<>(DefaultWeightedEdge.class);

    public PathFinder(){
        initVertex();
        initEdge();
    }

    private void initVertex(){
        for(Station station : StationRepository.stations()){
            distanceGraph.addVertex(station);
            timeGraph.addVertex(station);
        }
    }

    private void initEdge(){
        for(Section section : SectionRepository.sections()){
            Station station1 = section.getStations().get(0);
            Station station2 = section.getStations().get(1);
            int distanceWeight = section.getCost().getDistance();
            int timeWeight = section.getCost().getRequiredTime();
            distanceGraph.setEdgeWeight(distanceGraph.addEdge(station1,station2), distanceWeight);
            distanceGraph.setEdgeWeight(distanceGraph.addEdge(station2,station1), distanceWeight);
            timeGraph.setEdgeWeight(timeGraph.addEdge(station1,station2), timeWeight);
            timeGraph.setEdgeWeight(timeGraph.addEdge(station2,station1), timeWeight);
        }
    }

    public List<Station> getShortestPathByDistance(Station start, Station end){
        validateStartAndEndStation(start,end);
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(distanceGraph);
        return dijkstraShortestPath.getPath(start,end).getVertexList();
    }

    public List<Station> getShortestPathByTime(Station start, Station end){
        validateStartAndEndStation(start,end);
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(timeGraph);
        return dijkstraShortestPath.getPath(start,end).getVertexList();
    }

    private void validateStartAndEndStation(Station start, Station end){
        if(start.equals(end)){
            throw new IllegalArgumentException(SAME_STATION_ERROR);
        }
    }
}

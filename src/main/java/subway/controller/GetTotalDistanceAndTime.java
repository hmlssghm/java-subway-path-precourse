package subway.controller;

import subway.domain.EdgeRepository;

import java.util.List;

public class GetTotalDistanceAndTime {
    public int getTotalDistance(List<String> path){
        int totalDistance = 0;
        for (int i = 0; i < path.size() - 1; i++){
            totalDistance += EdgeRepository.findEdgeByVertices(path.get(i), path.get(i + 1)).getDistance();
        }
        return totalDistance;
    }

    public int getTotalTime(List<String> path){
        int totalTime = 0;
        for (int i = 0; i < path.size() - 1; i++){
            totalTime += EdgeRepository.findEdgeByVertices(path.get(i), path.get(i + 1)).getTime();
        }
        return totalTime;
    }
}

package subway.controller;

import static subway.util.Repeat.repeat;

import subway.domain.PathCriteriaMenu;
import subway.domain.PathFinder;
import subway.domain.Section;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;
import java.util.List;

public class PathFinderController {
    private final InputView inputView;
    private final OutputView outputView;
    private final PathFinder pathFinder;

    public PathFinderController(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
        pathFinder = new PathFinder();
    }

    public void run(){
        PathCriteriaMenu menu = repeat(inputView::readPathCriteriaMenu);
        if(menu.equals(PathCriteriaMenu.SHORTEST_PATH)){
            checkShortestPathByDistance();
        }
        if(menu.equals(PathCriteriaMenu.MINIMUM_TIME)){
            checkShortestPathByTime();
        }
    }

    private void checkShortestPathByDistance(){
        Station start = StationRepository.findStation(inputView.readStartStation());
        Station end = StationRepository.findStation(inputView.readEndStation());
        List<Station> path = pathFinder.getShortestPathByDistance(start,end);
        checkTotalDistanceAndTime(path);
        outputView.printPathInfo(path);
    }

    private void checkShortestPathByTime(){
        Station start = StationRepository.findStation(inputView.readStartStation());
        Station end = StationRepository.findStation(inputView.readEndStation());
        List<Station> path = pathFinder.getShortestPathByTime(start,end);
        checkTotalDistanceAndTime(path);
        outputView.printPathInfo(path);
    }

    private void checkTotalDistanceAndTime(List<Station> path){
        int totalDistance = 0;
        int totalTime = 0;
        for(int i=0; i<path.size()-1; i++){
            Section section = SectionRepository.findSection(path.get(i),path.get(i+1));
            totalDistance += section.getCost().getDistance();
            totalTime += section.getCost().getRequiredTime();
        }
        outputView.printDistanceAndTimeInfo(totalDistance, totalTime);
    }
}

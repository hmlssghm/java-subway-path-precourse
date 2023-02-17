package subway.controller;

import static subway.util.Repeat.repeat;

import subway.domain.*;
import subway.view.InputView;
import subway.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final PathFinderController pathFinderController;

    public Controller(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
        initController();
        pathFinderController = new PathFinderController(inputView, outputView);
    }

    public void run(){
        while(true){
            if(MainMenu.QUIT.equals(repeat(inputView::readMainMenu))){
                break;
            };
            repeat(pathFinderController::run);
        }
    }

    private void initController(){
        initStation();
        initLine();
        initSection();
    }

    private void initStation(){
        for(InitStation initStation : InitStation.values()){
            StationRepository.addStation(new Station(initStation.getName()));
        }
    }

    public void initLine(){
        for(InitLine initLine : InitLine.values()){
            Line line = new Line(initLine.getName());
            for(InitStation initStation : initLine.getStations()){
                line.addStation(StationRepository.findStation(initStation.getName()));
            }
            LineRepository.addLine(line);
        }
    }

    public void initSection(){
        for(InitSection initSection : InitSection.values()){
            List<Station> stations = new ArrayList<>();
            for(InitStation initStation : initSection.getStations()){
                stations.add(StationRepository.findStation(initStation.getName()));
            }
            SectionRepository.addSection(new Section(stations, initSection.getCost()));
        }
    }
}

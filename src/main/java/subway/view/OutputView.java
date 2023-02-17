package subway.view;

import subway.domain.Station;

import java.util.List;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String INFO_PREFIX = "[INFO] ";
    private static final String INFO_LINE = "---";
    private static final String INFO_DISTANCE = "총 거리: %dkm";
    private static final String INFO_TIME = "총 소요 시간: %d분";

    public void printPathInfo( List<Station> path){
        System.out.println(INFO_PREFIX + INFO_LINE);
        for(Station station : path){
            System.out.println(INFO_PREFIX + station.getName());
        }
    }

    public void printDistanceAndTimeInfo(int totalDistance, int totalTime){
        System.out.println(INFO_PREFIX + INFO_LINE);
        System.out.println(INFO_PREFIX + String.format(INFO_DISTANCE, totalDistance));
        System.out.println(INFO_PREFIX + String.format(INFO_TIME, totalTime));
    }

    public static void printError(String message){
        System.out.println(ERROR_PREFIX+message);
    }
}

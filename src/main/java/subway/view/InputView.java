package subway.view;

import subway.domain.InitStation;
import subway.domain.MainMenu;
import subway.domain.PathCriteriaMenu;

import java.util.Scanner;

public class InputView {
    private static final String MAIN_MENU_MESSAGE = "## 메인 화면\n"
            + "1. 경로 조회\n"
            + "Q. 종료\n";

    private static final String SELECT_MENU_MESSAGE = "## 원하는 기능을 선택하세요.";

    private static final String SELECT_PATH_CRITERIA_MESSAGE =
            "## 경로 기준\n"
            + "1. 최단 거리\n"
            + "2. 최소 시간\n"
            + "B. 돌아가기\n";

    private static final String ASK_START_STATION_MESSAGE = "## 출발역을 입력하세요.";
    private static final String ASK_END_STATION_MESSAGE = "## 도착역을 입력하세요.";

    private Scanner scanner;
    public InputView(Scanner scanner){
        this.scanner = scanner;
    }

    public MainMenu readMainMenu(){
        System.out.println(MAIN_MENU_MESSAGE);
        System.out.println(SELECT_MENU_MESSAGE);
        return MainMenu.fromInput(scanner.nextLine().trim());
    }

    public PathCriteriaMenu readPathCriteriaMenu(){
        System.out.println(SELECT_PATH_CRITERIA_MESSAGE);
        System.out.println(SELECT_MENU_MESSAGE);
        return PathCriteriaMenu.fromInput(scanner.nextLine().trim());
    }

    public String readStartStation(){
        System.out.println(ASK_START_STATION_MESSAGE);
        return InitStation.fromInput(scanner.nextLine().trim()).getName();
    }

    public String readEndStation(){
        System.out.println(ASK_END_STATION_MESSAGE);
        return InitStation.fromInput(scanner.nextLine().trim()).getName();
    }
}

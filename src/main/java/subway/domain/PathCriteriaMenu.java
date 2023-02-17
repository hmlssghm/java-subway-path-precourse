package subway.domain;

import java.util.Arrays;

public enum PathCriteriaMenu {
    SHORTEST_PATH("최단 거리"),
    MINIMUM_TIME("최소 시간"),
    BACK("돌아가기");

    private static final String MENU_COMMAND_ERROR = "지원하지 않는 명령어입니다. 다시 입력해 주세요.";

    private final String command;

    PathCriteriaMenu(String command){
        this.command = command;
    }

    public static PathCriteriaMenu fromInput(String input){
        return Arrays.stream(values())
                .filter(command->command.getCommand().equals(input))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException(MENU_COMMAND_ERROR));
    }

    public String getCommand(){
        return command;
    }
}

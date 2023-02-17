package subway.domain;

import java.util.Arrays;

public enum MainMenu {
    INQUIRE_ROUTE("경로 조회"),
    QUIT("Q");

    private static final String MENU_COMMAND_ERROR = "지원하지 않는 명령어입니다. 다시 입력해 주세요.";

    private final String command;

    MainMenu(String command){
        this.command = command;
    }

    public static MainMenu fromInput(String input){
        return Arrays.stream(values())
                .filter(command->command.getCommand().equals(input))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException(MENU_COMMAND_ERROR));
    }

    public String getCommand(){
        return command;
    }
}

package subway.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum InitLine {
    TWO("2호선", List.of(InitStation.GYODAE, InitStation.GANGNAM, InitStation.YEOKSAM)),
    THREE("3호선", List.of(InitStation.GYODAE, InitStation.SOUTH_TERMINAL, InitStation.YANGJAE, InitStation.MAEBONG)),
    SHINBUNDANG("신분당선", List.of(InitStation.GANGNAM, InitStation.YANGJAE, InitStation.YANGJAE_CITIZEN_FOREST));

    private static final String LINE_NAME_ERROR = "등록되지 않은 호선 이름입니다. 다시 입력해 주세요.";

    private final String name;
    private final List<InitStation> stations;

    InitLine(String name, List<InitStation> stations){
        this.name = name;
        this.stations = stations;
    }

    public static InitLine fromInput(String input){
        return Arrays.stream(values())
                .filter(station->station.getName().equals(input))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException(LINE_NAME_ERROR));
    }

    public String getName(){
        return name;
    }

    public List<InitStation> getStations(){
        return Collections.unmodifiableList(stations);
    }
}

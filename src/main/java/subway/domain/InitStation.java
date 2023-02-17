package subway.domain;

import java.util.Arrays;

public enum InitStation {
    GYODAE("교대역"),
    GANGNAM("강남역"),
    YEOKSAM("역삼역"),
    SOUTH_TERMINAL("남부터미널역"),
    YANGJAE("양재역"),
    MAEBONG("매봉역"),
    YANGJAE_CITIZEN_FOREST("양재시민의숲역");

    private static final String STATION_NAME_ERROR = "등록되지 않은 역 이름입니다. 다시 입력해 주세요.";

    private final String name;

    InitStation(String name){
        this.name = name;
    }

    public static InitStation fromInput(String input){
        return Arrays.stream(values())
                .filter(station->station.getName().equals(input))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException(STATION_NAME_ERROR));
    }

    public String getName(){
        return name;
    }
}

package subway.domain;

import java.util.Arrays;
import java.util.List;

public enum InitSection {
    GYODAE_GANGNAM(InitStation.GYODAE, InitStation.GANGNAM, new Cost(2,3)),
    GANGNAM_YEOKSAM(InitStation.GANGNAM, InitStation.YEOKSAM, new Cost(2,3)),
    GYODAE_SOUTH_TERMINAL(InitStation.GYODAE, InitStation.SOUTH_TERMINAL, new Cost(3,2)),
    SOUTH_TERMINAL_YANGJAE(InitStation.SOUTH_TERMINAL, InitStation.YANGJAE, new Cost(6,5)),
    YANGJAE_MAEBONG(InitStation.YANGJAE, InitStation.MAEBONG, new Cost(1,1)),
    GANGNAM_YANGJAE(InitStation.GANGNAM, InitStation.YANGJAE, new Cost(2,8)),
    YANGJAE_YANGJAE_CITIZEN_FOREST(InitStation.YANGJAE, InitStation.YANGJAE_CITIZEN_FOREST,
            new Cost(10,3));

    private static final String NO_SECTION_ERROR = "등록되지 않은 구간입니다. 다시 입력해 주세요.";

    private final List<InitStation> stations;
    private final Cost cost;

    InitSection(InitStation startStation, InitStation endStation, Cost cost){
        this.stations = List.of(startStation, endStation);
        this.cost = cost;
    }

    public static Cost fromInput(String startStation, String endStation){
        return Arrays.stream(values())
                .filter(section->section.stations.contains(InitStation.fromInput(startStation)))
                .filter(section->section.stations.contains(InitStation.fromInput(endStation)))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException(NO_SECTION_ERROR))
                .getCost();
    }

    public List<InitStation> getStations(){
        return stations;
    }

    public Cost getCost(){
        return cost;
    }
}

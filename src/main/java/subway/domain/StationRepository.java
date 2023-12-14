package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    static {
        stations.add(new Station("gyodae"));
        stations.add(new Station("namteo"));
        stations.add(new Station("gangnam"));
        stations.add(new Station("yangjae"));
        stations.add(new Station("maebong"));
        stations.add(new Station("yeoksam"));
        stations.add(new Station("yangsoup"));
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void deleteAll() {
        stations.clear();
    }
}
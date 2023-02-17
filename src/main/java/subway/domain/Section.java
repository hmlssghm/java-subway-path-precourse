package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Section {
    private List<Station> stations;
    private Cost cost;

    public Section(List<Station> stations, Cost cost){
        this.stations = new ArrayList<>(stations);
        this.cost = cost;
    }

    public boolean contains(Station station){
        return stations.contains(station);
    }

    public List<Station> getStations() {
        return stations;
    }

    public Cost getCost() {
        return cost;
    }
}

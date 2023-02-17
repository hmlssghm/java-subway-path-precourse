package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SectionRepository {
    private static final String DOES_NOT_HAVE_A_SUCH_SECTION_ERROR = "해당하는 구간이 존재하지 않습니다.";
    private static final List<Section> sections = new ArrayList<>();

    public static List<Section> sections() {
        return Collections.unmodifiableList(sections);
    }

    public static void addSection(Section section) {
        sections.add(section);
    }

    public static boolean deleteSection(Station startStation, Station endStation) {
        List<Station> stations = List.of(startStation, endStation);
        return sections.removeIf(section -> Objects.equals(section.getStations(), stations));
    }

    public static void deleteAll() {
        sections.clear();
    }

    public static Section findSection(Station startStation, Station endStation) {
        return sections.stream()
                .filter(section->section.getStations().contains(startStation))
                .filter(section->section.getStations().contains(endStation))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException(DOES_NOT_HAVE_A_SUCH_SECTION_ERROR));
    }
}

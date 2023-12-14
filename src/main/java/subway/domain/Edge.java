package subway.domain;

public class Edge {
    private final String vertex1;
    private final String vertex2;

    private final int distance;
    private final int time;

    public Edge(String vertex1, String vertex2, int distance, int time) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.distance = distance;
        this.time = time;
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }

    public String getVertex1() {
        return vertex1;
    }

    public String getVertex2() {
        return vertex2;
    }
}
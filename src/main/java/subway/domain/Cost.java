package subway.domain;

public class Cost {
    final int distance;
    final int requiredTime;

    public Cost(int distance, int requiredTime){
        this.distance = distance;
        this.requiredTime = requiredTime;
    }

    public int getDistance() {
        return distance;
    }

    public int getRequiredTime() {
        return requiredTime;
    }
}

package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.Objects;

public class FunctionOperation {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    ShortestPath shortestPath = new ShortestPath();

    public void operator() {
        Boolean firstFlag = true;
        while (true) {
            String answer = main(firstFlag);
            firstFlag = false;
            if (answer.equals("Q")) {
                break;
            }

            String gotCriteria = criteria();// "1": 최단 거리, "2": 최소 시간
            if (gotCriteria.equals("B")) {
                continue;
            }

            String vertex1 = inputView.selectVertex(1);
            String vertex2 = inputView.selectVertex(2);

            shortestPath.findPath(vertex1, vertex2, gotCriteria);

        }
    }

    public String main(Boolean firstFlag) {
        outputView.mainScreen(firstFlag);
        String answer = inputView.selectMainScreen();
        return answer;
    }

    public String criteria() {
        outputView.routeCriteria();
        String answer = inputView.selectCriteria();
        return answer;
    }
}

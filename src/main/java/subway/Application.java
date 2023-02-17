package subway;

import subway.controller.Controller;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller(initInputView(scanner),initOutputView());
        controller.run();


    }
    private static InputView initInputView(Scanner scanner) {
        return new InputView(scanner);
    }

    private static OutputView initOutputView() {
        return new OutputView();
    }
}

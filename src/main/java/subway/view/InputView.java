package subway.view;

import java.util.Scanner;

public class InputView {
    final Scanner scanner = new Scanner(System.in);
    public String selectMainScreen(){
        String answer = scanner.nextLine();
        //예외 처리
        return answer;
    }
    public String selectCriteria(){
        String answer = scanner.nextLine();
        //예외 처리
        return answer;
    }

    public String selectVertex(int vertex1or2){
        if (vertex1or2 == 1){
            System.out.println("\n## 출발역을 입력하세요.");
        }
        if (vertex1or2 == 2){
            System.out.println("\n## 도착역을 입력하세요.");
        }
        String answer = scanner.nextLine();
        //예외 처리
        return answer;
    }
}

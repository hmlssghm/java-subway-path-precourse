package subway.view;

public class OutputView {
    public void mainScreen(Boolean firstFlag) {
        if (firstFlag){
            System.out.println("## 메인 화면\n1. 경로 조회\nQ. 종료");
        }
        if(!firstFlag){
            System.out.println("\n## 메인 화면\n1. 경로 조회\nQ. 종료");
        }
        System.out.println("\n## 원하는 기능을 선택하세요.");
    }

    public void routeCriteria() {
        System.out.println("\n## 경로 기준\n1. 최단 거리\n2. 최소 시간\nB. 돌아가기");
        System.out.println("\n## 원하는 기능을 선택하세요.");
    }



    public void showResult() {

    }
}

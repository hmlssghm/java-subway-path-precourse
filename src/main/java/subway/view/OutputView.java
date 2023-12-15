package subway.view;

import subway.controller.GetTotalDistanceAndTime;
import subway.domain.Line;

import java.util.List;

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



    public void showResult(List<String> path) {
        GetTotalDistanceAndTime getTotalDistanceAndTime = new GetTotalDistanceAndTime();
        System.out.println("[INFO] ---");
        System.out.println("[INFO] 총 거리: " + getTotalDistanceAndTime.getTotalDistance(path) + "km");
        System.out.println("[INFO] 총 소요 시간: " + getTotalDistanceAndTime.getTotalTime(path) + "분");
        System.out.println("[INFO] ---");
        path.forEach(p ->{
            System.out.println("[INFO] " + p);
        });
    }
}

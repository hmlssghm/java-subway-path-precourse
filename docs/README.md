# 다리 건너기 미션

---

## 👨🏻‍💼 Author
MoonJeWoong
- email: munjin0201@naver.com
- blog : https://makemepositive.tistory.com/

---

## 💡프로젝트 개요


---


## 📋 구현 기능 목록

### controller
- 초기 설정
  - 초기 정보를 사용하여 station과 line 객체들을 생성한다.
  - 생성한 객체들을 Repository에 저장한다.
- 메인 화면
  - 커맨드를 입력받는다.
    - 경로 조회
    - 종료
- 경로 조회 기능
  - 경로를 계산할 기준을 선택한다.
    - 최단 거리
    - 최소 시간
    - 돌아 가기
  - 출발역과 도착역을 입력받아 경로를 조회한다.
    - 출발역과 도착역이 동일하면 에러를 발생시킨다.
    - 에러가 발생하면 경로 조회 기능을 다시 수행한다.
  - 조회 결과를 출력한다.
    - 총 거리
    - 총 소요시간
    - 경유역


### domain
- 지하철 역 초기 설정 정보를 관리한다.
- 호선 초기 설정 정보를 관리한다.
- 구간 초기 설정 정보를 관리한다.

- 지하철 역 정보를 관리한다.
  - 역 이름을 저장하고 반환한다.
  - 해당 지하철 역에서 한번에 이어진 역들에 대한 정보를 저장한다.

- 구간 정보
  - 연결된 두 지하철 역 정보를 저장한다.
  - 저장된 두 지하철 역 간 이동에 소요되는 시간과 거리를 저장한다.

- 노선
  - 노선 이름을 저장하고 반환한다.
  - 해당 노선에 포함되는 지하철 역 정보를 저장한다.
  - 노선에 포함되는 역 구간 정보를 저장한다.

- 최단거리 계산기
  - 최단 경로 라이브러리를 사용한다.
  - 저장된 지하철 역들을 모두 vertex로 추가한다.
  - 지하철 역들 간 구간 정보를 edge로 추가한다.
  - 최단 경로를 계산한다.


### view
- 입력
- 원하는 기능 선택 입력
- 경로 조회시 경로 기준 입력
- 출발역 입력
- 도착역 입력

- 출력
- 메인 화면 출력
- 경로 조회 결과 출력


### utils


### 예외처리
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, [ERROR]로 시작하는 에러 메시지를 출력 후 해당 부분부터 다시 입력을 받는다.


---

## 💡사용법
1. 로컬 git-bash에서 프로젝트 원격 저장소를 클론합니다.
~~~ bash
git clone https://github.com/MoonJeWoong/java-subway.git
~~~

2. 프로젝트 디렉토리 내 `Application.java` 파일의 main 메서드를 실행합니다.
# 미션2 기능 구현

### LadderGame

- [x] 사다리로부터 각 라인의 Point를 순회하며 Point가 있을 경우 순서를 변경한다.
- [x] 모든 라인을 읽었을 경우, 변경된 순서대로 참가자를 찾고, 그 참가자의 결과를 저장한다.
- [x] 결과를 보고 싶은 사람의 이름이 있을 경우 그 사람의 결과를 view에 전달한다.
- [x] all일 경우 모든 사람의 이름과 결과를 view에 전달한다.

## Domain

### LadderGame

- [x] 사다리 게임을 실행하면 순서를 변화시킨다.
- [x] 사다리 게임을 실행하면 내부적으로 게임결과 맵을 생성한다.

### SequenceSwapper

- [x] 순서 변환 객체는 참가자들의 순서 인덱스를 갖고 있는 일급 컬렉션이다.
- [x] 순서 변환 객체는 들어온 index의 양 옆의 순서를 바꾼다.
- [x] 순서 변환 객체는 사다리 다리로 변경된 마지막 순서를 반환한다.

### Result

- [x] 결과값을 갖고 있는다.
- [x] 결과값은 1자 이상 5자 이하이다.

### Results

- [x] Results는 결과 객체들을 리스트로 갖고 있는 일급 컬렉션이다.
- [x] Results는 특정 인덱스의 결과를 가져올 수 있다.

## View

### InputView

- [x] 사다리 게임에서는 실행 결과를 입력 받는다.

### OutputView

- [x] 사다리 결과에서는 결과를 함께 표기한다.
- [x] 결과를 보고 싶은 사람의 이름을 입력받을때, 그 사람의 실행 결과를 보여준다.
- [x] 결과를 보고 싶은 사람에 all을 입력받는 경우 전체 실행결과를 표시한다.

---
# 구현 기능 목록

- [X] 도메인
  - [X] 참가자들
      - [X] [예외] 참가자의 이름은 공백일 수 없다.
      - [X] [예외] 참가자의 이름은 1글자 이상 5글자 이하여야 한다.
  - [X] 사다리 생성기
    - [X] 사다리 생성기는 너비, 높이와 포인트 생성기를 받아 사다리를 생성한다.
  - [X] 사다리는 라인 리스트를 갖고있다.
  - [X] 라인은 포인트 리스트를 갖고있다.
    - [X] **포인트 리스트를 반환할 수 있어야한다.(toString vs getter)**

- [X] 유틸
  - [X] 라인 포인트 생성기
    - [X] 메서드 파라미터로 포인트 생성기를 입력받아야 한다.
    - [X] 연속된 포인트 값을 생성하면 안 된다.
  - [X] 포인트 생성기(인터페이스)
  - [X] 랜덤 포인트 생성기(구현체)
  - [X] 포인트(enum)
    - Presence, Absence로 구성된다.

- [X] 컨트롤러
  - [X] 사다리 게임
    - [X] 참여할 사람 이름을 입력받아야한다.
    - [X] 최대 사다리 높이를 입력 받는다.
    - [X] 이름과 높이로 사다리 생성자를 호출한다.
    - [X] 실행 결과를 출력한다.

- [X] 뷰
  - [X] 인풋뷰
    - [X] 참여할 사람을 입력 받는다.
    - [X] 쉼표 사이 공백을 제거한다.
      - [X] [예외] 0명 입력되면 예외를 반환한다.
    - [X] 높이를 입력 받는다.
      - [X] [예외] 높이는 자연수여야한다.
  - [X] 아웃풋 뷰
    - [X] 에러 메세지를 출력한다.
    - [X] 실행결과를 출력한다.
      - [X] 참가자들 이름을 출력한다.
      - [X] 게임에서 사다리 포인트들의 배열을 받아서 출력한다.
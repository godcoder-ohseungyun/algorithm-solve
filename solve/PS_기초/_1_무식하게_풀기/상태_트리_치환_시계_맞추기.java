package PS_기초._1_무식하게_풀기;

/**
 * 상태 트리의 치환을 고려해야한다 (REAME.md의 설명을 근거하여)
 *
 * + 4번 버튼을 누르면, 누르지 않은 상태와 같다 (==0번 누름)
 * + 즉, 0,1,2,3과 4,5,6,7은 같은 상태가 됨으로 버튼을 누르는 '선택의 가짓수'는 0,1,2,3 4가지이다
 * + 버튼은 0..9 총 10가지 임으로, 높이가 10인 상한이 4^10인 상태 트리를 그릴 수 있다
 * + 10^n의 왼쪽 트리에서 n^10의 오른쪽 트리로 치환 성공
 * <p>
 * + 이제, 상한이 제한 되어 있기 때문에, 답이 없는 경우를 적절히 제한 할 수 있다
 * <p>
 * 1. 완탐 적용 여부 검토
 * 4^10 == 1048576 임으로 완탐 가능
 * <p>
 * 2. 문제 및 부분 문제 도출
 * 모든 시계가 12시를 가르키게 만들기 위해, 버튼을 누를 수 있는 최소 횟수를 구하기
 * <p>
 * 각 버튼을 0~3회 눌러 종료 조건을 검토한다
 * <p>
 * 3. 메서드 및 입력값 도출
 * pushButton(int button)
 * <p>
 * 4. 호출 시 할 일
 * 버튼 0~3회 누르기
 * <p>
 * 5. 종료조건
 * 모든 시계가 12시를 가르키면 종료
 * 버튼을 다 눌러본 경우 종료 (답없는 경우임)
 */
public class 상태_트리_치환_시계_맞추기 {

    int[][] linked;
    int min;

    private void pushButton(int button, int sum ,int[] clock) {

        //모든 버튼을 다 눌러본 경우
        if (button == 10) return;

        //종료 조건
        if (allClear()) {
            min = Math.min(min,sum);
            return;
        }

        for(int i = 0; i < 4; i++) {
            push(button, clock);
            pushButton(button + 1, sum+i, clock.clone()); //깊은 복사 필수 : 취소 작업 없어도 됨
        }
    }

    //버튼 누르기
    private void push(int button, int[] clock) {
        for (int clockNumber : linked[button]) {
            changeClock(clockNumber, clock);
        }
    }

    //시계 가속
    private void changeClock(int clockNumber, int[] clock) {

        if (clock[clockNumber] != 12) {
            clock[clockNumber] += 3;
            return;
        }

        clock[clockNumber] = 3;
    }

    private boolean allClear(){
        //todo: 구현
        return true;
    }
}

package PS_기초._1_무식하게_풀기;

import java.util.Arrays;

/**
 * 이 문제는 규칙을 규정해야한다
 * <p>
 * PS 접근
 * 1. 문제를 정의하고 부분 문제를 결정
 * 문제 : 모든 사람을 친구인 사람끼리 짝을 지어주는 경우의 수를 세는 문제
 * 부분 문제 : 친구인 사람끼리 짝을 짓는 문제
 * 2. 함수 명과 입력 값, 출력 값 결정
 * > pairing (int nums)
 * 3. 각 호출 단위에 무엇을 어떻게 해야할지 결정
 * > 종료 조건으로 필터링
 * > 짝지어지지 않은 사람 중, 친구인 사람끼리 짝을 짓기
 * 4. 종료조건 고려 ( 예외 경우를 철저하게 고려하라 ex) 입력이 1이면 항상 실패 or 항상 성공  )
 * > 모든 짝이 만들어졌으면 count++후 종료
 * > 이외 실패 조건은 문제 특성상 제한됨
 * 5. 종료조건의 순서를 결정하라 ( 배치 순서에 따라 효율성이나 결과가 변한다 )
 * <p>
 * <p>
 * 시간 복잡도
 * - 완전 탐색은 답의 수와 시간 복잡도가 비례한다, 이 문제의 경우 정확한 시간 복잡도를 수식으로 표현하기 애매하다
 * - 이 경우, 최악 답의 수를 구하면 된다.
 * - 최대 10명임으로 다음과 같다.
 * - 9 * 7 * 5 * . . * 1 (첫번째 사람이 짝을 고르는 경우의 수 9, 두번째 사람이 짝을 고르는 경우의 수 7 ...)
 */
public class 탐색_규칙_정하기_심화_소풍 {

    boolean[] ch;
    boolean[][] friends;
    int count = 0;

    public int solution() {
        int nums = 10;
        ch = new boolean[nums];

        Arrays.fill(ch, false);

        friends = new boolean[nums][nums];

        for (int i = 0; i < nums; i++) {
            Arrays.fill(friends[i], true);
        }

        pairing(nums);

        return count;
    }

    /**
     * 여러 답 중 하나만 세기 (사전순)
     * 규칙을 주기, 자기보다 뒤의 수만 후보에 넣는다 (조합)
     */
    private void pairing(int nums) {

        int next = findNext(nums);

        if (next == -1) {
            count++;
            return;
        }

        for (int j = next + 1; j < nums; j++) {
            if (ch[next] == false && ch[j] == false && friends[next][j] == true) {
                ch[next] = true;
                ch[j] = true;
                pairing(nums);
                ch[next] = false;
                ch[j] = false;
            }
        }
    }

    private int findNext(int nums) {
        for (int i = 0; i < nums; i++) {
            if (!ch[i]) return i;
        }
        return -1;
    }

}

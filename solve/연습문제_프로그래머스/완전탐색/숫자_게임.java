package 연습문제_프로그래머스.완전탐색;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * [ 사고 순서 ]
 * A로 부터, 최대 승점을 얻을 수 있는 순서로 B를 정렬한 후, 최대 승점을 구한다
 *
 * O ( 100,000 ! ) 의 최악 시간 복잡도를 가진다
 *
 * 완전탐색 최적화 기법을 이용해야한다
 *
 * 최적화 방안 고려하기
 * 0. 결정 트리로 치환할 수 없다
 * 1. 결정 알고리즘은 사용할 수 없다
 * 2. 가지치기를 사용해야 한다
 *
 * B를 정렬하는 모든 경우의 수 트리를 BFS로 순회하면서, 동일 레벨에서 기존에 나온 최대 승점보다 낮은 경우는 모두 가지치기하면 된다
 *
 * 동일레벨에서 구해진적 있는 최대 승첨보다 낮다는 것은 이길 수 있음에도 졌다는 것이기 때문에 가지치기 해야한다
 *
 * 연승을 해야한다 (다음을 이기기 위해 일부러 지는 것은 없다), 왜나면 조삼 모사이다 '승 패'나 '패 승'이나, 결국 얻는 총 승점은 똑같기 때문
 *
 * [ 인줄 알았으나 ]
 * 메모리 제한문제로 더 쉽게 풀어야 했다, 완전 탐색이 아니라, 투포인터 문제였다
 *
 * 배치하려는 A의 수를 B의 수중 가장 작은 수로 이기면 된다
 *
 * A 5723
 * B 7834
 *
 * 일 때 2를 3으로 3을 4로 이겨야한다
 *
 * A,B를 정렬한 후, 이길 수 있는 가장 작은 수를 찾는다, B를 모두 돌고나면 종료하고 지금까지 최대 값을 답으로 리턴한다
 */
public class 숫자_게임 {

    public int solution(int[] A, int[] B) {
        //정렬
        Arrays.sort(A);
        Arrays.sort(B);

        int N = B.length;
        int pa = 0, pb =0;
        int score = 0;

        while(pb<N){
            int va = A[pa];
            int vb = B[pb];

            //이길 수 있으면,승점을 얻고 다음 A의 상대를 찾는다
            if(va<vb) {
                score++;
                //다음 사람을 가르키도록 변경
                pa++;
                pb++;
            }
            //비기거나 졌으면, B의 다름사람중 이길 수 있는 가장 작은 사람을 찾는다
            else {
                //다음 사람을 가르키도록 변경
                pb++;
            }
        }
        return score;
    }
}

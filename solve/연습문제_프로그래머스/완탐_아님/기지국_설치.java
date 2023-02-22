package 연습문제_프로그래머스.완탐_아님;

/**
 * BFS 보다 더 빠르게 풀 수 있다
 *
 * 순차적으로 인덱스를 서치하면서, 해당 인덱스를 포함시킬 수 있는 최대 영역을 다 마킹해버린다
 */
public class 기지국_설치 {
        public int solution(int n, int[] stations, int w) {
            int answer = 0; // 추가로 설치해야 할 기지국의 개수

            int start = 1; // 아파트의 시작 위치
            int idx = 0; // 이미 설치된 기지국의 인덱스
            while (start <= n) {
                // 이미 설치된 기지국이 현재 위치를 포함하는 경우
                if (idx < stations.length && start >= stations[idx] - w) {
                    start = stations[idx] + w + 1; //현 인덱스가 기지국이면 기지국 영향범위 밖으로 이동
                    idx++;
                } else { // 설치되지 않은 영역에 기지국 설치
                    start += 2 * w + 1; //현 인덱스를 포함하는 최고 효율 기지국 범주 : 전부 마킹 후 이동
                    answer++; //설치 카운팅
                }
            }

            return answer;
        }
}

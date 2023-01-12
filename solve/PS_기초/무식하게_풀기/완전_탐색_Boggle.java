package PS_기초.무식하게_풀기;

import java.util.Scanner;

/**
 * 문제 링크 : https://lipcoder.tistory.com/241
 *
 * PS 접근
 *  1. 문제를 정의하고 부분 문제를 결정
 *     > 문제 : 5x5 격자 판에서 주어진 단어를 찾기 위해, 특정 위치에서 출발하여 탐색하고 참, 거짓을 반환
 *     > 부분 문제 : 주어진 위치와 주어진 단어의 첫 글자가 일치하는지 반환
 *  2. 함수 명과 입력 값, 출력 값 결정
 *     > hasWord
 *     > int x, int y, Queue<String> word
 *  3. 각 호출 단위에 무엇을 어떻게 해야할지 결정
 *     > 종료 조건으로 필터링
 *     > 8방위로 나아가기 (재귀)
 *  4. 종료조건 고려 ( 예외 경우를 철저하게 고려하라 ex) 입력이 1이면 항상 실패 or 항상 성공  )
 *     > 주어진 좌표가 격자판 범위를 넘어선 경우 (항상 실패)
 *     > 주어진 좌표의 낱말과 주어진 단어의 첫 째 낱말이 일치하지 않는 경우 (항상 실패)
 *     > 위를 만족하지 않고, 주어진 단어의 길이가 1인경우 (항상 성공)
 *  5. 종료조건의 순서를 결정하라 ( 배치 순서에 따라 효율성이나 결과가 변한다 )
 *     > 4번 순서
 *
 * 시간 복잡도 O(8^n)
 * - 각 노드에서 8갈래로 재귀 호출하며, 뻗어 나아간다.
 * - 단어 길이가 N이면 N-1번 반복한다 (N번째 단어를 만나면 종료 조건에 걸림으로 재귀 중지이기 때문)
 */
public class 완전_탐색_Boggle {

    int[] dx = {0,1,1,1,0,-1,-1,-1};
    int[] dy = {-1,-1,0,1,1,1,0,-1};

    char[][] map;

    int N;

    private boolean hasWord(int x, int y, String word){

        if(!isRange(x,y)) return false;

        if(map[y][x]!=word.charAt(0)) return false;

        if(word.length()==1) return true;

        for(int i=0;i<8;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            /**
             * *팁: 반환 타입을 가지는 재귀 함수를 만들었을 때, 결과 찾으면, 다른 경우의 수 서칭을 중지하고 최상위로 해당 값 전달하기
             *
             * 재귀 호출 시, true 종료 조건에 걸리면, 백트래킹시 아래 if문에 걸린다
             * 때문에, 다음 좌표로 넘어가지 않고 return true가 동작하며 연쇄적으로 백트래킹 되어 true가 최 상위 함수 호출부에 전달된다
             */
            if(hasWord(nx,ny,word.substring(1))) return true;
        }
        return false;
    }

    private boolean isRange(int x,int y){
        if(x<0 || x>=N || y<0 || y>=N) return false;
        return true;
    }

    public void solution(){
        Scanner sc = new Scanner(System.in);

        // board판 입력
        for(int i = 0; i < 5; ++i) {
            String tmpStr = sc.next();
            for(int j = 0; j < 5; ++j) {
                map[i][j] = tmpStr.charAt(j);
            }
        }

        // 확인할 단어 수 입력
        int testCount = sc.nextInt();
        String[] str = new String[testCount];

        // 단어 입력
        for(int i = 0 ; i < str.length; ++i) {
            str[i] = sc.next();
        }

        for(int n = 0; n < str.length; ++n) {
            System.out.print(str[n] + " ");
            boolean isWord = false;

            for(int i = 0; i < 5; ++i) {
                for(int j = 0; j < 5; ++j) {
                    if(hasWord(i, j, str[n])) {
                        isWord = true;
                        break;
                    }
                }
                if(isWord) break;
            }

            if(isWord) System.out.println("YES");
            else  System.out.println("NO");
        }
    }

}

package PS_기초._1_무식하게_풀기;

/**
 * 이 문제는 규칙을 규정해야한다
 *
 * 1. 완탐 적용 여부 검토
 * 시간 복잡도의 상한은 모든 칸이 흰색이며, 모든 경우로 채울 수 있는 상태이다.
 * 덮어야만 하는 흰칸의 수는 최대 50이고, 블록의 가지수는 4가지 임으로 복잡도 상한은 약 4^15이다
 * (블록은 3칸으로 이루어짐, 50/3 = 최대 15개의 블록을 사용함으로)
 *
 * 2. 문제 정의
 * 4가지의 블록으로 흰 칸만 모두 채우는 경우의 수를 모두 구하라
 *
 * 부분 문제: 흰 칸을 찾아, 가능한 블록을 끼우기
 *
 * + 흰 칸을 찾을 때, 왼쪽 상단 순서로만 찾아 끼운다는 규칙을 부여히야한다.
 * + 그렇지 않으면, 다른 순서로 찾아 끼운 경우가 모두 중복 카운트 되기 때문에
 * + '소풍' 문제 처럼, 정답을 세는 한가지 방법만 세는 것이다
 *
 * 3. 함수명 및 입력값 정하기
 * putBlock()
 *
 * 4. 호출 단위에서 할 일
 * 채워지지 않은 흰칸을 찾아, 가능한 블록을 끼운다
 *
 * 5. 종료조건 및 순서
 * 모든 흰칸이 채워진 경우 == 채워지지 않은 흰칸을 못찾은 경우
 *
 */
public class 탐색_규칙_정하기_게임판_덮기 {

    int H,W;
    int[][][] block = {
            {{1,0},{1,1}}
            ,{{0,1},{-1,1}}
            ,{{0,1},{1,1}}
            ,{{-1,0},{-1,1}}
    };

    int[][] map;

    int count=0;

    private void putBlock(){

        //기준이 될 좌표 찾기
        int x=-1,y =-1;
        for(int i=0;i<H;i++){
            for(int j=0;j<W;j++){
                if(map[i][j] == '.')  {
                    y=i;
                    x=j;
                    break;
                }
            }
            if(y!=-1) break;
        }

        //종료조건
        if(y==-1) {
            count++;
            return;
        }


        //놓을 수 있는 블록 놓고, 다음 재귀
        for(int i=0;i<4;i++){
            int y1 = block[i][0][0];
            int x1 = block[i][0][1];
            int y2 = block[i][1][0];
            int x2 = block[i][1][1];
            //좌표 검사
            if(validatePoint(y,x) && validatePoint(y1,x1) && validatePoint(y2,x2)){
                checkByValue(y,x,'#');
                checkByValue(y1,x1,'#');
                checkByValue(y2,x2,'#');
                putBlock();
                checkByValue(y,x,'.');
                checkByValue(y1,x1,'.');
                checkByValue(y2,x2,'.');
            }
        }
    }

    private boolean validatePoint(int y, int x){
        if(y>=0 && x>=0 && y<H && x<W){
            if(map[y][x]=='.'){
                return true;
            }
        }
        return false;
    }

    private void checkByValue(int y, int x, char value){
        map[y][x] = value;
    }
}

import java.util.Arrays;

public class 경주로_건설_DFS {

    class Point{
        int y;
        int x;
        int d;

        public Point(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }

    private int min_fee = Integer.MAX_VALUE;
    private int[][] ch;

    private int N;

    private static final int[] dy = {-1, 0, 1, 0};
    private static final int[] dx = {0, 1, 0, -1};


    public int solution(int[][] board) {

        N = board.length;

        ch = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(ch[i], Integer.MAX_VALUE);
        }

        ch[0][0] = 0;

        dfs(new Point(0,0,-1),0,board);

        return min_fee;
    }

    /**
     * DFS, BFS는 선택의 문제임
     */

    private void dfs(Point now, int total, int[][] board){
        if(total > min_fee) return; //방문 전 좌표라도 이미 건설 비용이 정답 후보 보다 크면 정지

        if(ch[now.y][now.x] < total) return; //이전 방문 기록이 현재 건설 비용보다 저렴하면 정지
        else ch[now.y][now.x] = total; //현재 방문지를 현재까지 최소 건설 비용으로 갱신

        if(now.x == N-1 && now.y == N-1) {
            min_fee = ch[N-1][N-1];
            return;
        }

        for(int d=0;d<4;d++){ //인덱스는 방향을 나타냄으로 d로 표기 *앞으로 항상 방향을 의미한다는 것을 인지할 것
            int ny = now.y + dy[d];
            int nx = now.x + dx[d];

            if(ny >= 0 && ny < N && nx >= 0 && nx < N && board[ny][nx] == 0){

                if(now.d == -1 || now.d == d){ //출발지거나 직선인 경우
                    dfs(new Point(ny,nx,d),total+100,board);
                }else{
                    dfs(new Point(ny,nx,d),total+600,board);
                }

            }
        }
    }

}






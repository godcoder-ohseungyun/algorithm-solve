package PS_기초._3_DFS_BFS_그래프_탐색.DFS;

/**
 * dfs의 개념을 깊숙히 이해해야만 풀 수 있다
 *
 * [ 쭉 내려갔다가 역으로 올라오면서 조건들을 채워가는 풀이 방식이다 ]
 *
 * 만약, 그래프가 '사이클'이 없다면, '상하'의 개념이 없는 트리로 볼 수 있다
 *
 * 지배 정점이란, 인접 정점들을 지배하는 정점을 이야기한다
 *
 * 이 문제는 지배 정점들을 찾는 문제이다
 *
 * dfs의 호출 시 할 일과, 회귀의 개념을 잘 이해하고 문제를 풀어보자
 */
public class 감시_카메라_설치 {

    //해당 idx의 정점에 카메라가 설치되어있나?
    boolean[] is_camera;

    int[][] map;
    boolean[] visited;

    static final int WATCHED = 0;
    static final int UNWATCHED = 1;
    static final int INSTALLED = 2;

    /**
     * 인접 정점 중 지배 당하는 정점이 하나도 없다면, 현재 정점에 카메라를 설치한다
     *
     * 정점의 상태는 '지배 받는 중' '카메라' '지배 받지 않는 중' 총 3가지 이다
     */
    private int dfs(int now){

        visited[now] = true;
        int[] status = new int[3];

        //인접 정점 검사
        for(int next=0; next<map[now].length; next++){
            if(map[now][next]==1 && !visited[next]){
                ++status[dfs(next)]; //인접 노드의 상태 결과를 기록한다
            }
        }

        //인접 정점 중 지배 받지 않는 정점이 하나라도 있다면
        //카메라를 설치 o
        //installed
        if(status[UNWATCHED]>0){
            is_camera[now] = true;
            return INSTALLED;
        }

        //그렇지 않고, 인접 정점 중 카메라가 하나라도 있다면
        //카메라 설치 x
        //watched
        if(status[INSTALLED]>0){
            return WATCHED;
        }

        //그 외의 경우
        //unwatched
        return UNWATCHED;

    }

    public void callDfs(){
        int n = 10;

        //서로 전부 연결된게 아니기 때문에, 한번의 dfs로 탐색되지 않은 경우, 탐색히애한다
        for(int start=0;start<n;start++){
            //시작 정점 주변의 노드가 모두 지배 받는 노드만 있을 때, 시작 정점은 unwatched가 된다.
            //이때는 시작 정점에 카메라를 설치를 해줘야한다
            if(!visited[start] && dfs(start)==UNWATCHED){
                is_camera[start] = true;
            }
        }
    }

}

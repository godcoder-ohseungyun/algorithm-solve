package 네트워크;

import java.util.LinkedList;
import java.util.Queue;

/**
 -
 시작 정점을 호출하는 calldfs : 사전에 check 표시된 시작 정점은 pass
 시작 정점에서 방문할 수 있는 모든 정점을 check 표시하는 dfs or bfs
 방문을 마무리하면 count++
 */
public class NetworkDFS {
    int[][] map;
    int N;
    boolean[] ch;

    public int solution(int n, int[][] computers) {
        map = computers;
        N = n;
        ch = new boolean[n];


        return calldfs();
    }

    int calldfs(){
        int count = 0;
        for(int start=0;start<N; start++){
            if(ch[start]) continue;
            dfs(start);
            count++;
        }
        return count;
    }

    void dfs(int start){
        //특정 종료조건 없음

        for(int next=0;next<N;next++){
            if(map[start][next]==1&&!ch[next]){
                ch[next] = true;
                dfs(next);
                //취소 작업 불필요
            }
        }

    }
}


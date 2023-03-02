package 네트워크;

import java.util.*;
/**
 -
 시작 정점을 호출하는 calldfs : 사전에 check 표시된 시작 정점은 pass
 시작 정점에서 방문할 수 있는 모든 정점을 check 표시하는 dfs or bfs
 방문을 마무리하면 count++
 */
public class Network {
    int[][] map;
    int N;
    boolean[] ch;

    public int solution(int n, int[][] computers) {
        map = computers;
        N = n;
        ch = new boolean[n];


        return callbfs();
    }

    int callbfs(){
        int count = 0;
        for(int start=0;start<N; start++){
            if(ch[start]) continue;
            bfs(start);
            count++;
        }
        return count;
    }

    void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        ch[start] = true;

        while(!q.isEmpty()){
            int now = q.poll();
            //다음 정점 파악 후 방문
            for(int next=0;next<N;next++){
                if(map[now][next]==1 && !ch[next]){
                    q.offer(next);
                    ch[next] = true;
                }
            }
        }

    }
}


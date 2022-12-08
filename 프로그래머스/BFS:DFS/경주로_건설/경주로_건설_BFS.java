package 경주로_건설;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 경주로_건설_BFS {

    private static class Entity {
        int y;
        int x;
        int dir;
        int total;

        public Entity(int y, int x, int dir, int total) {
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.total = total;
        }
    }

    private static int N;
    private static int[][] cache;
    private static int[][] map;
    private static final int INF = 999999;
    private static int[] dy = {-1, 0, 1, 0};
    private static int[] dx = {0, -1, 0, 1};

    public int solution(int[][] board) {

        int answer = INF;
        map = board;
        N = board.length;
        cache = new int[N][N];
        /**
         * 메모이제이션 : 해당 위치의 도로를 깔려고 할 때, 이전에 깔았던 곳이라면 그 기록과 비교하여 가격이 높으면 볼 필요도 없다
         * 이에 비하여, DFS는 도로를 깔다가 '도로 완성 비용'하고만 비교함으로 가지치기가 BFS에 비하여 월등히 떨어진다
         */

        for (int i = 0; i < N; i++) {
            Arrays.fill(cache[i], INF);
        }

        cache[0][0] = 0;

        Queue<Entity> q = new LinkedList<>();
        q.add(new Entity(0, 0, -1, 0));
        while (!q.isEmpty()) {
            Entity now = q.poll();
            if (now.y == N - 1 && now.x == N - 1) {
                answer = Math.min(answer, now.total);
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                if (ny >= 0 && ny < N && nx >= 0 && nx < N && map[ny][nx] == 0 && cache[ny][nx] > now.total) {

                    if (now.dir == -1 || now.dir == i) {
                        cache[ny][nx] = now.total + 100;
                        q.add(new Entity(ny, nx, i, now.total + 100));
                    } else {
                        cache[ny][nx] = now.total + 100;
                        q.add(new Entity(ny, nx, i, now.total + 600));
                    }
                }
            }
        }
        return answer;
    }
}






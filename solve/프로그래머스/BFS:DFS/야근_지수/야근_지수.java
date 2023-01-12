package 야근_지수;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 야근_지수 {
    int n;
    int[] tiredByHour;

    private void bfs(int[] nums, int hour) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(nums));
        int level = 0;

        while (!q.isEmpty()) {
            if(level > hour) break;

            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node now = q.poll();

                if (tiredByHour[level] > now.getTired()) {
                    tiredByHour[level] = now.getTired(); //갱신

                    for (int j = 0; j < n; j++) {
                        int[] clone = now.getWorks();
                        if (clone[j] != 0) {
                            clone[j]--;
                            q.add(new Node(clone));
                        }
                    }
                }

            }
            level++;
        }

    }

    public int workout(int[] nums, int hour) {
        n = nums.length;
        tiredByHour = new int[hour+1];
        Arrays.fill(tiredByHour,Integer.MAX_VALUE);
        bfs(nums,hour);

        int result = tiredByHour[hour];

        if(result==Integer.MAX_VALUE) return 0;
        return result;
    }

    class Node {
        int[] works;

        public Node(int[] works) {
            this.works = works;
        }

        public int getTired() {
            return Arrays.stream(works).map(s -> s * s).sum();
        }

        public int[] getWorks() {
            return works.clone();
        }
    }

}

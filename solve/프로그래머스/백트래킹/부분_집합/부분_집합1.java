package 프로그래머스.백트래킹.부분_집합;

import java.util.ArrayList;
import java.util.List;

/**
 * 조합을 이용하여 풀기
 *
 * 단, 출력 순서를 맞추기 위해서 이렇게 푸는 것으로 부분집합 길이마다 백트래킹을 반복함으로 중복 연산이 있다
 */
public class 부분_집합1 {
    List<List<Integer>> output = new ArrayList();
    int n, k;

    public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
        // if the combination is done
        if (curr.size() == k) {
            output.add(new ArrayList(curr));
            return;
        }

        for (int i = first; i < n; ++i) {
            // add i into the current combination
            curr.add(nums[i]);
            // use next integers to complete the combination
            backtrack(i + 1, curr, nums);
            // backtrack
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;

        //집합의 원소 수 k : 0은 공집합
        for (k = 0; k < n + 1; ++k) {
            backtrack(0, new ArrayList<Integer>(), nums);
        }

        return output;
    }
}





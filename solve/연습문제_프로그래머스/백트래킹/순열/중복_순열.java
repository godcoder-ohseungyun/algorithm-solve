package 연습문제_프로그래머스.백트래킹.순열;

import java.util.ArrayList;
import java.util.List;

public class 중복_순열 {

    int n;
    List<List<Integer>> result = new ArrayList<>();

    private void backtrack(int level, List<Integer> answer, int[] nums) {
        if (level == n) {
            result.add(new ArrayList<>(answer)); //깊은 복사 필요
            return;
        }

        for (int num : nums) {
            //이미 기록한 숫자를 필터링하는 조건을 없애면 된다
            answer.add(num);
            backtrack(level + 1, answer, nums);
            answer.remove(answer.size() - 1);
        }


    }

    public List<List<Integer>> purmutation(int[] nums) {
        n = nums.length;
        backtrack(0, new ArrayList<>(), nums);
        return result;
    }
}

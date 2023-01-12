package 프로그래머스.백트래킹.부분_집합;

import java.util.ArrayList;
import java.util.List;

/**
 * 답을 인자로 넘겨주는 방식으로 풀기
 *
 * 답을 인자로 넘겨주는 방식은 2가지 이다.
 * 1. 레퍼런스 타입
 * 2. 원시 타입
 *
 * 레퍼런스 타입을 넘기는 경우
 * 1. 동일한 메모리를 참조하는 인스턴스를 그대로 넘기기 -> 백트래킹시 메모리 제거 작업 필요
 * 2. 새로 생성한 인스턴스를 넘기기 -> 백트래킹시에도 메모리 제거 작업 불필요
 */
public class 부분_집합2 {
    int n;
    List<String> resultByStringParam = new ArrayList<>();
    List<List<Integer>> resultByListParam = new ArrayList<>();

    private void backtrackByStringParam(int level, String set, int[] nums){
        if(level == n) {
            resultByStringParam.add(set);
            return;
        }

        /**
         * 동일한 set 인스턴스를 넘기지 않기 때문에, 백트래킹시 메모리 제거 작업이 필요없다
         *
         * + 연산은 stringBuilder를 이용하여, 새로운 인스턴스를 생성하여 넘긴다
         * 때문에, 인스턴스 값 변경으로 인한 문제는 발생하지 않음
         */
        backtrackByStringParam(level+1,set+nums[level],nums);
        backtrackByStringParam(level+1,set,nums);

    }

    private void backtrackByListParam(int level, List<Integer> set, int[] nums){
        /**
         * 동일한 set 인스턴스를 넘겨주기 때문에, 결과 저장시 깊은 복사를 해야한다
         */
        if(level == n) {
            resultByListParam.add(new ArrayList<>(set));
            return;
        }

        /**
         * 동일한 set 인스턴스를 넘겨주기 때문에, 백트래킹시 메모리 제거 작업을 해야한다
         */
        set.add(nums[level]);
        backtrackByListParam(level+1,set,nums);

        set.remove(set.size()-1);
        backtrackByListParam(level+1,set,nums);

    }

    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;

        //backtrackByStringParam(0,"",nums);
        backtrackByListParam(0,new ArrayList<>(),nums);

        //return resultByStringParam;
        return resultByListParam;
    }
}

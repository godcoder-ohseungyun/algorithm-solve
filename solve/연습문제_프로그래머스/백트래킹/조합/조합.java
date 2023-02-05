package 연습문제_프로그래머스.백트래킹.조합;

import java.util.ArrayList;
import java.util.List;

public class 조합 {

    int n,k;
    List<List<Integer>> result = new ArrayList<>();

    private void backtrack(int level,int[] nums, int start, List<Integer> answer){

        if(level == k) {
            result.add(new ArrayList<>(answer)); //깊은 복사 필요
            return;
        }

        for(int i=start; i<n; i++){ //start 이상만 후보로
            answer.add(nums[i]);
            backtrack(level+1,nums,i+1,answer);
            answer.remove(answer.size()-1); //동일한 answer 인스턴스를 넘김으로 회귀 후 메모리 제거 작업 필요
        }
    }

    public List<List<Integer>> combi(int[] nums,int input){
        n =  nums.length;
        k = input;
        backtrack(0,nums,0, new ArrayList<>());
        return result;
    }
}

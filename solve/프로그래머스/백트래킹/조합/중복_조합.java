package 프로그래머스.백트래킹.조합;

import java.util.ArrayList;
import java.util.List;

public class 중복_조합 {

    int n,k;
    List<List<Integer>> result = new ArrayList<>();

    private void backtrack(int level,int[] nums, List<Integer> answer){

        if(level == k) {
            result.add(new ArrayList<>(answer)); //깊은 복사 필요
            return;
        }

        for(int i=0; i<n; i++){ //start 이상만 후보로 하던 조건을 없애면 된다
            answer.add(nums[i]);
            backtrack(level+1,nums,answer);
            answer.remove(answer.size()-1);
        }
    }

    public List<List<Integer>> combi(int[] nums,int input){
        n =  nums.length;
        k = input;
        backtrack(0,nums,new ArrayList<>());
        return result;
    }
}

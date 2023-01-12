package 프로그래머스.백트래킹.부분_집합;

import java.util.ArrayList;
import java.util.List;

/**
 * ch 기록 배열을 사용하여 풀기
 */
public class 부분_집합3 {

    int n;
    int[] ch;
    List<String> result = new ArrayList<>();

    private void backtracking(int level, int[] nums){
        if(level == n){
            String answer = "";
            for(int i=0;i<n;i++){ //ch 배열 기록을 기반으로 정답 생성 후, 저장
                if(ch[i]==1){
                    answer+=nums[i];
                }
            }
            result.add(answer);
            return;
        }

        ch[level] = 1;
        backtracking(level+1,nums);
        ch[level] = 0;
        backtracking(level+1,nums);
    }

    public List<String> subsets(int[] nums){
        n = nums.length;
        ch = new int[n];
        backtracking(0,nums);
        return result;
    }
}

package 연습문제_프로그래머스.완전탐색;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 복잡도 8^8 = 1000만 -> 가지치기가 적용될테니 더 효율적일 것
 *
 * 결정트리는 일단 선택안해보는 연산이 포함되어 있어서, 불확실한 연산이 포함될 가능성 있어서 선택 안함
 *
 *
 * banned id 만큼의 레벨의 트리 만듬
 *
 * 해당 레벨의 문자열에 해당하는 user_id 를 선택함/ 단 결과 배열에 이미 포함된 단어면 건너 뜀
 *
 * * *  *   *  * * * * * * **
 * 컬랙션 요소 중복 제거는 Set으로 선언하여 해결한다
 * 다만, 요소가 컬랙션인 경우, 순서도 완전 동일해야 함으로 정렬이 필요하다
 * Set에서 1,2,3 와 3,1,2는 서로 다른 컬렉션으로 취급함으로 정렬 후 담아야한다
 *
 * 문제에서 주석 참고
 *
 */
public class 불량사용자 {

    List<String> result = new ArrayList<>(8);
    Set<List<String>> results = new HashSet<>();
    int s;

    public int solution(String[] user_id, String[] banned_id) {
        s = banned_id.length;

        dfs(0,user_id,banned_id);

        return results.size();
    }

    private void dfs(int level,String[] user_id, String[] banned_id){

        // results을 집합으로 선언하고, 담기전 정렬을 통해 자동으로 동일 리스트 중복 제거를 하도록 한다
        if(level==s) {
            List<String> tmp = new ArrayList<>(result);
            Collections.sort(tmp);
            results.add(tmp);
        }

        for(String id : user_id){
            if(checkWords(id ,banned_id[level]) && !result.contains(id)){
                result.add(id);
                dfs(level+1,user_id,banned_id);
                result.remove(result.size()-1);
            }
        }
    }

    private boolean checkWords(String id, String banned_id){
        int l1 = id.length();
        int l2 = banned_id.length();

        if(l1!=l2) return false;

        for(int i=0;i<l1;i++){
            if(id.charAt(i) == banned_id.charAt(i) || banned_id.charAt(i) == '*') continue;

            return false;
        }

        return true;
    }

}

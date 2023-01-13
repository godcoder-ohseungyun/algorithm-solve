package _2_무식하게_풀기_최적화;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 이 문제는 탐색 기준을 바꾸어 최적화 하는 문제입니다
 *
 * 특정 방법론이 존재하지 않아 완전 탐색을 사용해야 하지만,
 * 20^20 시간 복잡도를 가짐으로 완전탐색을 그대로 적용할 수 없습니다.
 * 최적화를 거쳐야 합니다
 *
 * 결정 알고리즘은 적용할 수 없습니다
 *
 * 탐색 기준을 바꾸어 최적화할 수 있습니다
 * + 결정 트리를 이용해, 음식을 먼저 차리고 각 고객에 대하여 만족 조건을 고려하기보다
 * + 아직, 음식을 먹지 못한 고객에 대하여 먹을 수 있는 음식을 차리며 경우의 수를 고려하는게 효과적입니다
 *
 * + "결정 트리의 경우 모든 경우의 수를 완수해야하지만, 위 경우는 그렇지 않기 때문입니다"
 *
 * 가지치기가 가능합니다
 * + 차린 음식의 최소 수보다 방문 예정인 노드의 음식 수가 많으면 가지치기합니다
 *
 * 탐색 순서를 고려할 수 있습니다
 * + 아직 먹지 못한 고객을 순차적으로 찾지 않고, 먹을 수 있는 음식의 종류가 적은 고객 우선으로 찾습니다
 *  (까다로운 고객을 먼저 만족시키는게 정답을 빨리 찾을 수 있기 때문입니다)
 *
 */
public class 탐색_기준_바꾸기_알러지가_심한_친구들 {

    Map<String, List<Integer>> friends = new HashMap<>(); //ex) cl : [ 1 , 2 ]

    //value 기준 정렬을 위한 리스트
    List<Map.Entry<String, List<Integer>>> sortedFriends;

    int n,m;

    int min=Integer.MAX_VALUE;

    private void setFood(boolean[] ch,int sum,int friend){
        //종료조건
        //과정중 차린 음식이 최소 값보다 많은 경우 종료 (조합을 묻지 않음으로 =까지 포함해 중복 연산을 대폭 줄임 )
        if(sum>=min) return;

        //모든 사람이 음식을 먹은 경우 종료 (먹을 수 없는 경우는 없음.)
        if(friend==n){
            min = Math.min(min,sum);
            return;
        }

        //음식을 먹지 못한 고객 중, 먹을 수 있는 음식 종류가 가장 적은 고객의 음식 리스트 찾기
        //찾은 고객의 음식중 하나를 차리기
        for(Integer food : sortedFriends.get(friend).getValue()){
            //이전에 차린 음식이라면 그냥 재귀
            if(ch[food])
                setFood(ch,sum,friend+1);
            //이전에 차리지 않은 음식이라면 차리고 재귀 , 회귀시 취소 연산 필요 레퍼런스기 때문
            else {
                ch[food] = true;
                setFood(ch, sum + 1, friend + 1);
                ch[food] = false;
            }
        }



    }

    public void solve(){

        n = 4;
        m = 6;

        friends.put("a",List.of(1,2,3));
        friends.put("b",List.of(4,5));
        friends.put("c",List.of(2,4));
        friends.put("d",List.of(0,1,5));

        sortedFriends = new LinkedList<>(friends.entrySet());
        //우선순위 큐에 리스트 삽입
        sortedFriends.sort((e1,e2)->e1.getValue().size()-e2.getValue().size());

        setFood(new boolean[m],0,0);

        System.out.println(min);
    }

    public static void main(String[] args) {
        탐색_기준_바꾸기_알러지가_심한_친구들 sol1 = new 탐색_기준_바꾸기_알러지가_심한_친구들();

        sol1.solve();
    }

}

package PS_기초.자바_주요_기법;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * ---정렬 기준----
 * this 다음 요소인 other와의 연산 결과가 양수 값을 가지면 this가 '더 큰 값으로 규정'. other의 순서를 바꿈 (즉, this가 other뒤로감)
 *
 * 여기서 '더 큰 값으로 규정'한다는 것은 4<5같은 절대치가 아니라, 사용자가 정의하기에 따라 4>5가 될 수도 있다
 *
 * this가 5 other가 6일 때,
 *
 * (this - other) -> 오름차순
 * -(this - other) -> 내림차순 (this가 더 큰경우 음수가 나오도록 조작했음으로)
 *
 */
public class 컬랙션_정렬 {

    public static void main(String[] args) {
        컬랙션_정렬 sol1 = new 컬랙션_정렬();

        sol1.solve();

    }

    private void solve(){
        List<Node> list = new LinkedList<>(
                List.of(new Node(1),new Node(10),new Node(5))
        );

        /**
         * 컬랙션 정렬 방법--
         * Collectios.sort()사용 : Comparable, Comparator 모두 가능
         *
         * 컬랙션 자체 sort 사용 : Comparator만 가능
         */
        //Comparable 기준 정렬
        Collections.sort(list);
        System.out.println(list);

        //Comparator 기준 적용 정렬
        //v1
        Collections.sort(list,new CompareRule());
        System.out.println(list);
        //v2
        list.sort(new CompareRule());
        System.out.println(list);
        //v3
        list.sort((n1,n2) -> n1.value-n2.value);
        list.sort(Comparator.comparingInt(n -> n.value));

    }

    /**
     * Comparable 재정의 : 컬랙션에 들어갈 요소의 기본 정렬 기준 정의
     * - String, Integer 등 자바 자료형은 기본적으로 재정의 되어 있음
     */
    class Node implements Comparable<Node>{
        int value;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(Node other){
            return this.value - other.value;
        }

        @Override
        public String toString(){
            return String.valueOf(value);
        }
    }

    /**
     * Comparator 재정의한 클래스 만들기 : Comparable를 무시하고 컬랙션 정렬 기준을 새로이 적용할 떄
     * - Comparators 유틸에 기본적인 것은 저장되어 있다
     * - Comparator을 인자로 받는 메서드들에 사용하면 된다
     */
    static class CompareRule implements Comparator<Node>{

        @Override
        public int compare(Node n1,Node n2){
            return -(n1.value-n2.value);
        }
    }
}

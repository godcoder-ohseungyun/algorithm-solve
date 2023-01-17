package PS_기초.자바_주요_기법;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 우선순위큐_힙 {

    public static void main(String[] args) {
        //생성자----
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        //Capacity
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(3);
        //Comparator
        PriorityQueue<Integer> pq3 = new PriorityQueue<>(Comparator.reverseOrder());
        //Capacity + Comparator
        PriorityQueue<Integer> pq4 = new PriorityQueue<>(3,Comparator.reverseOrder());

        //index 0가 가장 우선 순위가 높음 : 오름차순이면 가장 작은 값이 나옴-----
        pq3.add(3);
        pq3.add(4);
        System.out.println(pq3.poll());


    }
}

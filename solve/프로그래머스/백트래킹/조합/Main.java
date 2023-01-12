package 프로그래머스.백트래킹.조합;

import 프로그래머스.백트래킹.순열.순열;

public class Main {
    public static void main(String[] args) {
        조합 sol1 = new 조합();

        System.out.println(sol1.combi(new int[]{1,2,3},2));

        중복_조합 sol2 = new 중복_조합();

        System.out.println(sol2.combi(new int[]{1,2,3},2));

    }
}

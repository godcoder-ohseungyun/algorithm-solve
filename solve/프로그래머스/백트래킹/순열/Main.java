package 프로그래머스.백트래킹.순열;

import 프로그래머스.백트래킹.부분_집합.부분_집합1;
import 프로그래머스.백트래킹.부분_집합.부분_집합2;
import 프로그래머스.백트래킹.부분_집합.부분_집합3;

public class Main {
    public static void main(String[] args) {
        순열 sol1 = new 순열();

        System.out.println(sol1.purmutation(new int[]{1,2,3}));

        중복_순열 sol2 = new 중복_순열();

        System.out.println(sol2.purmutation(new int[]{1,2,3}));

    }
}

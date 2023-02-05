package 연습문제_프로그래머스.백트래킹.순열;

public class Main {
    public static void main(String[] args) {
        순열 sol1 = new 순열();

        System.out.println(sol1.purmutation(new int[]{1,2,3}));

        중복_순열 sol2 = new 중복_순열();

        System.out.println(sol2.purmutation(new int[]{1,2,3}));

    }
}

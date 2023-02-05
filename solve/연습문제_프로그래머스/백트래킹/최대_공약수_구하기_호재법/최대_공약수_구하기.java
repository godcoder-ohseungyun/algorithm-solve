package 연습문제_프로그래머스.백트래킹.최대_공약수_구하기_호재법;

/**
 * 정리 : https://citrine-sing-062.notion.site/dc325b5235f043249fd7b8f0b9329016
 */
public class 최대_공약수_구하기 {

    public static void main(String[] args) {
        System.out.println(dfs(10,3));
    }

    private static int dfs(int a, int b){
        if(a%b==0) return b;

        return dfs(b,a%b);
    }
}

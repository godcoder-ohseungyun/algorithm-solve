package PS_기초.투_포인터_슬라이딩_윈도우;

import java.util.Scanner;

public class 투_포인터_기본 {

    public int solution(int n) {
        int answer = 0, sum = 0;
        int m = n / 2 + 1;
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) arr[i] = i + 1;
        int lt = 0;

        //rt를 증가시키며 lt ~ rt 구간 합을 구한다
        for (int rt = 0; rt < m; rt++) {
            sum += arr[rt];

            //찾는 합이면 정답 카운트
            if (sum == n) answer++;

            //만약 합이 찾는 것 보다 커졌다면
            while (sum >= n) {
                //lt를 하나씩 증가, 다시 작아질때 까지
                sum -= arr[lt++];
                if (sum == n) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        투_포인터_기본 T = new 투_포인터_기본();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.print(T.solution(n));
    }
}

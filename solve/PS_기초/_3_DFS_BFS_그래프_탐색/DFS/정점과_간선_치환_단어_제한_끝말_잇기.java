package PS_기초._3_DFS_BFS_그래프_탐색.DFS;

import java.util.ArrayList;

/**
 * 경우의 수를 그래프 자료구조로 표현할 때, 보편적인 '정점'과 '간선'을 정의하는 스테레오타입을 깨부셔볼 필요가 있다
 *
 * 이 문제는 정점과 간선의 개념을 치환하는 아이디어에서 출발해야한다
 *
 * - 이 문제에서 보편적인 그래프의 문제점 : 주어진 단어를 정점, 다른 정점과 연결할 수 있는지 여부를 0,1로 표현하는 간선
 * 단어의 수가 최대 100개 임으로, 상한의 경우 100!이 된다
 * 완전 탐색으로 접근하기에 최악의 시나리오이다
 *
 * 이전에 상태 트리를 결정 트리로 바꾸어 상한을 개선한 것 처럼, 그래프 탐색에서도 이런 아이디어가 필요하다
 *
 * - 정점과 간선을 치환해보기 : 알파벳이 정점, 다른 정점과 연결되는 간선에 값으로 '주어진 단어'를 stack 부여
 * 알파벳의 수는 26개임으로, 상한이 26!이 된다
 *
 * 엄청난 개선!!
 *
 *  ex) dog 라면 d -> g = dog
 *
 */
public class 정점과_간선_치환_단어_제한_끝말_잇기 {

    String[] inputs = {"dog","god","dragon","need"};

    //간선에 들어갈 단어가 여러개일 수 있음 d->g = dog, dooog
    ArrayList<String>[][] graph = new ArrayList[26][26];

    ArrayList<String> answer = new ArrayList<>();
    String result ="";

    boolean isClear = false;
    int n = 4;

    //그래프 만들기
    private void makeGraph(){

        //graph init fill : 왜인지 Arrays.fill 안됨
        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                graph[i][j] = new ArrayList<>();
            }
        }

        //그래프 그리기
        for(String input : inputs){
            int startc = input.charAt(0) - 'a';
            int endc = input.charAt(input.length()-1) - 'a';

            graph[startc][endc].add(input);
        }

        //for print
        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }

    //dfs
    private void dfs(int now, int level){
        //종료조건
        //이미 답을 찾은 경우 종료
        if(isClear) return;

        //모든 단어를 사용했으면 종료
        //답 깊은 복사 저장
        if(level==n){
            System.out.println("정답들 : "+ answer);

            result = "";

            for(String word : answer){
                result += word + " ";
            }

            //최초로 정답 찾으면 이후는 모두 가지치기 하도록할 수 있음
            //isClear = true;

            return;
        }

        //다음 정점(알파뱃)과 연결하는 간선(단어)가 있으면
        //기록하고 다음 정점으로 이동
        //백트랙시 기록 해제
        for(int next=0;next<26;next++){

            ArrayList<String> edge = graph[now][next];

            if(!edge.isEmpty()){
                for(String word : edge) {
                    if (!answer.contains(word)) {
                        answer.add(word);
                        dfs(next,level+1);
                        answer.remove(answer.size()-1);
                    }
                }
            }
        }
    }

    public void callDfs(){

        makeGraph();

        for(int i=0;i<26;i++){
            dfs(i,0);
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        정점과_간선_치환_단어_제한_끝말_잇기 sol = new 정점과_간선_치환_단어_제한_끝말_잇기();

        sol.callDfs();
    }


}

package PS_기초._3_DFS_BFS_그래프_탐색.DFS;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 일방향이며 사이클이 없는 그래프(DAG)를 dfs를 통해 순회하며, 정점들을 나열하는 것을 위상 정렬이라 합니다
 * https://zoosso.tistory.com/360
 *
 * 이 문제는 위상정렬을 응용하는 문제이다
 * + 그래프를 만들어야합니다
 * + dfs를 통해 위상 정렬합니다
 *
 * 알파뱃을 나열한 후, 단어에 대조해보는 방식은 상한이 26!임으로 '완전탐색'으로 풀 수 없습니다
 *
 * 단어간 관계를 파악하여 그래프로 만들고, 가능 및 불가능 여부를 도출하는 방식으로 풀 수 있습니다
 *
 * 위상 정렬은 다음을 고려해야합니다
 * + 사이클이 없는지
 * + 위상 정렬 결과가 답으로 인정 되는지
 */
public class 위상_정렬 {

    int[][] graph = new int[26][26]; //abc..z
    Stack<String> result = new Stack<>();

    boolean[] visited = new boolean[26];

    //DAG 그래프 만들기
    private void makeGraph(){
        String[] inputs = {"gg","kia","lotte","lg","hanhwa"};
        int size = inputs.length;

        for(int i=0;i<size-1;i++){
            int j = i+1;
            //단어 두개 선택
            String word1 = inputs[i];
            String word2 = inputs[j];

            //단어의 낱말 한자씩 비교 후, 일치하지 않으면 그래프에 방향 표시하고 종료
            //짧은 단어에 순회 기준 맞춰야 IOBE안뜸
            int length = Math.min(word1.length(),word2.length());

            for(int idx =0 ; idx<length;idx++){
                if(word1.charAt(idx)!=word2.charAt(idx)) {
                    //char은 연산자 적용시 int형으로 변함
                    graph[word1.charAt(idx)-'a'][word2.charAt(idx)-'a']=1;
                    break;
                }
            }
        }
    }

    //위상 정렬
    private void dfs(int start, boolean[] visited){

        visited[start] = true;

        for(int idx=0;idx<26;idx++){
            if(graph[start][idx]==1 && !visited[idx]){
                dfs(idx,visited);
            }
        }

        //for문 아래 기록 문을 작성하면, 호출 순이 아닌 반환 순으로 기록할 수 있다
        result.push(Character.toString(start+'a'));
    }



    //dfs 호출
    public void callDfs(){
        //DAG 그래프 만들기
        makeGraph();

        //역방향 존재 여부 검사하기 : dfs 호출 할 필요도 없음
        for(int i=0;i<25;i++){
            int j = i+1;
            if(graph[j][i]==1 && graph[i][j]==1){
                System.out.println("NO_ANSWER");
                return;
            }
        }

        //DFS 시작 점을 지정
        for(int start=0;start<26;start++){

            //해당 정점 방문 전이면 호출
            if(!visited[start]){
                dfs(start,visited);
            }

        }

        Collections.sort(result,Collections.reverseOrder());

        System.out.println(result);

    }

    public static void main(String[] args) {
        위상_정렬 sol = new 위상_정렬();
        sol.callDfs();
    }

}

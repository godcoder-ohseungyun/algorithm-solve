package 여행_경로;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43164
 */
class 여행경로 {
    
    private String[][] ticketList;
    private int[] used;
    private int ticketNum;
    private LinkedList<String> result = new LinkedList<>();
    private LinkedList<LinkedList<String>> results = new LinkedList<>();
    
    public String[] solution(String[][] tickets) {
        ticketList = tickets;
        
        ticketNum = tickets.length;
        used = new int[ticketNum];
        
        dfs(0,"ICN"); //반드시 ICN에서 출발한다는 조건 있음

        Collections.sort(results,new Comparator<LinkedList<String>>() { //결과 경우의 수를 정렬하는 Comparator 정의
            @Override
            public int compare(LinkedList<String> o1, LinkedList<String> o2){

                for (int i = 0; i < o1.size(); i++) {
                    String s1 = o1.get(i);
                    String s2 = o2.get(i);

                    if (!s1.equals(s2)) {
                        return s1.compareTo(s2);
                    }
                }

                return 0;
            }
        });

        String[] answer = new String[results.get(0).size()];

        for(int i = 0; i < results.get(0).size(); i++){
            answer[i] = results.get(0).get(i);
        }
        
        return answer;
        
    }
    
    private void dfs(int level, String now){
        if(level==ticketNum){
            LinkedList<String> clone = (LinkedList<String>) result.clone(); //답 찾은 후 다른 답을 찾기 위해 이전 기록 지울때 result.removeLast(); 때문에 깊은 복사가 필요하다
            clone.add(now); //주의 마지막 티겟의 도착지
            results.add(clone);
            return;
        }

        for(int i = 0 ; i<ticketNum ;i++){
            if(ticketList[i][0].equals(now)){
                if(used[i]==0){
                    used[i]=1;
                    result.add(now);
                    
                    dfs(level+1,ticketList[i][1]);

                    used[i]=0;
                    result.removeLast();
                }
            }

        }
    }


}
package 기지국_설치;


import java.util.LinkedList;
import java.util.Queue;

public class 기지국_설치 {
        int N = 0;
        int W = 0;
        int answer = 0;
        public int solution(int n, int[] stations, int w) {

            N = n;
            W = w;

            bfs(stations);

            return answer;
        }

        int[] makeFirstStation(int[] stations){
            int[] apts = new int[N];

            for(int index : stations){
                apts = setStation(apts,index-1,W);
            }

            return apts;
        }

        void bfs(int[] stations){
            Queue<Node> q = new LinkedList<>();


            q.offer(new Node(makeFirstStation(stations),0));

            //현재 기준으로 해당 지점에 설치
            while(!q.isEmpty()){

                Node now = q.poll();

                int[] nowStatus = now.apts;
                int nowCount = now.setCount;

                if(checkOver(nowStatus)){
                    answer = nowCount;
                    break;
                }

                for(int i=0; i<N; i++){
                    if(nowStatus[i]==0){
                        q.offer(new Node(setStation(nowStatus,i,W),nowCount+1));
                    }
                }

            }
        }

        boolean checkOver(int[] apts){
            for(int apt : apts){
                if(apt == 0) return false;
            }

            return true;
        }


        int[] setStation(int[] apts,int index,int wide){
            int[] clone = apts.clone();

            int start = index-wide;
            int end = index+wide;

            if(start < 0) start = 0;
            if(end>=N) end = N-1;

            for(int i = start ; i <= end ; i++){
                clone[i] = 1;
            }

            return clone;
        }
    }

    class Node{
        int[] apts;
        int setCount = 0;

        public Node(int[] apts,int setCount){
            this.apts = apts;
            this.setCount = setCount;
        }
    }
package _2_무식하게_풀기_최적화;

/**
 * 특정 방법론이 존재하지 않아 완전 탐색을 사용해야 하지만,
 * m^n 시간 복잡도를 가짐으로 완전탐색을 그대로 적용할 수 없습니다.
 * 최적화를 거쳐야 합니다
 *
 * m을 높이로 하는 결정 트리를 만듭니다
 *
 * 결정 알고리즘을 적용할 수 있습니다
 * (*) flag 가지치기를 적용할 수 있습니다
 *
 */
public class 결정_알고리즘_DARPA_Grand_Challenge {

    int[] location; // { 0, 100, 200, 250, 500 }

    int[] candidate_results;
    boolean flag = false;

    int m;

    //gap을 최소 거리의 상한으로 하여, 설치가능 여부를 반환합니다
    private void setCamera(int gap, int limit, int camera, int locate){
        //종료조건
        //(중요) 한 번이라도 성공 했으면 무조건 종료
        if(flag) return;
        //카메라를 모두 소진하면 성공 종료
        if(camera==0) {
            flag=true; //성공 채크
            return;
        }
        //카메라가 남고, 로케이션을 모두 순회하면 실패 종료
        if(locate==m) return;

        //(중요) 남은 카메라 수 > 남은 지역 수의 경우 실패 종료
        if(camera>m-locate) return;

        //do: limit이상의 간격으로 카메라 배치 ==============================
        if(location[locate]>=limit){
            setCamera(gap,location[locate]+gap,camera-1,locate+1);
        }else {
            setCamera(gap,limit,camera,locate+1);
        }
    }

    public void solve(){
        int l = 0;
        int r = candidate_results.length;

        int result = 0;

        while(r>l){
            int mid = (r + l)/2;
            flag = false; //필수
            setCamera(mid,0,5,7);
            if(flag) result = l = mid;
            else r = mid;
        }

        System.out.println(result);

    }
}

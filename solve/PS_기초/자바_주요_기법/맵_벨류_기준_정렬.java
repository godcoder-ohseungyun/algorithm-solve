package PS_기초.자바_주요_기법;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 맵_벨류_기준_정렬 {

    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();

        map.put("김",10);
        map.put("님",1);

        //엔트리 사용
        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());

        //벨류 기준으로 정렬
        Collections.sort(list,(e1,e2)->e1.getValue() - e2.getValue());

        System.out.println(list);
    }
}

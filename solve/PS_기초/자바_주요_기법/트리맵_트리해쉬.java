package PS_기초.자바_주요_기법;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class 트리맵_트리해쉬 {

    //key를 기준으로 순서를 유지함 : comaprator도 key를 기준으로 먹임
    Map<String,Integer> map = new TreeMap<>((key1,key2)->-(key1.compareTo(key2)));

    //요소를 기준으로 순서를 유지함
    Set<String> set = new TreeSet<>(Comparator.reverseOrder());
}

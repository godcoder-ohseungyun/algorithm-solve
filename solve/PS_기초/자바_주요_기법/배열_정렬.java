package PS_기초.자바_주요_기법;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 배열_정렬 {

    public static void main(String[] args) {
        Integer[] arr = {1,10,5,6};

        //구간 정렬 : end 미포함
        Arrays.sort(arr,1,3);
        System.out.println(Arrays.stream(arr).map(i -> String.valueOf(i)).collect(Collectors.toList()));

        //전체 정렬
        Arrays.sort(arr);
        System.out.println(Arrays.stream(arr).map(i -> String.valueOf(i)).collect(Collectors.toList()));

        //PrimitiveType의 배열에는 적용이 불가능하니 Integer같은 Wrapper Class를 이용해야 Comparator 가능
        Arrays.sort(arr,(i1,i2)->i2-i1);

    }

}

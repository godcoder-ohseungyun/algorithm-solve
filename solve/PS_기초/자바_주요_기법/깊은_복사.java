package PS_기초.자바_주요_기법;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 깊은_복사 {
    public static void main(String[] args) {
        int[] arr = new int[5];

        //배열 깊은 복사
        arr.clone();

        List<Integer> list = new LinkedList<>();

        //컬랙션 깊은 복사
        new ArrayList<>(list);
    }
}

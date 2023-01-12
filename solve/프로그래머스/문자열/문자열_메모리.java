package 프로그래머스.문자열;

public class 문자열_메모리 {
    public static void main(String[] args) {

        //리터럴로 생성시 같은 문자열이면 같은 메모리 주소를 가진다 -> 효율적인 메모리 사용
        //이때는 ==, equals 모두 사용 가능하다
        String str1 = "김씨";
        String str2 = "김씨";
        if(str1==str2) System.out.println("Heap 영역의 같은 주소를 참조합니다");
        if(str1.equals(str2)) System.out.println("Heap 영역의 같은 주소를 참조합니다");

        //new String을 사용하여 선언하면 같은 문자열이어도 다른 메모리 주소를 가진다
        //이때는 equals만 사용 가능하다
        String str3 = "김씨";
        String str4 = new String("김씨");
        if(str3.equals(str4)) System.out.println("Heap 영역의 다른 주소를 참조합니다");

        //concat은 메모리를 새로 차지함 -> 여러개의 문자열을 합칠수록 메모리 낭비 심화
        String a = "Hello"; //1000
        String b = "World"; //2000
        String c = "!!"; //3000
        String d = a.concat(b) //4000
                .concat(c); //5000

        //StringBuffer 또는 StringBuilder를 사용하면 메모리를 하나만 사용함 -> 여러개의 문자열을 합칠때 유리
        StringBuilder sb = new StringBuilder(); //4000
        sb.append("Hello"); //1000
        sb.append("World"); //2000
        sb.append("!!"); //3000
        System.out.println(sb);

        //+ 연산에 대한 오해, JDK1.5  이후에 + 연산은 concat을 쓰던 방식에서, append를 쓰는 방식으로 바뀌었다. -> 기존 메모리 낭비 문제 없음, 깊은 복사로 이루어짐

        //StringBuffer 또는 StringBuilder는 같은 값이어도 동등 비교가 불가능하다 -> toString으로 변환 후 비교해야한다
        StringBuffer sb1 = new StringBuffer("gg");
        StringBuffer sb2 = new StringBuffer("gg");
        System.out.println(sb1==sb2);  //false
        System.out.println(sb1.equals(sb2));  //false
        System.out.println(sb1.toString().equals(sb2.toString()));  //true


        //StringBuilder, StringBuffer의 차이
        //StringBuffer는 동기화를 제공하는 대신 속도가 느리고
        //StringBuilder는 동기화를 제공하지 않아 속도가 보다 빠릅니다.
        //멀티쓰레드 환경에서 동시에 객체에 접근하는 경우 StringBuffer를, 아닌 경우에는 StringBuilder를 사용합니다.

        //StringBuffer 또는 StringBuilder append는 깊은 복사로 이뤄진다
        String name = "홍";
        StringBuilder names = new StringBuilder();
        names.append(name);
        System.out.println(names); //홍
        name = "김";
        System.out.println(names); //홍


    }
}

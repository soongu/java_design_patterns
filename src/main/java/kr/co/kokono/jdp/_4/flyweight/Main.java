package kr.co.kokono.jdp._4.flyweight;

/**
 * @Problem
 * 빈번히 사용되는 객체인 String을 보면
 * 최적화가 잘되어 있어야 할 것입니다.
 * 아래 예제에서 s와 s2와 같이 동일한 내용의 문자열일 경우
 * 같은 객체를 제공하지 않는다면 메모리에 동일문자열이
 * 여러개 존재할 것입니다.
 *
 * @Solution
 * 자바에서는 String의 경우 리터럴형식으로
 * 대입했을 때 자바 가상머신은 String Pool에서
 * 이미 동일한 문자열이 있는지 체크한 이후
 * 존재하지 않으면 새로 생성하여 스트링풀에 넣습니다.
 * 그러나 이미 존재한다면 해당 풀에있는 문자열을 주는
 * 방식을 사용합니다.
 *
 * @Conclusion
 * Flyweight란 날아갈 듯한 가벼움을 뜻합니다.
 * 즉, 객체생성이라는 무거운 작업을 덜어버리는 것을 말합니다.
 * 먼저 사용하고자 하는 객체가 있는지를 먼저 검사하고
 * 이미 있다면 이를 참조할 수 있도록 하고 없으면 새로 생성하는 것입니다.
 */
public class Main {

    public static void main(String[] args) {

        String s = "hello";
        String s1 = new String("hello");
        String s2 = "hello";

        System.out.println("s == s1 : " + (s == s1)); // false
        System.out.println("s == s2 : " + (s == s2)); // true
    }

}

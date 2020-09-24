package kr.co.kokono.jdp._5.command.bad;

/**
 * @Problem
 * NotePad 클래스를 보면 오버라이딩한 actionPerformed 메서드에
 * 조건절이 길게 나열된 것을 볼 수 있습니다.
 * 현재 파일탭 메뉴만 나열했는데도 분기가 이렇게 길어졌는데
 * 탭을 추가하면 할수록 조건절은 더 복잡해지고 유지보수에
 * 어려움을 느낄 것입니다.
 *
 * @Solution
 * 이 문제의 근원은 각각의 메뉴 아이템에 따라 기능이 모두
 * 다르다는 것이므로, 기능에 맞는 각각의 메서드를 선언, 구현하고
 * 메서드의 다른 이름을 이용하여 필요 기능을 분기할 수 있도록 합니다.
 * 메뉴에 따라 다른 작업을 수행하더라도 같은 메서드로서 호출되게
 * 하려면 인터페이스가 필요합니다.
 */
public class Main {

    public static void main(String[] args) {
        new NotePad();
    }
}

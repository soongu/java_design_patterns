package kr.co.kokono.jdp._2.prototype_pattern.good1;

/**
 * @benefit
 *
 * 이번 good1패키지 예제에서는 클릭 이벤트에 따라
 * 정렬을 수행할 때 데이터베이스를 통해서 직접 참조하는 것이 아닌
 * 이미 만들어져 있는 원형 객체를 복사하고 있습니다.
 * 호출되는 생성자 내부에서 원형 객체가 복사됨을 확인하세요.
 *
 * 이렇게 하면 같은 정보를 정렬 방식에 따라 정렬하여 사용할 수 있어
 * 매번 데이터 베이스에 접속하는 시간과 그에 따른 자원의 낭비를
 * 줄일 수 있습니다.
 */
public class Main {

    public static void main(String[] args) {
        new AddressBook("Address Book By good1");
    }
}

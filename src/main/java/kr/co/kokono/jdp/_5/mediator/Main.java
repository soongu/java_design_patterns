package kr.co.kokono.jdp._5.mediator;

/**
 * @benefit
 * 이렇게 작성된 메뉴아이템 클래스들은 상호간의 연결관계가 없는,
 * 종속성이 제거된 상태가 되므로 재사용성을 확보할 수 있게되고
 * 또 관련 클래스들이 Mediator 내에서만 연관관계를 갖게 되므로 상대 클래스에
 * 변화에 따른 소스 코드의 수정은 Mediator내부에서만 국한됩니다.
 *
 * 다만, Mediator클래스에 모든 것이 집중되므로 클래스가 복잡해지고
 * 기능이 첨가되는 부작용을 가져올 수 있는 GOD클래스가 될 수 있는 문제점을
 * 내포하고 있으니 사용에 주의해야 합니다.
 */
public class Main {
    public static void main(String[] args) {
        new NotePad();
    }
}

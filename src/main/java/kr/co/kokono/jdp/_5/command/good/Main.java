package kr.co.kokono.jdp._5.command.good;

/**
 * @NewProblem
 * 커맨드 패턴을 이용해 조건 분기문을 제거했으나
 * 한가지 추가적인 문제점을 발견했습니다.

        public NewMenuItem(String s, TextArea text) {
        super(s);
        this.text = text;
        }

 * 이와 같이 특정 객체의 의존성이 높아졌는데요.
 *  NewMenuItem은 TextArea와 강한 의존성이 생겨서
 *  우리는 이 클래스를 메모장 어플리케이션에서밖에 사용할 수 없게 됩니다.
 *  다른 프로그램도 새로운 파일을 만드는 기능이 있어야 한다고할 때
 *  이 클래스를 재활용할 수 없게 됩니다.
 *
 * @Solution
 * 이 문제를 해결하기 위해 마치 부동산 중개업자처럼
 * 매개체 역할을 하는 클래스를 사용하는
 * Mediator패턴에 대해 학습합니다.
 */
public class Main {
    public static void main(String[] args) {
        new NotePad();
    }
}

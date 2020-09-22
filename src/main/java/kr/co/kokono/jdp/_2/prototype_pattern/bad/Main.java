package kr.co.kokono.jdp._2.prototype_pattern.bad;

/**
 * @Problem
 * 정렬 방식을 바꿀 경우 매번 DB에 접속해서 정렬하기 때문에
 * 객체를 지속적으로 생성하는 문제가 있습니다.
 *
 * @Solution
 * 1. 초기에 불러온 회원정보 객체를 클라이언트 측에서 필요에 따라
 *  객체복사하여 원하는 정렬방식으로 정렬하는 것을 대안으로 생각할 수 있습니다.
 *
 * 2. 즉, 서버에서 정렬하는 것이 아닌 클라이언트에서 복사객체를 통한 정렬을
 * 수행하도록 하는 것입니다.
 */
public class Main {
    public static void main(String[] args) {
        new AddressBook("Address Book");
    }
}

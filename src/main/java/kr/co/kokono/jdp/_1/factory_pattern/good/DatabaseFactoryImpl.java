package kr.co.kokono.jdp._1.factory_pattern.good;

public class DatabaseFactoryImpl implements DatabaseFactory {

    private Database db;

    public Database getDatabase() {
//        return new DatabaseImpl();  //생성자가 변경되었다면 아래와 같이 수정
        return new DatabaseImpl("id");
    }
}

package kr.co.kokono.jdp._2.prototype_pattern.good1;

import java.io.*;

/**
 * @explanation
 * 원형 객체를 복사하여 복사본을 반환하는 기능을 가진 클래스
 * 직렬화를 위해 Serializable을 구현
 */
public abstract class Data implements Serializable {

    /**
     * 정렬 조건에 따라 참조하는 회원 정보 객체를 정렬하는 메서드
     */
    public abstract void sort();

    /**
     * @return 참조되고 있는 회원 수를 반환
     */
    public abstract int getSize();

    /**
     * @param index 순번
     * @return  주어진 순번에 해당하는 회원정보 객체 반환
     */
    public abstract Address getAddress(int index);

    /**
     * @param index 순번
     * @return 주어진 순번에 해당하는 회원 이름 반환
     */
    public abstract String getName(int index);

    /**
     * 객체 자신을 복사하여, 복사본을 반환하는 메서드
     */
    public Object myClone() {
        Object obj = null;

        try {
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bao);
            oos.writeObject(this);

            ByteArrayInputStream bai = new ByteArrayInputStream(bao.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bai);
            obj = ois.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return obj;
    }


}

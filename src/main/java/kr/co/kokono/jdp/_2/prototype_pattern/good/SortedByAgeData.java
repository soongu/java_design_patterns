package kr.co.kokono.jdp._2.prototype_pattern.good;

import java.util.Arrays;
import java.util.Vector;

/**
 * 주소록을 나이순으로 정렬하기 위한 클래스
 */
class SortedByAgeData extends Data {

    //복사되어 참조될 data객체
    private Data data;

    //생성된 객체가 원본인지 아니면 복사본인지 구별하기 위한 신호값 (복사본이면 true)
    private boolean flag;

    //주소록 객체를 저장하기 위한 벡터
    protected Vector<Address> addresses;

    public SortedByAgeData() {
    }

    //원형의 최초 객체를 생성할 때 사용.
    public SortedByAgeData(Address[] addresses) {
        this.addresses = new Vector<Address>();
        for (Address address : addresses) {
            this.addresses.addElement(address);
        }
    }

    //원본을 이용하여 복사본 객체를 생성
    public SortedByAgeData(Data data) {
        this.data = (Data) data.myClone();
        flag = true;
    }

    //나이순으로 주소록을 정렬
    @Override
    public void sort() {
        Vector<Address> addresses = new Vector<Address>();

        int size = flag ? this.data.getSize() : this.addresses.size();

        String[] ssns = new String[size];
        for (int i = 0; i < size; i++) {
            Address address = getAddress(i);
            String ssn = address.getSsn();
            ssns[i] = ssn;
        }

        //나이순으로 ssn 정렬
        Arrays.sort(ssns);

        //정렬된 ssn을 기준으로 주소록 정렬
        for (int i = 0; i < size; i++) {
            String ssn = ssns[i];

            for (int j = 0; j < size; j++) {
                Address address = getAddress(j);
                String _ssn = address.getSsn();
                if (ssn.equals(_ssn)) {
                    addresses.add(i, address);
                }
            }
        }
        this.addresses = addresses;
        flag = false;
    }

    @Override
    public int getSize() {
        int size = flag ? data.getSize() : addresses.size();
        return size;
    }

    @Override
    public Address getAddress(int index) {
        Address address = flag ? this.data.getAddress(index) : this.addresses.elementAt(index);
        return address;
    }

    @Override
    public String getName(int index) {
        Address address = flag ? this.data.getAddress(index) : this.addresses.elementAt(index);
        return address.getName();
    }
}

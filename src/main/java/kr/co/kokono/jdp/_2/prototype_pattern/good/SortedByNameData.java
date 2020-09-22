package kr.co.kokono.jdp._2.prototype_pattern.good;

import java.util.Arrays;
import java.util.Vector;

public class SortedByNameData extends SortedByAgeData {

    //복사되어 참조될 객체
    private Data data;

    //객체를 복사함
    public SortedByNameData(Data data) {
        this.data = (Data) data.myClone();
    }

    //이름을 기준으로 주소록을 정렬
    @Override
    public void sort() {
        Vector<Address> addresses = new Vector<Address>();

        String[] names = new String[data.getSize()];
        for (int i = 0; i < data.getSize(); i++) {
            Address address = data.getAddress(i);
            names[i] = address.getName();
        }

        //이름 순으로 names 정렬
        Arrays.sort(names);

        //정렬된 ssn을 기준으로 주소록 정렬
        for (int i = 0; i < data.getSize(); i++) {
            String name = names[i];

            for (int j = 0; j < data.getSize(); j++) {
                Address address = data.getAddress(j);
                String _name = address.getName();
                if (name.equals(_name)) {
                    addresses.add(i, address);
                }
            }
        }
        this.addresses = addresses;
    }
}

package kr.co.kokono.jdp._2.prototype_pattern.good;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class AddressBook implements ActionListener {

    private Frame frame;
    private Panel south;
    private List list;
    private Button age, name, tel;
    private ExpensiveDatabase edb;

    //good1 : 추가된 코드
    private Data data;

    //정렬 방식 구분 코드값
    public static final int DEFAULT = 0, AGE = 1, NAME = 2, TEL = 3;

    private Address[] addresses;

    public AddressBook(String str) {
        frame = new Frame(str);
        south = new Panel();
        south.setLayout(new GridLayout(1, 3));

        list = new List();

        age = new Button("Age");
        name = new Button("Name");
        tel = new Button("Tel");

        age.addActionListener(this);
        name.addActionListener(this);
        tel.addActionListener(this);

        south.add(age);
        south.add(name);
        south.add(tel);

        frame.add(list);
        frame.add(south, BorderLayout.SOUTH);
        frame.setVisible(true);
        frame.setBounds((1280-150)/2, (1024-200)/2, 150, 200);
        frame.addWindowListener(
                new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                }
        );

        //데이터베이스 객체 생성
        edb = new ExpensiveDatabase("localhost");

        //최초는 디폴트로 정렬
        this.addresses = edb.getAllAddresses(DEFAULT);

        //good1 : 추가된코드
        //원본 객체를 생성함
        this.data = new SortedByAgeData(this.addresses);

        show();
    }

    public void actionPerformed(ActionEvent e) {

        Button button = (Button) e.getSource();

        //나이순
        if (button == age) {
            this.data = new SortedByAgeData(data);
        //이름순
        } else if(button == name) {
            this.data = new SortedByNameData(data);

        //전화번호순
        } else if(button == tel) {
            this.data = new SortedByTelData(data);
        }

        show();
    }

    public void show() {
        list.removeAll();

        //good1: 추가된 코드
        //복사된 객체를 정렬 방식에 따라 정렬
        this.data.sort();

        //good1: 추가된 코드
        for (int i = 0; i < data.getSize(); i++) {

            Address address = data.getAddress(i);

            String gender = address.getGender() == 1 ? "M" : "W";
            String printData = address.getSsn() + " " + address.getName() + " \t"
                    + address.getTel() + " " + address.getAddress() + " " + gender;

            list.add(printData);
        }
    }


}

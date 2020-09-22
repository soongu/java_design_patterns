package kr.co.kokono.jdp._2.prototype_pattern.bad;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @sql

    create table address (
    ssn char(6) primary key,
    name char(10) not null,
    tel char(12) not null,
    address char(10) not null,
    gender int not null
    );

    insert into address values ('701212', 'kimch', '12345645', 'seoul', 1);
    insert into address values ('741218', 'parkch', '55442165', 'texas', 1);
    insert into address values ('780506', 'parksl', '6532312', 'daejeon', 2);
    insert into address values ('851213', 'parkmh', '35445223', 'tokyo', 2);
    insert into address values ('669904', 'songnr', '65830102', 'incheon', 2);
    insert into address values ('690603', 'kimbk', '55472193', 'daegoo', 1);
    insert into address values ('001019', 'kimsw', '9731334', 'woolsan', 1);
    insert into address values ('950630', 'seojw', '31578830', 'pocheon', 1);
    insert into address values ('650402', 'choihs', '60460102', 'guri', 1);
    insert into address values ('451125', 'leesw', '66698773', 'ilsan', 1);
    insert into address values ('500525', 'jojh', '26954383', 'suwon', 1);
    insert into address values ('530714', 'icho', '34875334', 'la', 1);
 */
class Address {

    private String ssn;
    private String name;
    private String tel;
    private String address;
    private int gender;

    public Address() {}

    public Address(ResultSet rs) throws SQLException {
        this.ssn = rs.getString("ssn");
        this.name = rs.getString("name");
        this.tel = rs.getString("tel");
        this.address = rs.getString("address");
        this.gender = rs.getInt("gender");
    }



    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}

package kr.co.kokono.jdp._1.factory_pattern.good;

import java.sql.Connection;

public interface Database {
    Connection getConnection();
}

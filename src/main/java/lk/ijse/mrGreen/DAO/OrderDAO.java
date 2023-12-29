package lk.ijse.mrGreen.DAO;

import lk.ijse.mrGreen.db.DbConnection;

import java.sql.*;
import java.time.LocalDate;

public interface OrderDAO {
     String genarateOrderId() throws SQLException ;


     boolean saveOrder(String oId, String cusId, LocalDate date) throws SQLException ;

     int getOrderCount() throws SQLException ;
}

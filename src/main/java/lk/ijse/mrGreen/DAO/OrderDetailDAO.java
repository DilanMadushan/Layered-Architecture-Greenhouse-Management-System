package lk.ijse.mrGreen.DAO;

import lk.ijse.mrGreen.db.DbConnection;
import lk.ijse.mrGreen.dto.tm.CartTm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public interface OrderDetailDAO {
    boolean saveOrderDetails(String orderId, List<CartTm> cartTmList) throws SQLException;

    boolean saveOrderDetail(String orderId, CartTm tm) throws SQLException ;
}

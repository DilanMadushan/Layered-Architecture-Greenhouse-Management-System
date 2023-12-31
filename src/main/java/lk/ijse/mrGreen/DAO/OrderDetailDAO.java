package lk.ijse.mrGreen.DAO;

import lk.ijse.mrGreen.db.DbConnection;
import lk.ijse.mrGreen.dto.OrderDetailsDto;
import lk.ijse.mrGreen.dto.tm.CartTm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public interface OrderDetailDAO extends CrudDao <OrderDetailsDto> {

//    boolean saveOrderDetails(OrderDetailsDto orderDetailsDto) throws SQLException;

    boolean saveOrderDetail(String orderId, CartTm tm) throws SQLException ;
}

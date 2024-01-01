package lk.ijse.mrGreen.DAO.Custom;

import lk.ijse.mrGreen.DAO.CrudDao;
import lk.ijse.mrGreen.db.DbConnection;
import lk.ijse.mrGreen.dto.OrderDto;

import java.sql.*;
import java.time.LocalDate;

public interface OrderDAO extends CrudDao<OrderDto> {
     String genarateOrderId() throws SQLException ;

//     boolean saveOrder(OrderDto orderDto) throws SQLException ;
//
//     int getOrderCount() throws SQLException ;
}

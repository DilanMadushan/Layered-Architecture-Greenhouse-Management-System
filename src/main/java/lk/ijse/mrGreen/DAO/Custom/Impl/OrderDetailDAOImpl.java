package lk.ijse.mrGreen.DAO.Custom.Impl;

import lk.ijse.mrGreen.DAO.Custom.OrderDetailDAO;
import lk.ijse.mrGreen.DAO.SQLUtil;
import lk.ijse.mrGreen.db.DbConnection;
import lk.ijse.mrGreen.dto.OrderDetailsDto;
import lk.ijse.mrGreen.dto.tm.CartTm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO {

    SQLUtil sqlUtil = new SQLUtil();
    public boolean save(OrderDetailsDto orderDetailsDto) throws SQLException {
        for (CartTm tm: orderDetailsDto.getCartTmList()) {
            if(!saveOrderDetail(orderDetailsDto.getOrderId(),tm)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(OrderDetailsDto dto) throws SQLException {
        return false;
    }

    @Override
    public List<OrderDetailsDto> loadAll() throws SQLException {
        return null;
    }

    @Override
    public int getCount() throws SQLException {
        return 0;
    }

    @Override
    public String getName(String id) throws SQLException {
        return null;
    }

    @Override
    public OrderDetailsDto search(String cusId) throws SQLException {
        return null;
    }

    public boolean saveOrderDetail(String orderId, CartTm tm) throws SQLException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "INSERT INTO order_details VALUES (?,?,?,?,?)";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//
//        pstm.setString(1,orderId);
//        pstm.setString(2,tm.getId());
//        pstm.setDouble(3,tm.getQty());
//        pstm.setDouble(4,tm.getUnit());
//        pstm.setDouble(5,tm.getQty()*tm.getUnit());
//
//        return pstm.executeUpdate() >0;

        return sqlUtil.execute("INSERT INTO order_details VALUES (?,?,?,?,?)",
                orderId,tm.getId(),tm.getQty(),tm.getUnit(),tm.getQty()*tm.getUnit());

    }
}

package lk.ijse.mrGreen.DAO.Custom.Impl;

import lk.ijse.mrGreen.DAO.Custom.OrderDAO;
import lk.ijse.mrGreen.DAO.SQLUtil;
import lk.ijse.mrGreen.db.DbConnection;
import lk.ijse.mrGreen.dto.LettuceDto;
import lk.ijse.mrGreen.dto.OrderDto;

import java.sql.*;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    SQLUtil sqlUtil = new SQLUtil();
    public String genarateOrderId() throws SQLException {
//        Connection connection = DbConnection.getInstance().getConnection();
//        String sql = "SELECT order_id FROM orders ORDER BY order_id DESC LIMIT 1";
//        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = sqlUtil.execute( "SELECT order_id FROM orders ORDER BY order_id DESC LIMIT 1");

        if(resultSet.next()){
            return splitOrderId(resultSet.getString(1));
        }
        return splitOrderId(null);
    }

    private String splitOrderId(String currentId) {
        if(currentId != null) {
            String[] strings = currentId.split("O0");
            int id = Integer.parseInt(strings[1]);
            id++;
            String ID = String.valueOf(id);
            int length = ID.length();
            if (length < 2){
                return "O00"+id;
            }else {
                if (length < 3){
                    return "O0"+id;
                }else {
                    return "O"+id;
                }
            }
        }
        return "O001";
    }

    public boolean save(OrderDto orderDto) throws SQLException {
        //System.out.println(oId+""+cusId+""+date);
//        Connection connection = DbConnection.getInstance().getConnection();
//        String sql = "INSERT INTO orders VALUES(?,?,?)";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//
//        pstm.setString(1,orderDto.getOrderId());
//        pstm.setString(2,orderDto.getCusId());
//        pstm.setDate(3, Date.valueOf(orderDto.getDate()));
//
//        try {
//            return pstm.executeUpdate() > 0;
//        }catch (Exception e){
//
//        }

        return sqlUtil.execute("INSERT INTO orders VALUES(?,?,?)",
                orderDto.getOrderId(),orderDto.getCusId(),Date.valueOf(orderDto.getDate()));
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(OrderDto dto) throws SQLException {
        return false;
    }

    @Override
    public List<OrderDto> loadAll() throws SQLException {
        return null;
    }

    public int getCount() throws SQLException {
//        Connection connection = DbConnection.getInstance().getConnection();
//        String sql ="SELECT COUNT(*) AS num_of_orders FROM orders";
//        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet=sqlUtil.execute("SELECT COUNT(*) AS num_of_orders FROM orders");

        resultSet.next();

        int count = resultSet.getInt("num_of_orders");
        return count;
    }

    @Override
    public String getName(String id) throws SQLException {
        return null;
    }

    @Override
    public OrderDto search(String cusId) throws SQLException {
        OrderDto dto = null;

        ResultSet resultSet = sqlUtil.execute("SELECT * FROM orders WHERE order_id = ?");
        if(resultSet.next()){
            dto = new OrderDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDate(3).toLocalDate()
            );
        }
        return dto;
    }
}

package lk.ijse.mrGreen.DAO;

import lk.ijse.mrGreen.db.DbConnection;
import lk.ijse.mrGreen.dto.OrderDto;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    public String genarateOrderId() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT order_id FROM orders ORDER BY order_id DESC LIMIT 1";
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

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
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "INSERT INTO orders VALUES(?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1,orderDto.getOrderId());
        pstm.setString(2,orderDto.getCusId());
        pstm.setDate(3, Date.valueOf(orderDto.getDate()));

        try {
            return pstm.executeUpdate() > 0;
        }catch (Exception e){

        }
        return false;
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
        Connection connection = DbConnection.getInstance().getConnection();
        String sql ="SELECT COUNT(*) AS num_of_orders FROM orders";
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet=pstm.executeQuery();

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
        return null;
    }
}

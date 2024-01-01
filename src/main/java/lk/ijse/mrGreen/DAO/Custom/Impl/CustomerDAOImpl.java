package lk.ijse.mrGreen.DAO.Custom.Impl;

import javafx.scene.control.Alert;
import lk.ijse.mrGreen.DAO.Custom.CustomerDAO;
import lk.ijse.mrGreen.DAO.SQLUtil;
import lk.ijse.mrGreen.db.DbConnection;
import lk.ijse.mrGreen.dto.CustomerDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    SQLUtil sqlUtil = new SQLUtil();
    public boolean save(CustomerDto dto) throws SQLException {
//        Connection connection = DbConnection.getInstance().getConnection();
//        String sql = "INSERT INTO customer VALUES(?,?,?,?)";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//
//        pstm.setString(1,dto.getId());
//        pstm.setString(2,dto.getName());
//        pstm.setString(3,dto.getAddress());
//        pstm.setString(4,dto.getTel());
//
//        try{
//            return pstm.executeUpdate() > 0;
//        }catch (Exception e){
//
//        }
//        return false;
        CustomerDto set = search(dto.getId());
        if(set!=null){
            return false;
        }else {
            return sqlUtil.execute("INSERT INTO customer VALUES(?,?,?,?)",dto.getId(),dto.getName(),dto.getAddress(),dto.getTel());
        }

    }

    public boolean delete(String id) throws SQLException {
//        Connection connection = DbConnection.getInstance().getConnection();
//        String sql = "DELETE FROM customer WHERE cus_id = ?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//
//        pstm.setString(1,id);
//
//        try{
//            return pstm.executeUpdate() > 0;
//        }catch (Exception e){
//
//        }
//        return false;
        return sqlUtil.execute("DELETE FROM customer WHERE cus_id = ?",id);
    }

    public boolean update(CustomerDto dto) throws SQLException {
//        Connection connection = DbConnection.getInstance().getConnection();
//        String sql = "UPDATE customer SET name = ?, address = ?, tel = ? WHERE cus_id = ?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//
//        pstm.setString(1,dto.getName());
//        pstm.setString(2,dto.getAddress());
//        pstm.setString(3, dto.getTel());
//        pstm.setString(4,dto.getId());
//
//        try{
//            return pstm.executeUpdate() > 0;
//        }catch (Exception e){
//
//        }
//        return false;
        
        return sqlUtil.execute("UPDATE customer SET name = ?, address = ?, tel = ? WHERE cus_id = ?",dto.getName(),dto.getAddress(),dto.getTel(),dto.getId());
    }

    public List<CustomerDto> loadAll() throws SQLException {
//        Connection connection = DbConnection.getInstance().getConnection();
//        String sql = "SELECT * FROM customer";
//        PreparedStatement pstm=connection.prepareStatement(sql);
//
//        ArrayList<CustomerDto> dto = new ArrayList<>();
//
//        ResultSet resultSet = pstm.executeQuery();
//
//        while (resultSet.next()){
//            dto.add(new CustomerDto(
//                    resultSet.getString(1),
//                    resultSet.getString(2),
//                    resultSet.getString(3),
//                    resultSet.getString(4)
//            ));
//        }
//        return dto;

        ResultSet resultSet = sqlUtil.execute("SELECT * FROM customer");

        ArrayList<CustomerDto> dto = new ArrayList<>();

        while (resultSet.next()){
            dto.add(new CustomerDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)
            ));
        }
        return dto;
        
    }

    public int getCount() throws SQLException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "SELECT COUNT(*) AS num_Customer FROM customer";
//        PreparedStatement pstm =connection.prepareStatement(sql);
//
//        ResultSet resultSet = pstm.executeQuery();
//
//        resultSet.next();
//
//        int count = resultSet.getInt("num_Customer");
//
//        return count;
        
        ResultSet resultSet = sqlUtil.execute("SELECT COUNT(*) AS num_Customer FROM customer");

        resultSet.next();

        return resultSet.getInt("num_Customer");
    }

    public String getName(String id) throws SQLException {
//        Connection connection = DbConnection.getInstance().getConnection();
//        String sql = "SELECT name FROM customer WHERE cus_id = ?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//
//        pstm.setString(1,id);
//
//        ResultSet resultSet = pstm.executeQuery();

        ResultSet resultSet = sqlUtil.execute( "SELECT name FROM customer WHERE cus_id = ?",id);

        if(resultSet.next()){
            return resultSet.getString("name");
        }
        return null;
    }

    public CustomerDto search(String cusId) throws SQLException {
//        Connection connection = DbConnection.getInstance().getConnection();
//        String sql ="SELECT * FROM customer WHERE cus_id = ?";
//
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setString(1,cusId);
//
//        ResultSet resultSet=pstm.executeQuery();
//
//        CustomerDto dto = null;
//
//        if(resultSet.next()){
//            dto = new CustomerDto(
//                    resultSet.getString(1),
//                    resultSet.getString(2),
//                    resultSet.getString(3),
//                    resultSet.getString(4)
//            );
//        }
//        return dto;

        
      ResultSet resultSet = sqlUtil.execute("SELECT * FROM customer WHERE cus_id = ?",cusId);
      
      CustomerDto dto = null;

        if(resultSet.next()){
            dto = new CustomerDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)
            );
        }
        return dto;
    }

}

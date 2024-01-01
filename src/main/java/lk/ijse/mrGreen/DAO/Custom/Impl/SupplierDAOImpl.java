package lk.ijse.mrGreen.DAO.Custom.Impl;

import lk.ijse.mrGreen.DAO.Custom.SupplierDAO;
import lk.ijse.mrGreen.DAO.SQLUtil;
import lk.ijse.mrGreen.db.DbConnection;
import lk.ijse.mrGreen.dto.SupplierDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAOImpl implements SupplierDAO {

    SQLUtil sqlUtil = new SQLUtil();
    public List<SupplierDto> loadAll() throws SQLException {

//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "SELECT * FROM supplier";
//        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = sqlUtil.execute("SELECT * FROM supplier");

        List<SupplierDto> supList = new ArrayList<>();

        while (resultSet.next()){
            supList.add(new SupplierDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            ));

        }

        return supList;
    }

    public boolean save(SupplierDto dto) throws SQLException {
//        Connection connection = DbConnection.getInstance().getConnection();
//        String sql = "INSERT INTO supplier VALUES(?,?,?,?,?)";
//
//        PreparedStatement pstm = connection.prepareStatement(sql);
//
//        pstm.setString(1,dto.getSup_id());
//        pstm.setString(2,dto.getName());
//        pstm.setString(3, dto.getCompany());
//        pstm.setString(4,dto.getTel());
//        pstm.setString(5,dto.getUser_id());
//
//        try {
//            return pstm.executeUpdate() > 0;
//        }catch (Exception e){
//
//        }
//        return false;

        Object object = search(dto.getSup_id());

        if(object!=null){
            return false;
        }else {
            return sqlUtil.execute("INSERT INTO supplier VALUES(?,?,?,?,?)",dto.getSup_id(),dto.getName(),
                    dto.getCompany(),dto.getTel(),dto.getUser_id());
        }

    }

    public boolean delete(String id) throws SQLException {
//        Connection connection = DbConnection.getInstance().getConnection();
//        String sql = "DELETE FROM supplier WHERE sup_id = ?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//
//        pstm.setString(1,id);
//
//        return pstm.executeUpdate() > 0;

        return sqlUtil.execute("DELETE FROM supplier WHERE sup_id = ?",id);
    }

    public boolean update(SupplierDto dto) throws SQLException {
//        Connection connection = DbConnection.getInstance().getConnection();
//        String sql = "UPDATE supplier SET name = ?, company = ?, tel = ?, user_id = ? WHERE sup_id =?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//
//        pstm.setString(1,dto.getName());
//        pstm.setString(2, dto.getCompany());
//        pstm.setString(3,dto.getTel());
//        pstm.setString(4,dto.getUser_id());
//        pstm.setString(5,dto.getSup_id());

        return sqlUtil.execute("UPDATE supplier SET name = ?, company = ?, tel = ?, user_id = ? WHERE sup_id =?",
                dto.getName(),dto.getCompany(),dto.getTel(),dto.getUser_id(),dto.getSup_id());
    }

    public int getCount() throws SQLException {
//        Connection connection = DbConnection.getInstance().getConnection();
//        String sql ="SELECT COUNT(*)As sup_count from supplier";
//        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = sqlUtil.execute("SELECT COUNT(*)As sup_count from supplier");

        resultSet.next();

        int count = resultSet.getInt("sup_count");
        return count;
    }

    @Override
    public String getName(String id) throws SQLException {
        return null;
    }

    public SupplierDto search(String suppId) throws SQLException {
//        Connection connection =DbConnection.getInstance().getConnection();
//        String sql = "SELECT * FROM supplier WHERE sup_id = ?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//
//        pstm.setString(1,suppId);

        ResultSet resultSet = sqlUtil.execute("SELECT * FROM supplier WHERE sup_id = ?",suppId);

        SupplierDto dto = null;

        if(resultSet.next()){
            dto = new SupplierDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            );
        }
        return dto;
    }
}
